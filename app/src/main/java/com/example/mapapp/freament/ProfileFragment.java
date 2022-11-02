package com.example.mapapp.freament;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.mapapp.R;
import com.example.mapapp.activity.LoginActivity;
import com.example.mapapp.base.BaseFragment;
import com.example.mapapp.bean.PersonBean;
import com.example.mapapp.bean.RestBean;
import com.example.mapapp.tool.SharePerferenceUtils;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

public class ProfileFragment extends BaseFragment {
    private ImageView mIvHead;
    private TextView mTvName,mTvEmail;
    private Button logout;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("data");
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_profile;
    }

    @Override
    protected void init() {
        mIvHead = (ImageView) findView(R.id.mIvHead);
        mTvName = (TextView) findView(R.id.mTvName);
        mTvEmail = (TextView) findView(R.id.mTvEmail);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            mTvName.setText(currentUser.getDisplayName());
            mTvEmail.setText(currentUser.getEmail());
            mIvHead.setImageURI(currentUser.getPhotoUrl());
            // mIvHead.setOnClickListener(view -> addData());
            findView(R.id.logout).setOnClickListener(view -> logout());
            return;
        }

        Glide.with(getActivity()).load(SharePerferenceUtils.getString(getActivity(),"PhotoUrl","")).into(mIvHead);
        mTvName.setText(SharePerferenceUtils.getString(getActivity(),"DisplayName",""));
        mTvEmail.setText(SharePerferenceUtils.getString(getActivity(),"Email",""));

        // mIvHead.setOnClickListener(view -> addData());
        findView(R.id.logout).setOnClickListener(view -> logout());
    }

    private void logout() {
        List<String> arrivalList = SharePerferenceUtils.getStringList(getContext(),"arrivalTime");
        List<String> times = SharePerferenceUtils.getStringList(getContext(),"times");
        List<String> restNameList = SharePerferenceUtils.getStringList(getContext(),"restName");

        Gson gson = new Gson();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        DatabaseReference reminderRef = ref.child("reminders");
        DatabaseReference userReminderRef = null;
        if(currentUser != null){
            userReminderRef = reminderRef.child(currentUser.getDisplayName().toString());
        }
        else {
            userReminderRef = reminderRef.child(SharePerferenceUtils.getString(getActivity(),"DisplayName",""));
        }

        Map<String,String> map = new HashMap<>();
        map.put("times", gson.toJson(times));
        map.put("restName", gson.toJson(restNameList));
        map.put("arrivalTime", gson.toJson(arrivalList));
        // add current user
        userReminderRef.setValue(map);

        // sign out google account user
        if(currentUser != null){
            FirebaseAuth.getInstance().signOut();
        }
        else {
            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .build();
            mGoogleSignInClient = GoogleSignIn.getClient(getContext(), gso);
            mGoogleSignInClient.signOut()
                    .addOnCompleteListener(getActivity(), new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            // ...
                        }
                    });
            mGoogleSignInClient.revokeAccess()
                    .addOnCompleteListener(getActivity(), new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            // ...
                        }
                    });

        }
        Intent intent= new Intent(getContext(), LoginActivity.class);
        startActivity(intent);
    }

    private void addData(){
        List<RestBean> list = new ArrayList<>();
        list.add(new RestBean("CAVA","3201 S Hoover St Suite 1840, Los Angeles, CA 90089",34.025821775294204, -118.28505440744799));
        list.add(new RestBean("Greenleaf Kitchen & Cocktails","929 W Jefferson Blvd #1650, Los Angeles, CA 90089",34.02474079953199,-118.28528325248934));
        list.add(new RestBean("Chinese Street Food","3201 S Hoover St #1870, Los Angeles, CA 90007",34.02465643138648,-118.28398648508674));
        list.add(new RestBean("Il Giardino Ristorante","3201 S Hoover St #1850, Los Angeles, CA 90089",34.025330990643525,-118.28434297834089));
        list.add(new RestBean("Honeybird","3201 S Hoover St #1835, Los Angeles, CA 90089",34.024904175743075,-118.28441808019377));
        list.add(new RestBean("City Tacos","3201 S Hoover St #1870, Los Angeles, CA 90007",34.02426427775233,-118.2844844611436));
        list.add(new RestBean("DULCE","3096 McClintock Ave Ste 1420, Los Angeles, CA 90007",34.02561669173768,-118.28516860388257));
        list.add(new RestBean("Fruit + Candy","3201 S Hoover St #1815, Los Angeles, CA 90089",34.0246011481783,-118.28421080203752));
        list.add(new RestBean("Insomnia Cookies","929 W Jefferson Blvd # 1620, Los Angeles CA 90089",34.025191020187506,-118.28531291510147));
        list.add(new RestBean("Kobunga Korean Grill","929 W. Jefferson Blvd Suite 1610, Los Angeles, CA 90007",34.02475834463438,-118.28523987092082));

        List<PersonBean> personBeanList = new ArrayList<>();

        personBeanList.add(new PersonBean("tom",34.02468029012595,-118.2855711093449));
        personBeanList.add(new PersonBean("jerry",34.025066786661604, -118.2845280792272));
        // cava
        personBeanList.add(new PersonBean("mark",34.025821775294204,  -118.28505440744799));
        personBeanList.add(new PersonBean("dan",34.025821775294204,  -118.28505440744799));
        // insomnia cookie
        personBeanList.add(new PersonBean("james", 34.025191020187506, -118.28531291510147));
        // city taco
        personBeanList.add(new PersonBean("tim", 34.02426427775233,-118.2844844611436));
        // green leaf
        personBeanList.add(new PersonBean("tommy", 34.02474079953199,-118.28528325248934));
        // Il giardinao ristorante
        personBeanList.add(new PersonBean("trojan", 34.025330990643525,-118.28434297834089));

        DatabaseReference defRestaurantRef = ref.child("def_data");
        Map<String,String> map = new HashMap<>();
        map.put("restaurant",gson.toJson(list));
        map.put("person",gson.toJson(personBeanList));
        defRestaurantRef.setValue(map);
    }
}
