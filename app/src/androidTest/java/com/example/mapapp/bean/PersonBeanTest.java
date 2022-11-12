package com.example.mapapp.bean;

import junit.framework.TestCase;

public class PersonBeanTest extends TestCase {
    PersonBean p;
    public void setUp() throws Exception {
        p = new PersonBean("name", 35.0, 118.0);
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testTestGetName() {
        assertEquals("name", p.getName());
    }

    public void testTestSetName() {
        p.setName("new_name");
        assertEquals("new_name", p.getName());
    }

    public void testGetLatitude() {
        assertEquals(35.0, p.getLatitude());
    }

    public void testSetLatitude() {
        p.setLatitude(40.0);
        assertEquals(40.0, p.getLatitude());
    }

    public void testGetLongtitude() {
        assertEquals(118.0, p.getLongtitude());
    }

    public void testSetLongtitude() {
        p.setLongtitude(120.0);
        assertEquals(120.0, p.getLongtitude());
    }
}