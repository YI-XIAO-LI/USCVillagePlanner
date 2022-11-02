package com.example.mapapp.freament;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mapapp.R;
import com.example.mapapp.base.BaseFragment;
import com.example.mapapp.tool.Config;
import com.example.mapapp.tool.SharePerferenceUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;

public class RemindersFragment extends BaseFragment {
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("data");
    List<String> times;
    List<String> restNameList;
    List<String> arrivalList;
    MyAdapter adapter;
    Timer timer;
    TimerTask timerTask;
    Date currentDate;
    AlertDialog dialog;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_reminders;
    }

    @Override
    protected void init() {
        times = SharePerferenceUtils.getStringList(getActivity(),"times");
        restNameList = SharePerferenceUtils.getStringList(getActivity(),"restName");
        arrivalList = SharePerferenceUtils.getStringList(getActivity(),"arrivalTime");

        adapter = new MyAdapter(getActivity());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(adapter);

        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                currentDate = new Date();
                int hour = currentDate.getHours();
                int min = currentDate.getMinutes();

                for(int i=0;i<times.size();i++){
                    if(hour*60+min==Integer.parseInt(times.get(i))){
                        int time = Integer.parseInt(times.get(i));
                        int th = time/60;
                        int tm = time - th*60;

                        int arrTime = Integer.parseInt(arrivalList.get(i));
                        int hh = arrTime/60;
                        int mm = arrTime - hh*60;
                        showTip(Config.ft(th,tm),restNameList.get(i),Config.ft(hh,mm),i);
                    }
                }

            }
        };
        timer.schedule(timerTask,1000,1000);
    }

    private void showTip(String time,String rest,String arrivalTime,int position){
        if(dialog==null||!dialog.isShowing()){
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    dialog = new AlertDialog.Builder(getActivity())
                            .setTitle("Reminder at "+time)
                            .setMessage("Go to "+rest+"\nEstimated Arrival Time:"+arrivalTime)
                            .setPositiveButton("Acknowledge and Delete", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    times.remove(position);
                                    restNameList.remove(position);
                                    arrivalList.remove(position);
                                    SharePerferenceUtils.putStringList(getActivity(),"times",times);
                                    SharePerferenceUtils.putStringList(getActivity(),"restName",restNameList);
                                    SharePerferenceUtils.putStringList(getActivity(),"arrivalTime",arrivalList);
                                    adapter.notifyDataSetChanged();
                                }
                            })
                            .create();
                    dialog.show();
                }
            });

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
        timerTask.cancel();
    }

    public class MyAdapter extends RecyclerView.Adapter<MyVH>{
        Context context;

        public MyAdapter(Context context){
            this.context = context;
        }

        @NonNull
        @Override
        public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyVH(LayoutInflater.from(context).inflate(R.layout.item_reminder,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyVH holder, int position) {
            holder.mTvNo.setText("Reminder: "+(position+1));

            int reminderTime = Integer.parseInt(times.get(position));
            int hour = reminderTime/60;
            int min = reminderTime - hour*60;
            holder.mTvRt.setText("Reminder Time: "+Config.ft(hour,min));
            holder.mTvName.setText(restNameList.get(position));
            holder.mTvCancel.setOnClickListener(view -> {
                times.remove(position);
                restNameList.remove(position);
                arrivalList.remove(position);
                SharePerferenceUtils.putStringList(getActivity(),"times",times);
                SharePerferenceUtils.putStringList(getActivity(),"restName",restNameList);
                SharePerferenceUtils.putStringList(getActivity(),"arrivalTime",arrivalList);
                notifyDataSetChanged();
            });
        }

        @Override
        public int getItemCount() {
            return times.size();
        }
    }

    public class MyVH extends RecyclerView.ViewHolder{
        TextView mTvNo,mTvRt,mTvName,mTvCancel;

        public MyVH(@NonNull View itemView) {
            super(itemView);
            mTvNo = itemView.findViewById(R.id.mTvNo);
            mTvRt = itemView.findViewById(R.id.mTvRt);
            mTvName = itemView.findViewById(R.id.mTvName);
            mTvCancel = itemView.findViewById(R.id.mTvCancel);
        }
    }
}
