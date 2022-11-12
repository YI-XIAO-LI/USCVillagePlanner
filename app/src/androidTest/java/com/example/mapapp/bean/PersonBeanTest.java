package com.example.mapapp.bean;

import junit.framework.TestCase;

public class PersonBeanTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testTestGetName() {
        PersonBean p = new PersonBean("name", 35.0, 118.0);
        assertEquals("name", p.getName());
    }

    public void testTestSetName() {
        PersonBean p = new PersonBean("name", 35.0, 118.0);
        p.setName("new_name");
        assertEquals("new_name", p.getName());
    }

    public void testGetLatitude() {
        PersonBean p = new PersonBean("name", 35.0, 118.0);
        assertEquals(35.0, p.getLatitude());
    }

    public void testSetLatitude() {
        PersonBean p = new PersonBean("name", 35.0, 118.0);
        p.setLatitude(40.0);
        assertEquals(40.0, p.getLatitude());
    }

    public void testGetLongtitude() {
        PersonBean p = new PersonBean("name", 35.0, 118.0);
        assertEquals(118.0, p.getLongtitude());
    }

    public void testSetLongtitude() {
        PersonBean p = new PersonBean("name", 35.0, 118.0);
        p.setLongtitude(120.0);
        assertEquals(120.0, p.getLongtitude());
    }
}