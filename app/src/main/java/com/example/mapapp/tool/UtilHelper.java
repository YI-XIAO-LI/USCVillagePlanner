package com.example.mapapp.tool;

import com.example.mapapp.bean.PersonBean;
import com.example.mapapp.bean.RestBean;
import com.example.mapapp.bean.RouteBean;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class UtilHelper {

        public void addStaticData(List< RestBean> list, List< PersonBean > personBeanList) {
            if(list.size() == 0) {
                list.add(new RestBean("CAVA", "3201 S Hoover St Suite 1840, Los Angeles, CA 90089", 34.025821775294204, -118.28505440744799));
                list.add(new RestBean("Greenleaf Kitchen & Cocktails", "929 W Jefferson Blvd #1650, Los Angeles, CA 90089", 34.02474079953199, -118.28528325248934));
                list.add(new RestBean("Chinese Street Food", "3201 S Hoover St #1870, Los Angeles, CA 90007", 34.02465643138648, -118.28398648508674));
                list.add(new RestBean("Il Giardino Ristorante", "3201 S Hoover St #1850, Los Angeles, CA 90089", 34.025330990643525, -118.28434297834089));
                list.add(new RestBean("Honeybird", "3201 S Hoover St #1835, Los Angeles, CA 90089", 34.024904175743075, -118.28441808019377));
                list.add(new RestBean("City Tacos", "3201 S Hoover St #1870, Los Angeles, CA 90007", 34.02426427775233, -118.2844844611436));
                list.add(new RestBean("DULCE", "3096 McClintock Ave Ste 1420, Los Angeles, CA 90007", 34.02561669173768, -118.28516860388257));
                list.add(new RestBean("Fruit + Candy", "3201 S Hoover St #1815, Los Angeles, CA 90089", 34.0246011481783, -118.28421080203752));
                list.add(new RestBean("Insomnia Cookies", "929 W Jefferson Blvd # 1620, Los Angeles CA 90089", 34.025191020187506, -118.28531291510147));
                list.add(new RestBean("Kobunga Korean Grill", "929 W. Jefferson Blvd Suite 1610, Los Angeles, CA 90007", 34.02475834463438, -118.28523987092082));
            }
            else {
                return;
            }

            if (personBeanList.size() == 0) {
                personBeanList.add(new PersonBean("tom", 34.02468029012595, -118.2855711093449));
                personBeanList.add(new PersonBean("jerry", 34.025066786661604, -118.2845280792272));
                // cava
                personBeanList.add(new PersonBean("mark", 34.025821775294204, -118.28505440744799));
                personBeanList.add(new PersonBean("dan", 34.025821775294204, -118.28505440744799));
                personBeanList.add(new PersonBean("markA", 34.025821775294204, -118.28505440744799));
                personBeanList.add(new PersonBean("markB", 34.025821775294204, -118.28505440744799));
                personBeanList.add(new PersonBean("markC", 34.025821775294204, -118.28505440744799));
                // Honey bird
                personBeanList.add(new PersonBean("markD", 34.024904175743075, -118.28441808019377));

                // dulce
                personBeanList.add(new PersonBean("markD", 34.02561669173768, -118.28516860388257));
                personBeanList.add(new PersonBean("markE", 34.02561669173768, -118.28516860388257));
                personBeanList.add(new PersonBean("markF", 34.02561669173768, -118.28516860388257));
                personBeanList.add(new PersonBean("markG", 34.02561669173768, -118.28516860388257));
                personBeanList.add(new PersonBean("markH", 34.02561669173768, -118.28516860388257));

                // insomnia cookie
                personBeanList.add(new PersonBean("james", 34.025191020187506, -118.28531291510147));
                // city taco
                personBeanList.add(new PersonBean("tim", 34.02426427775233, -118.2844844611436));
                personBeanList.add(new PersonBean("tim2", 34.02426427775233, -118.2844844611436));
                // green leaf
                personBeanList.add(new PersonBean("tommy", 34.02474079953199, -118.28528325248934));
                // Il giardinao ristorante
                personBeanList.add(new PersonBean("trojan", 34.025330990643525, -118.28434297834089));
            }
            else {
                return;
            }
        }

        public String emailPasswordValidation(String email, String password) {
            if (!email.contains(".com") || !email.contains("@")) {
                return "Invalid Email.";
            }
            else if (password.length() < 6) {
                return "Password needs to be at least 6 char.";
            }
            return "";
        }

        public boolean checkEmptyField(String name, String email, String password) {
            if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()){
                return true;
            }
            return false;
        }

        public int calculateRestaurantWaitQueue(List<PersonBean> personList, RestBean restBean) {
            int waitPersonNum = 0;
            for(PersonBean personBean : personList){
                if(within_range(personBean, restBean, 0.00009)){
                    waitPersonNum++;
                }
            }
            return waitPersonNum;
        }

        public void removeReminder(List<String> times, List<String> restNameList, List<String> arrivalList, int position) {
            if(!times.isEmpty() && !restNameList.isEmpty() && !arrivalList.isEmpty()){
                times.remove(position);
                restNameList.remove(position);
                arrivalList.remove(position);
            } else {
                System.out.println("ERROR: invalid input fields");
                return;
            }

        }

        public void addToReminder(List<String> times, List<String> restNameList, List<String> arrivalList, int arrivalTime, int reminderTime, String restName) {
            // insert in the sorted order
            for (int i = 0; i < times.size(); i++) {
                if( Integer.parseInt(times.get(i)) > reminderTime ) {
                    arrivalList.add(i, ""+arrivalTime);
                    times.add(i, ""+reminderTime);
                    restNameList.add(i, restName);
                    return;
                }
            }
            arrivalList.add(""+arrivalTime);
            times.add(""+reminderTime);
            restNameList.add(restName);
        }

        public boolean checkEmptyAddRestaurantField(String name, String address, String lng, String lat) {
            if(name.isEmpty()) {
                return false;
            }
            else if (address.isEmpty()) {
                return false;
            }
            else if (lng.isEmpty()) {
                return false;
            }
            else if(lat.isEmpty()) {
                return false;
            }
            return true;
        }

        public String restNameAddressValidation(String name, String address, double latitude, double longitude, RestBean restBean) {
            if(Math.abs(restBean.getLatitude() - latitude) <= 0.0009 && Math.abs(restBean.getLongtitude() - longitude) <= 0.0009){
                return "Location Already Exists.";
            }
            if (latitude < 34 || latitude > 34.1 || longitude < -118.3 || longitude > -118.2) {
                return "Location Out of Village. Please enter a location with 34 <= latitude < 34.1, and 118.2 <= longitude < 118.3";
            }
            if(name.equals(restBean.getName())) {
                return "Restaurant Name Already Exists.";
            }
            if (address.equals(restBean.getAddress())) {
                return "Restaurant Address Already Exists.";
            }
            return "";
        }

    public static boolean within_range(PersonBean person, RestBean rest, double range){
        double lat1 = person.getLatitude();
        double long1 = person.getLongtitude();
        double lat2 = rest.getLatitude();
        double long2 = rest.getLongtitude();

        if(range < 0){
            return false;
        } else {
            if(Math.abs(lat1-lat2) <= range){
                if(Math.abs(long1-long2)<= range){
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }
        }
    }

    public static int calculateArrivalTime(int hourOfDay, int minute){
            if(hourOfDay < 0 || minute < 0){
                System.out.println("Invalid Times");
                return -1;
            } else {
                return hourOfDay * 60 + minute;
            }


    }

    public static int calculateReminderTime(int hourOfDay, int minute, int totalTime){
            if(totalTime < 0 || hourOfDay < 0 || minute < 0){
                System.out.println("Invalid Times");
                return -1;
            } else {
                if(hourOfDay*60+minute-(totalTime%60) < 0) {
                    return hourOfDay*60+minute-(totalTime%60) + 24*60;
                }
                return hourOfDay*60+minute-(totalTime%60);
            }

    }

    public static String timeDisplayConfig(int hour,int min){
        String hs = hour>9?hour+"":"0"+hour;
        String ms = min>9?min+"":"0"+min;
        return hs+":"+ms;
    }

    public String timerTask(String times, int hour, int min) {

        int hr = hour;
        int m = min;
        if (hr * 60 + m == Integer.parseInt(times)) {
            int time = Integer.parseInt(times);
            int th = time/60;
            int tm = time - th * 60;
            return th + ":" + tm;
        }
        return "";
    }


}
