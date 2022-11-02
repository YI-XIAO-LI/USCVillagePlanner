package com.example.mapapp.activity;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mapapp.R;
import com.example.mapapp.base.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        BottomNavigationView navView = findViewById(R.id.nav_view);
        //创建首页底部导航栏
        NavController navController = Navigation.findNavController(this, R.id.host_fragment);
        //首页底部导航栏与界面关联
        NavigationUI.setupWithNavController(navView, navController);
    }
}
