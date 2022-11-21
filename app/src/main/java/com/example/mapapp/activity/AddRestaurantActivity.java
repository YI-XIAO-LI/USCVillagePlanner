package com.example.mapapp.activity;

import static java.lang.Math.abs;

import android.content.Context;
import android.os.Bundle;

import com.example.mapapp.base.BaseActivity;
import com.example.mapapp.bean.RestBean;
import com.example.mapapp.tool.UtilHelper;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.gson.reflect.TypeToken;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.mapapp.R;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddRestaurantActivity extends BaseActivity {
    private Gson gson = new Gson();
    private List<RestBean> restList = new ArrayList<>();
    private List<RestBean> list = new ArrayList<>();
    private DatabaseReference ref = FirebaseDatabase.getInstance().getReference("data");
    protected EditText restName, restAddress, restLong, restLat;

    UtilHelper helper = new UtilHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_restaurant;
    }

    @Override
    protected void init() {
        restName = findViewById(R.id.restaurantName);
        restAddress = findViewById(R.id.restaurantAddress);
        restLong = findViewById(R.id.restaurantLong);
        restLat = findViewById(R.id.restaurantLat);

        findViewById(R.id.addRestaurant).setOnClickListener(view -> save());
        findViewById(R.id.cancelButton).setOnClickListener(view -> finish());

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

    }

    private void save() {
        String name, address, lng, lat;
        name = restName.getText().toString();
        address = restAddress.getText().toString();
        lng = restLong.getText().toString();
        lat = restLat.getText().toString();

        if (helper.checkEmptyAddRestaurantField(name, address, lng, lat)) {
            double longitude, latitude;
            longitude = Double.parseDouble(restLong.getText().toString());
            latitude = Double.parseDouble(restLat.getText().toString());

            Context context = getApplicationContext();
            for (RestBean restBean : list) {
                if (!helper.restNameAddressValidation(name, address, latitude, longitude, restBean).equals("")){
                    Toast.makeText(context, helper.restNameAddressValidation(name, address, latitude, longitude, restBean),
                            Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    continue;
                }
            }
            // add to the database
            restList.add(new RestBean(name, address, latitude, longitude));
            DatabaseReference defRestaurantRef = ref.child("def_data").child("restaurant");
            defRestaurantRef.setValue(gson.toJson(restList));
            Toast.makeText(context, "New Restaurant Added", Toast.LENGTH_SHORT).show();

        } else {
            Context context = getApplicationContext();
            Toast.makeText(context, "Add Failed. Empty Field(s).",
                    Toast.LENGTH_SHORT).show();
        }
    }
}

