package com.example.mapapp.tool;

public class Config {
    public static final String DirectionsKey = "AIzaSyCOL-HJLDGHKuKtGkyz2WaOF7FQpzNGF7g";

    public static String ft(int hour,int min){
        String hs = hour>9?hour+"":"0"+hour;
        String ms = min>9?min+"":"0"+min;
        return hs+":"+ms;
    }
}
