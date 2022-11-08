package com.example.mapapp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mapapp.R;
import com.example.mapapp.base.BaseActivity;
import com.example.mapapp.tool.SharePerferenceUtils;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;
    protected EditText mEtPw1, mEtEmail1;
    private Bundle savedInstanceState;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null)

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            FirebaseAuth.getInstance().signOut();
        }
        /*
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if (account != null) {
            mGoogleSignInClient.signOut().addOnCompleteListener(this,
                    new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                        }
                    });
        }
        */
        Context context = getApplicationContext();
        List<String> arrivalList = new ArrayList<>();
        List<String> times = new ArrayList<>();
        List<String> restNameList = new ArrayList<>();
        SharePerferenceUtils.putStringList(context,"times",times);
        SharePerferenceUtils.putStringList(context,"restName",restNameList);
        SharePerferenceUtils.putStringList(context,"arrivalTime",arrivalList);
        SharePerferenceUtils.putString(context, "reminderInit", "false");
    }


    @OnClick({R.id.sign_in_button})
    public void click(View view){
        switch (view.getId()) {
        }
    }
    private Button mBtnRegister, mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mBtnRegister = (Button) findViewById(R.id.mBtnRegister1);
        mBtnLogin = (Button) findViewById(R.id.mBtnLogin1);
        mBtnRegister.setOnClickListener(this);
        mBtnLogin.setOnClickListener(this);
        this.mEtPw1 = (EditText) findViewById(R.id.mEtPw1);
        this.mEtEmail1 = (EditText) findViewById(R.id.mEtEmail1);
        findViewById(R.id.sign_in_button).setOnClickListener(this);
        findViewById(R.id.mEtPw1).setOnClickListener(this);
        findViewById(R.id.mEtEmail1).setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();

        //google login setting
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestId()
                .requestProfile()
                .requestIdToken(getString(R.string.web_client_id))
                .requestEmail() //可以获取到邮箱信息【这一步还挺有必要，不光可以获取到邮箱信息
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
    }

    private String email, password;
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            /*
            case R.id.mEtPw1:
                password = this.mEtPw1.getText().toString();
            case R.id.mEtEmail1:
                email = this.mEtEmail1.getText().toString();
             */
            case R.id.sign_in_button:
                Intent intent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(intent, 1);
                break;
            case R.id.mBtnRegister1:
                Intent jumpIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(jumpIntent);
                break;
            case R.id.mBtnLogin1:
                password = this.mEtPw1.getText().toString();
                email = this.mEtEmail1.getText().toString();
                if (email != null && password != null && !email.isEmpty() && !password.isEmpty()) {
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success
                                        Log.d("===", "signInWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();

                                        // user.getEmail()
                                        Intent intent2 = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent2);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w("===", "signInWithEmail:failure", task.getException());
                                        Context context = getApplicationContext();
                                        Toast.makeText(context, "Wrong or Unregistered Email/Password.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
                else {
                    Log.w("===", "createUserWithEmail:failure");
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Login failed (Empty Field(s)).",
                            Toast.LENGTH_SHORT).show();
                }

        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> task){
        SharePerferenceUtils.putString(this,"Email",task.getResult().getEmail());
        SharePerferenceUtils.putString(this,"PhotoUrl",task.getResult().getPhotoUrl().toString());
        SharePerferenceUtils.putString(this,"DisplayName",task.getResult().getDisplayName());

        Intent intent3 = new Intent(this, MainActivity.class);
        startActivity(intent3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode != 0) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                handleSignInResult(task);
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(),"Login Unsuccessful", Toast.LENGTH_SHORT).show();
            }
        }

        else if(requestCode == 1) {
            assert data != null;
            showToast(data.toString());
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
