package com.example.mapapp.activity;

import android.app.TimePickerDialog;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.mapapp.R;
import com.example.mapapp.base.BaseActivity;
import com.example.mapapp.tool.Config;
import com.example.mapapp.tool.SharePerferenceUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class AddReminderActivity extends BaseActivity {
    @BindView(R.id.mEtAt)
    TextView mEtAt;
    @BindView(R.id.mEtMt)
    TextView mEtMt;
    int totalTime;
    int arrivalTime = 0;
    int reminderTime = 0;
    String restName = "";
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("data");

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_reminder;
    }

    @Override
    protected void init() {
        findViewById(R.id.mBtnSave).setOnClickListener(view -> save());
        findViewById(R.id.mBtnCancel).setOnClickListener(view -> finish());

        totalTime = getIntent().getIntExtra("totalTime",0);
        restName = getIntent().getStringExtra("restName");
        if(restName.contains("(wait")){
            restName = restName.split("wait")[0].replace("(","");
        }
        // extract data from firebase by email

        // store by email as key;
        // store by name as key
    }

    @OnClick({R.id.mEtAt})
    public void click(View view){
        switch (view.getId()){
            case R.id.mEtAt:
                showTimePicker();
                break;
        }
    }

    private void showTimePicker(){
        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                arrivalTime = hourOfDay*60+minute;
                mEtAt.setText(Config.ft(hourOfDay,minute));
                reminderTime = hourOfDay*60+minute-(totalTime%24%60);
                int hour = reminderTime/60;
                int min = reminderTime%60;
                mEtMt.setText(Config.ft(hour,min));

            }
            //0,0指的是时间，true表示是否为24小时，true为24小时制
        },0,0,true).show();

    }

    private void save(){
        if(reminderTime!=0){
            List<String> arrivalList = SharePerferenceUtils.getStringList(this,"arrivalTime");
            List<String> times = SharePerferenceUtils.getStringList(this,"times");
            List<String> restNameList = SharePerferenceUtils.getStringList(this,"restName");
            arrivalList.add(""+arrivalTime);
            times.add(""+reminderTime);
            restNameList.add(restName);
            SharePerferenceUtils.putStringList(this,"times", times);
            SharePerferenceUtils.putStringList(this,"restName", restNameList);
            SharePerferenceUtils.putStringList(this,"arrivalTime", arrivalList);

            Gson gson = new Gson();
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            FirebaseUser currentUser = mAuth.getCurrentUser();

            DatabaseReference reminderRef = ref.child("reminders");
            DatabaseReference userReminderRef = null;
            if(currentUser != null){
                userReminderRef = reminderRef.child(currentUser.getDisplayName().toString());
            }
            else {
                userReminderRef = reminderRef.child(SharePerferenceUtils.getString(getApplicationContext(),"DisplayName",""));
            }

            Map<String,String> map = new HashMap<>();
            map.put("times", gson.toJson(times));
            map.put("restName", gson.toJson(restNameList));
            map.put("arrivalTime", gson.toJson(arrivalList));
            // add current user
            userReminderRef.setValue(map);

            showToast("Add Reminder Success");
            finish();
        } else {
            showToast("reminder error");
        }
    }
}
