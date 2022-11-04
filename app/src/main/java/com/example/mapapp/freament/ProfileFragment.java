package com.example.mapapp.freament;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.mapapp.R;
import com.example.mapapp.activity.LoginActivity;
import com.example.mapapp.base.BaseFragment;
import com.example.mapapp.bean.PersonBean;
import com.example.mapapp.bean.RestBean;
import com.example.mapapp.tool.SharePerferenceUtils;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    GoogleSignInOptions mGoogleSignInOptions;
    GoogleSignInClient mGoogleSignInClient;
    FirebaseUser currentUser;
    StorageReference storageRef = FirebaseStorage.getInstance().getReferenceFromUrl("gs://villageplanner-315cd.appspot.com");

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_profile;
    }

    @Override
    protected void init() {
        mIvHead = (ImageView) findView(R.id.mIvHead);
        mTvName = (TextView) findView(R.id.mTvName);
        mTvEmail = (TextView) findView(R.id.mTvEmail);

        mGoogleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(getContext(), mGoogleSignInOptions);

        // mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            mTvName.setText(currentUser.getDisplayName());
            mTvEmail.setText(currentUser.getEmail());
            // mIvHead.setImageURI(Uri.parse("http://tny.im/tHM"));
            // mIvHead.setOnClickListener(view -> addData());
            if(currentUser.getPhotoUrl() != null) {
                storageRef.child(currentUser.getDisplayName()).child("profile.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.with(getContext()).load(uri).into(mIvHead);
                        mIvHead.setBackground(null);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });

                // mIvHead.setBackgroundColor("white");
                // mIvHead.setImageURI(currentUser.getPhotoUrl());
            }
            findView(R.id.logout).setOnClickListener(view -> logout());
            findView(R.id.mIvHead).setOnClickListener(view -> changeProfileImage());
            return;
        }

        Glide.with(getActivity()).load(SharePerferenceUtils.getString(getActivity(),"PhotoUrl","")).into(mIvHead);
        mTvName.setText(SharePerferenceUtils.getString(getActivity(),"DisplayName",""));
        mTvEmail.setText(SharePerferenceUtils.getString(getActivity(),"Email",""));

        // mIvHead.setOnClickListener(view -> addData());
        findView(R.id.logout).setOnClickListener(view -> logout());
        findView(R.id.mIvHead).setOnClickListener(view -> changeProfileImage());
    }

    private void changeProfileImage() {
        Intent openGalleryIntent = new Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(openGalleryIntent, 1000);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (resultCode == Activity.RESULT_OK) {
                Uri imageUri = data.getData();
                mIvHead.setImageURI(imageUri);
                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                        .setPhotoUri(imageUri)
                        .build();

                currentUser.updateProfile(profileUpdates)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Log.d("===", "User profile updated.");
                                }
                            }
                        });
                StorageReference fileref = storageRef.child(currentUser.getDisplayName()).child("profile.jpg");
                fileref.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // add a toast
                        Toast.makeText(getContext(), "Image Uploaded Successfully.",
                                Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // add a toast
                        Toast.makeText(getContext(), "Image Uploaded Unsuccessfully. Please Reselect.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
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

        // store reminders into the firebase
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
            GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getContext());
            if (account != null) {
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
