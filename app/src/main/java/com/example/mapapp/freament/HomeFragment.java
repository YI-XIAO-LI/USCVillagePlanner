package com.example.mapapp.freament;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.example.mapapp.R;
import com.example.mapapp.activity.AddReminderActivity;
import com.example.mapapp.activity.AddRestaurantActivity;
import com.example.mapapp.bean.PersonBean;
import com.example.mapapp.bean.RestBean;
import com.example.mapapp.base.BaseFragment;
import com.example.mapapp.bean.RouteBean;
import com.example.mapapp.tool.Config;
import com.example.mapapp.tool.SharePerferenceUtils;
import com.example.mapapp.tool.UtilHelper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Math;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HomeFragment extends BaseFragment implements OnMapReadyCallback {
    private TextView mTvRouteTime,mTvTotalTime;
    private MapView mapView;
    private GoogleMap mMap;
    FusedLocationProviderClient fusedLocationProviderClient;
    //private LocationManager locationManager = null; // 位置管理
/*
    private LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            Log.d("===", "onLocationChanged getLatitude:"
                    + location.getLatitude() + " getLongitude:" + location.getLongitude());

            createSelfMarker(new LatLng(location.getLatitude(),location.getLongitude()),currentPoint==null);
        }
    };
 */
    private LatLng currentPoint;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("data");
    private List<RestBean> restList = new ArrayList<>();
    private List<PersonBean> personList = new ArrayList<>();
    ProgressDialog dialog;
    Polyline currentLine;
    int duration = 0;
    int totalTime = 0;
    String restName = "";
    Map<String,Integer> waitMap = new HashMap<>();
    private Marker currentMarker;
    private boolean isTest = false;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init() {
        mTvRouteTime = (TextView) findView(R.id.mTvRouteTime);
        mTvTotalTime = (TextView) findView(R.id.mTvTotalTime);
        mapView = (MapView) findView(R.id.mapView);
        this.addData();
        findView(R.id.mTvAddReminder).setOnClickListener(view -> addReminder());
        findView(R.id.mTvRefresh).setOnClickListener(view -> refreshMap());
        findView(R.id.mTvAddRestaurant).setOnClickListener(view -> jumpToRestaurant());
        initMap();
        //locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE); // 取得位置服务
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());

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
        if (SharePerferenceUtils.getString(getActivity(), "reminderInit", "") != "true") {
            userReminderRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.child("times").getValue() == null) {
                        return;
                    }
                    List<String> arrivalList = new ArrayList<>();
                    List<String> times = new ArrayList<>();
                    List<String> restNameList = new ArrayList<>();
                    SharePerferenceUtils.putStringList(getContext(), "times", times);
                    SharePerferenceUtils.putStringList(getContext(), "restName", restNameList);
                    SharePerferenceUtils.putStringList(getContext(), "arrivalTime", arrivalList);

                    times = gson.fromJson(dataSnapshot.child("times").getValue().toString(), new TypeToken<List<String>>() {
                    }.getType());
                    Log.d("===", "personList:" + times.size());
                    restNameList = gson.fromJson(dataSnapshot.child("restName").getValue().toString(), new TypeToken<List<String>>() {
                    }.getType());
                    Log.d("===", "personList:" + restNameList.size());
                    arrivalList = gson.fromJson(dataSnapshot.child("arrivalTime").getValue().toString(), new TypeToken<List<String>>() {
                    }.getType());
                    Log.d("===", "personList:" + arrivalList.size());

                    SharePerferenceUtils.putStringList(getContext(), "times", times);
                    SharePerferenceUtils.putStringList(getContext(), "restName", restNameList);
                    SharePerferenceUtils.putStringList(getContext(), "arrivalTime", arrivalList);
                    SharePerferenceUtils.putString(getContext(), "reminderInit", "true");
                }


                @Override
                public void onCancelled(DatabaseError databaseError) {
                    System.out.println("===The read failed: " + databaseError.getCode());
                }
            });
        }


    }

    private void addReminder(){
        Intent intent = new Intent(getActivity(), AddReminderActivity.class);
        intent.putExtra("totalTime",totalTime);
        intent.putExtra("restName",restName);
        startActivity(intent);
    }

    private void jumpToRestaurant() {
        Intent intent2 = new Intent(getActivity(), AddRestaurantActivity.class);
        startActivity(intent2);
    }

    private void createSelfMarker(LatLng latLng, boolean animateCamera){
        currentPoint = latLng;
        // default location set at Viterbi
        if (currentPoint == null) {
            currentPoint = new LatLng(34.0207, -118.289);
        }
        if(animateCamera){
            if (currentPoint == null) {
                currentPoint = new LatLng(34.0207, -118.289);
            }
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentPoint, 15));
        }

        MarkerOptions markerOpt = new MarkerOptions();
        markerOpt.position(currentPoint); // 標記位置

        markerOpt.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        if(currentMarker!=null){
            currentMarker.remove();
        }

        currentMarker = mMap.addMarker(markerOpt);
        currentMarker.setTag("self");
        //melbourne.showInfoWindow();
    }

    private void initData(){
        DatabaseReference defRestaurantRef = ref.child("def_data");
        defRestaurantRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child("person").getValue() == null || dataSnapshot.child("restaurant").getValue() == null) {
                    createMarker();
                    return;
                }
                personList = gson.fromJson(dataSnapshot.child("person").getValue().toString(), new TypeToken<List<PersonBean>>(){}.getType());
                Log.d("===","personList:"+personList.size());

                restList = gson.fromJson(dataSnapshot.child("restaurant").getValue().toString(), new TypeToken<List<RestBean>>(){}.getType());
                Log.d("===","restList:"+restList.size());
                createMarker();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("===The read failed: " + databaseError.getCode());
            }
        });

    }

    private void createMarker() {
        for(RestBean restBean : restList) {
            UtilHelper helper = new UtilHelper();
            int waitPersonNum = helper.calculateRestaurantWaitQueue(personList, restBean);

            Log.d("===",restBean.getName()+" 等待人数 "+waitPersonNum);
            LatLng point = new LatLng(restBean.getLatitude(),restBean.getLongtitude());
            MarkerOptions markerOpt = new MarkerOptions();
            markerOpt.position(point); // 標記位置
            markerOpt.title(restBean.getName()+"(wait "+waitPersonNum*3+"min)"); // 標題
            markerOpt.snippet(restBean.getAddress()); //內文
            markerOpt.draggable(false); // 標記不可拖曳
            markerOpt.visible(true);    // 顯示標記
            markerOpt.anchor(0.5f, 0.5f);//設為圖片中心
            markerOpt.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
            Marker melbourne = mMap.addMarker(markerOpt);
            //melbourne.setTag(info);
            //melbourne.showInfoWindow();

            waitMap.put(markerOpt.getTitle(),waitPersonNum*3);
        }
        if(isTest){
            createSelfMarker(new LatLng(restList.get(0).getLatitude(),restList.get(0).getLongtitude()),true);
        }
    }

    private void getRoute(LatLng desPoint,String title) {
        StringBuilder builder = new StringBuilder("https://maps.googleapis.com/maps/api/directions/json?sensor=false&mode=walking");//driving walking
        builder.append("&origin="+currentPoint.latitude+","+currentPoint.longitude);
        builder.append("&destination="+desPoint.latitude+","+desPoint.longitude);
        builder.append("&key="+ Config.DirectionsKey);

        dialog = new ProgressDialog(getActivity());
        dialog.show();
        OkHttpClient httpClient =new OkHttpClient();
        Request request =new Request.Builder()
                .url(builder.toString())
                .get()
                .build();

        httpClient.newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                        dialog.dismiss();
                    }

                    @Override public void onResponse(@NotNull Call call, @NotNull final Response response) throws IOException {
                        dialog.dismiss();
                        final RouteBean routeBean = gson.fromJson(response.body().string(),RouteBean.class);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                List<LatLng> list = new ArrayList<>();
                                duration = 0;
                                for(int i=0;i<routeBean.getRoutes().size();i++){
                                    RouteBean.RoutesBean routesBean = routeBean.getRoutes().get(i);
                                    for(int j=0;j<routesBean.getLegs().size();j++){
                                        RouteBean.RoutesBean.LegsBean leg = routesBean.getLegs().get(j);
                                        duration+=Math.ceil(leg.getDuration().getValue()/60.0);
                                        for(int k=0;k<leg.getSteps().size();k++) {
                                            RouteBean.RoutesBean.LegsBean.StepsBean stepsBean = leg.getSteps().get(k);
                                            LatLng ll1 = new LatLng(stepsBean.getStart_location().getLat(),stepsBean.getStart_location().getLng());
                                            list.add(ll1);

                                            LatLng ll2 = new LatLng(stepsBean.getEnd_location().getLat(),stepsBean.getEnd_location().getLng());
                                            list.add(ll2);
                                        }
                                    }
                                }
                                if(currentLine!=null){
                                    currentLine.remove();
                                }
                                restName = title;
                                currentLine = mMap.addPolyline(new PolylineOptions()
                                        .addAll(list));
                                totalTime = waitMap.get(title)+duration;
                                mTvRouteTime.setText("Route: "+duration+" minute(s)");
                                mTvTotalTime.setText("Total: "+totalTime+" minute(s)");
                            }
                        });
                    }
                });
    }

    private void initMap() {
        mapView.onCreate(null);
        mapView.onResume();
        try {
            MapsInitializer.initialize(getActivity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int errorCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity());
        if (ConnectionResult.SUCCESS != errorCode) {
            GooglePlayServicesUtil.getErrorDialog(errorCode, getActivity(), 0).show();
        } else {
            mapView.getMapAsync(this);
        }

    }

    private void requestLocation() {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            return;
        }

        Task<Location> locationTask = fusedLocationProviderClient.getLastLocation();

        locationTask.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null){
                    if (location.getLatitude() >= 36) {
                        createSelfMarker(new LatLng(34.0232, -118.2866),currentPoint==null);
                        Log.d("===", "onSuccess: getLatitude:"
                                + location.getLatitude() + " getLongitude:" + location.getLongitude());
                        return;
                    }
                    // we have a location
                    createSelfMarker(new LatLng(location.getLatitude(),location.getLongitude()),currentPoint==null);
                    Log.d("===", "onSuccess: getLatitude:"
                            + location.getLatitude() + " getLongitude:" + location.getLongitude());

                } else {
                    Log.d("===", "onSuccess: Location was null:");
                    // manually set the location
                    createSelfMarker(new LatLng(34.0232, -118.2866),currentPoint!=null);
                }
            }
        });

        locationTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("===", "onFailure: " + e.getLocalizedMessage());

            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
           @Override
           public boolean onMarkerClick(@NonNull Marker marker) {
               if(marker.getTag()==null){
                   if(currentPoint!=null){
                       getRoute(marker.getPosition(),marker.getTitle());
                   }else {
                       showToast("failed to get position，try to request location...");
                       requestLocation();
                   }
               }
               return false;
           }
       });

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        // NEW FUNCTION ** ADDING ZOOMING IN/OUT
        UiSettings settings = mMap.getUiSettings();
        settings.setMyLocationButtonEnabled(true);
        settings.setZoomControlsEnabled(true);
        settings.setCompassEnabled(true);
        // END OF NEW FUNCTION

        mMap.setMyLocationEnabled(true);

        if(!isTest){
            requestLocation();
        }
        initData();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==1&&grantResults[0]==PackageManager.PERMISSION_GRANTED&&grantResults[1]==PackageManager.PERMISSION_GRANTED){
            requestLocation();
        }
    }

    private void refreshMap() {
        initMap();
        createMarker();
        createSelfMarker(currentPoint,true);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentPoint, 15));
    }


    private void addData(){
        List<RestBean> list = new ArrayList<>();
        List<PersonBean> personBeanList = new ArrayList<>();
        UtilHelper helper = new UtilHelper();
        helper.addStaticData(list, personBeanList);
        DatabaseReference defRestaurantRef = ref.child("def_data");
        Map<String,String> map = new HashMap<>();
        map.put("restaurant",gson.toJson(list));
        map.put("person",gson.toJson(personBeanList));
        defRestaurantRef.setValue(map);
    }

}
