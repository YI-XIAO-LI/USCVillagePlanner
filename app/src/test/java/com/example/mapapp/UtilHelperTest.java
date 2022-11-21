package com.example.mapapp;

import static org.junit.Assert.assertNotEquals;

import com.example.mapapp.bean.PersonBean;
import com.example.mapapp.bean.RestBean;
import com.example.mapapp.tool.UtilHelper;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UtilHelperTest extends TestCase {
    UtilHelper helper;
    List<RestBean> list = new ArrayList<>();
    List<PersonBean> personBeanList = new ArrayList<>();

    public void setUp() throws Exception {
        super.setUp();
        helper = new UtilHelper();
    }

    public void tearDown() throws Exception {
    }

    @Test
    public void testAddStaticData() {
        // pass an empty list, and see if data is added
        helper.addStaticData(list, personBeanList);
        assertNotEquals(0, list.size());
        int currentListSize = list.size();
        // no new data will be added if the list is already initialized
        helper.addStaticData(list, personBeanList);
        assertEquals(currentListSize, list.size());

    }

    @Test
    public void testAddPersonData() {
        helper.addStaticData(list, personBeanList);
        assertNotEquals(0, personBeanList.size());
        int currentListSize = personBeanList.size();
        // no new data will be added if the list is already initialized
        helper.addStaticData(list, personBeanList);
        assertEquals(currentListSize, personBeanList.size());
    }

    @Test
    public void testInvalidEmail() {
        String email = "email";
        String password = "123456";
        assertEquals("Invalid Email.", helper.emailPasswordValidation(email, password));
        email = "email@";
        assertEquals("Invalid Email.", helper.emailPasswordValidation(email, password));
        email = "email.com";
        assertEquals("Invalid Email.", helper.emailPasswordValidation(email, password));
    }

    @Test
    public void testValidEmail() {
        String password = "123456";
        String email = "email@email.com";
        assertEquals("", helper.emailPasswordValidation(email, password));
        email = "name@gmail.com";
        assertEquals("", helper.emailPasswordValidation(email, password));
    }

    @Test
    public void testPasswordValidation() {
        String email = "email@email.com";
        String password = "12345";
        assertEquals("Password needs to be at least 6 char.", helper.emailPasswordValidation(email, password));
        password = "123456";
        assertEquals("", helper.emailPasswordValidation(email, password));
    }

    @Test
    public void testEmptyFieldCheck() {
        String email = "";
        String name = "";
        String password = "";
        assertEquals(false, helper.checkEmptyField(name, email, password));
        email = "emailString";
        assertEquals(false, helper.checkEmptyField(name, email, password));
        password = "passwordString";
        assertEquals(false, helper.checkEmptyField(name, email, password));
        name = "nameString";
        assertEquals(true, helper.checkEmptyField(name, email, password));

    }

    @Test
    public void testCalculateWaitQueue() {
        List<PersonBean> personList = new ArrayList<>();
        RestBean restBean = new RestBean("CAVA", "3201 S Hoover St Suite 1840, Los Angeles, CA 90089", 34.025821775294204, -118.28505440744799);
        personList.add(new PersonBean("mark", 34.025821775294204, -118.28505440744799));
        personList.add(new PersonBean("dan", 34.025821775294204, -118.28505440744799));
        personList.add(new PersonBean("markA", 34.025821775294204, -118.28505440744799));
        personList.add(new PersonBean("markB", 34.025821775294204, -118.28505440744799));
        personList.add(new PersonBean("markC", 34.025821775294204, -118.28505440744799));
        personList.add(new PersonBean("markG", 34.02561669173768, -118.28516860388257));
        personList.add(new PersonBean("markH", 34.02561669173768, -118.28516860388257));

        int waitPerson = helper.calculateRestaurantWaitQueue(personList, restBean);
        assertEquals(5, waitPerson);
    }

    @Test
    public void testRemoveReminder() {
        List<String> times = new ArrayList<>();
        times.add("1");
        times.add("2");
        List<String> restNameList = new ArrayList<>();
        restNameList.add("1");
        restNameList.add("2");
        List<String> arrivalList = new ArrayList<>();
        arrivalList.add("1");
        arrivalList.add("2");

        helper.removeReminder(times, restNameList, arrivalList, 1);
        assertEquals(Arrays.asList("1"), times);
        assertEquals(Arrays.asList("1"), restNameList);
        assertEquals(Arrays.asList("1"), arrivalList);
    }

    @Test
    public void testAddReminder() {
        List<String> times = new ArrayList<>();
        times.add("1");
        times.add("2");
        List<String> restNameList = new ArrayList<>();
        restNameList.add("1");
        restNameList.add("2");
        List<String> arrivalList = new ArrayList<>();
        arrivalList.add("1");
        arrivalList.add("2");

    }

    @Test
    public void testCheckEmptyAddRestaurantField() {
        String name = "";
        String address = "";
        String lng = "";
        String lat = "";
        assertEquals(false, helper.checkEmptyAddRestaurantField(name, address, lng, lat));
        name = "name";
        address = "address";
        lng = "lng";
        lat = "lat";
        assertEquals(true, helper.checkEmptyAddRestaurantField(name, address, lng, lat));
    }


    @Test
    public void testRestNameAddressValidation() {
        double longitude = -118.28;
        double latitude = 34.02;
        String name = "CAVA";
        String address = "3201 S Hoover St Suite 1840, Los Angeles, CA 90089";
        RestBean restBean = new RestBean("CAVA", "3201 S Hoover St Suite 1840, Los Angeles, CA 90089", 34.025821775294204, -118.28505440744799);
        assertEquals("Restaurant Name Already Exists.", helper.restNameAddressValidation(name, address, latitude, longitude, restBean));
        name = "CAVA_new";
        assertEquals("Restaurant Address Already Exists.", helper.restNameAddressValidation(name, address, latitude, longitude, restBean));
        address = "new address";
        assertEquals("", helper.restNameAddressValidation(name, address, latitude, longitude, restBean));
    }

    @Test
    public void testRestLocationValidation() {
        double longitude = -118.285054407447;
        double latitude = 34.0258217752942;
        String name = "name";
        String address = "address";
        RestBean restBean = new RestBean("CAVA", "3201 S Hoover St Suite 1840, Los Angeles, CA 90089", 34.025821775294204, -118.28505440744799);
        assertEquals("Location Already Exists.", helper.restNameAddressValidation(name, address, latitude, longitude, restBean));
        longitude = -118.4;
        assertEquals("Location Out of Village.", helper.restNameAddressValidation(name, address, latitude, longitude, restBean));
        longitude = -118.28;
        latitude = 34.02;
        assertEquals("", helper.restNameAddressValidation(name, address, latitude, longitude, restBean));

    }

    @Test
    public void testValidWithinRange(){
        PersonBean person = new PersonBean("benjamin", 30.5, -118.7);
        RestBean rest = new RestBean("waterloo cafe", "123 waterloo street", 30.5, -118.7);
        assertEquals(UtilHelper.within_range(person, rest, 0.5), true);
    }

    @Test
    public void testInvalidWithinRange(){
        PersonBean person = new PersonBean("benjamin", 30.5, -118.7);
        RestBean rest = new RestBean("waterloo cafe", "123 waterloo street", 30.5, -118.7);
        assertEquals(UtilHelper.within_range(person, rest, -1), false);
        person = new PersonBean("benjamin", 30.5, -118.7);
        rest = new RestBean("waterloo cafe", "123 waterloo street", 30.502, -118.673);
        assertEquals(UtilHelper.within_range(person, rest, 0.001), false);
    }


    @Test
    public void testCalculateArrivalTime(){
        // check if arrival time is computed correctly
        assertEquals(UtilHelper.calculateArrivalTime(5, 10), 310);
    }

    @Test
    public void testCalculateReminderTime(){
        // check if reminder time is calculated correctly
        assertEquals(UtilHelper.calculateReminderTime(0, 0, 13), 1427);
        assertEquals(UtilHelper.calculateReminderTime(5, 10, 13), 297);

    }


}