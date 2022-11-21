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
import com.example.mapapp.tool.UtilHelper;
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
    // @BindView(R.id.mEtAt)
    TextView mEtAt;
    // @BindView(R.id.mEtMt)
    TextView mEtMt;
    int totalTime;
    int arrivalTime = 0;
    int reminderTime = 0;
    String restName = "";
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("data");
    UtilHelper helper = new UtilHelper();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_reminder;
    }

    @Override
    protected void init() {
        findViewById(R.id.mBtnSave).setOnClickListener(view -> save());
        findViewById(R.id.mBtnCancel).setOnClickListener(view -> finish());
        mEtAt = (TextView) findViewById(R.id.mEtAt);
        mEtMt = (TextView) findViewById(R.id.mEtMt);
        totalTime = getIntent().getIntExtra("totalTime",0);
        restName = getIntent().getStringExtra("restName");
        if(restName.contains("(wait")){
            restName = restName.split("wait")[0].replace("(","");
        }
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
                arrivalTime = UtilHelper.calculateArrivalTime(hourOfDay, minute);
                mEtAt.setText(Config.ft(hourOfDay,minute));
                reminderTime = hourOfDay*60+minute-(totalTime%60);
                reminderTime = UtilHelper.calculateReminderTime(hourOfDay, minute, totalTime);
                int hour = reminderTime/60;
                int min = reminderTime%60;
                mEtMt.setText(Config.ft(hour,min));
            }
        },0,0,true).show();

    }

    private void save(){
        if(reminderTime!=0){
            List<String> arrivalList = SharePerferenceUtils.getStringList(this,"arrivalTime");
            List<String> times = SharePerferenceUtils.getStringList(this,"times");
            List<String> restNameList = SharePerferenceUtils.getStringList(this,"restName");
            helper.addToReminder(times, restNameList, arrivalList, arrivalTime, reminderTime, restName);
            SharePerferenceUtils.putStringList(this,"times", times);
            SharePerferenceUtils.putStringList(this,"restName", restNameList);
            SharePerferenceUtils.putStringList(this,"arrivalTime", arrivalList);

            showToast("Add Reminder Success");
            finish();
        } else {
            showToast("reminder error");
        }
    }
}
