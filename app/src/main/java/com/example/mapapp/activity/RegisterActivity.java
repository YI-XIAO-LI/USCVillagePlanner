package com.example.mapapp.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;

import com.example.mapapp.R;
import com.example.mapapp.base.BaseActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private Button mBtnRegister, mBtnLogin;
    protected EditText mEtEmail, mEtName, mEtPw;
    private Bundle savedInstanceState;
    private FirebaseAuth mAuth;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void init() {
        // mAuth = FirebaseAuth.getInstance();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mBtnRegister = (Button) findViewById(R.id.mBtnRegister);
        mBtnLogin = (Button) findViewById(R.id.mBtnLogin);
        mEtName = (EditText) findViewById(R.id.mEtName);
        mEtEmail = (EditText) findViewById(R.id.mEtEmail);
        mEtPw = (EditText) findViewById(R.id.mEtPw);

        // set onclick listeners for all fields
        mBtnRegister.setOnClickListener(this);
        mBtnLogin.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.mBtnLogin:
                // jump to the login page if registration finished
                Intent jumptoLoginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(jumptoLoginIntent);
                break;
            case R.id.mBtnRegister:
                // Bitmap img = ((BitmapDrawable) image.getDrawable()).getBitmap();
                String name = this.mEtName.getText().toString();
                String email = this.mEtEmail.getText().toString();
                String password = this.mEtPw.getText().toString();
                // Uri uri = Uri.parse(image);
                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                    if (!email.contains(".com") || !email.contains("@")){
                        Log.w("===", "createUserWithEmail:failure");
                        Context context = getApplicationContext();
                        Toast.makeText(context, "Invalid Email.",
                                Toast.LENGTH_SHORT).show();
                        break;
                    }
                    else if (password.length() < 6) {
                        Log.w("===", "createUserWithEmail:failure");
                        Context context = getApplicationContext();
                        Toast.makeText(context, "Password needs to be at least 6 char.",
                                Toast.LENGTH_SHORT).show();
                        break;
                    }
                    // store in firebase
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d("===", "createUserWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Context context = getApplicationContext();
                                        Toast.makeText(context, "Registration Successful.",
                                                Toast.LENGTH_SHORT).show();
                                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                                .setDisplayName(name)
                                                .build();

                                        user.updateProfile(profileUpdates)
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            Log.d("===", "User profile updated.");
                                                        }
                                                    }
                                                });
                                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                        // updateUI(user);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w("===", "createUserWithEmail:failure", task.getException());
                                        Context context = getApplicationContext();
                                        Toast.makeText(context, "Registration failed. User Already Exists.",
                                                Toast.LENGTH_SHORT).show();
                                        // updateUI(null);
                                    }
                                }
                            });
                }
                else {
                    // If sign in fails, display a message to the user.
                    Log.w("===", "createUserWithEmail:failure");
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Registration failed (Empty Field(s)).",
                            Toast.LENGTH_SHORT).show();
                    // updateUI(null);
                }
                break;
        }
    }


}
