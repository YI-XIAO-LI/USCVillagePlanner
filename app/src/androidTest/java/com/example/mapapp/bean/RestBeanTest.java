package com.example.mapapp.bean;

import junit.framework.TestCase;

public class RestBeanTest extends TestCase {
    RestBean r;
    public void setUp() throws Exception {
        super.setUp();
        r = new RestBean("rest", "address", 35.0, 118.0);
    }

    public void tearDown() throws Exception {
    }

    public void testTestGetName() {
        assertEquals("rest", r.getName());
    }

    public void testTestSetName() {
        r.setName("restaurant");
        assertEquals("restaurant", r.getName());
    }

    public void testGetAddress() {
        assertEquals("address", r.getAddress());
    }

    public void testSetAddress() {
        r.setName("new_address");
        assertEquals("new_address", r.getName());
    }

    public void testGetLatitude() {
        assertEquals(35.0, r.getLatitude());
    }

    public void testSetLatitude() {
        r.setLatitude(34.0);
        assertEquals(34.0, r.getLatitude());
    }

    public void testGetLongtitude() {
        assertEquals(118.0, r.getLongtitude());
    }

    public void testSetLongtitude() {
        r.setLongtitude(120.0);
        assertEquals(120.0, r.getLongtitude());
    }
}