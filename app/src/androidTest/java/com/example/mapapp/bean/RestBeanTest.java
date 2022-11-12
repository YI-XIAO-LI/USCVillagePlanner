package com.example.mapapp.bean;

import junit.framework.TestCase;

public class RestBeanTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testTestGetName() {
        RestBean r = new RestBean("rest", "address", 35.0, 118.0);
        assertEquals("rest", r.getName());
    }

    public void testTestSetName() {
        RestBean r = new RestBean("rest", "address", 35.0, 118.0);
        r.setName("restaurant");
        assertEquals("restaurant", r.getName());
    }

    public void testGetAddress() {
        RestBean r = new RestBean("rest", "address", 35.0, 118.0);
        assertEquals("address", r.getAddress());
    }

    public void testSetAddress() {
        RestBean r = new RestBean("rest", "address", 35.0, 118.0);
        r.setName("new_address");
        assertEquals("new_address", r.getName());
    }

    public void testGetLatitude() {
        RestBean r = new RestBean("rest", "address", 35.0, 118.0);
        assertEquals(35.0, r.getLatitude());
    }

    public void testSetLatitude() {
        RestBean r = new RestBean("rest", "address", 35.0, 118.0);
        r.setLatitude(34.0);
        assertEquals(34.0, r.getLatitude());
    }

    public void testGetLongtitude() {
        RestBean r = new RestBean("rest", "address", 35.0, 118.0);
        assertEquals(118.0, r.getLongtitude());
    }

    public void testSetLongtitude() {
        RestBean r = new RestBean("rest", "address", 35.0, 118.0);
        r.setLongtitude(120.0);
        assertEquals(120.0, r.getLongtitude());
    }
}