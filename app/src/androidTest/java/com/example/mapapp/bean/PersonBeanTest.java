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
        assertEquals(p.getName(), "name");
    }

    public void testTestSetName() {
        PersonBean p = new PersonBean("name", 35.0, 118.0);
        p.setName("new_name");
        assertEquals(p.getName(), "new_name");
    }

    public void testGetLatitude() {
        PersonBean p = new PersonBean("name", 35.0, 118.0);
        assertEquals(p.getLatitude(), 35.0);
    }

    public void testSetLatitude() {
        PersonBean p = new PersonBean("name", 35.0, 118.0);
        p.setLatitude(40.0);
        assertEquals(p.getLatitude(), 40.0);
    }

    public void testGetLongtitude() {
        PersonBean p = new PersonBean("name", 35.0, 118.0);
        assertEquals(p.getLongtitude(), 118.0);
    }

    public void testSetLongtitude() {
        PersonBean p = new PersonBean("name", 35.0, 118.0);
        p.setLongtitude(120.0);
        assertEquals(p.getLongtitude(), 120.0);
    }
}