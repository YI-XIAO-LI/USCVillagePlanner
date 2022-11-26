package com.example.mapapp.freament;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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

import java.io.File;
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
            findView(R.id.camera).setOnClickListener(view -> takePhotoImage());
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

    private Uri imageUri_;

    private void takePhotoImage() {
        String fileName = "new-photo-name.jpg";
        // Create parameters for Intent with filename
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, fileName);
        values.put(MediaStore.Images.Media.DESCRIPTION, "Image capture by camera");
        imageUri_ = this.getContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri_);
        startActivityForResult(intent, 1231);
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
        else if (requestCode == 1231) {
            try {
                ContentResolver cr = this.getContext().getContentResolver();
                try {
                    // Creating a Bitmap with the image Captured
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(cr, imageUri_);
                    // Setting the bitmap as the image of the
                    mIvHead.setImageBitmap(bitmap);
                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                            .setPhotoUri(imageUri_)
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
                    fileref.putFile(imageUri_).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
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
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IllegalArgumentException e) {
                if (e.getMessage() != null)
                    Log.e("Exception", e.getMessage());
                else
                    Log.e("Exception", "Exception");
                e.printStackTrace();
            }
        }
    }

    private void logout() {
        SharePerferenceUtils.putString(getContext(), "reminderInit", "false");
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
}
