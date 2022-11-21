package com.example.mapapp;

import static org.junit.Assert.assertNotEquals;

import com.example.mapapp.bean.PersonBean;
import com.example.mapapp.bean.RestBean;
import com.example.mapapp.tool.Config;
import com.example.mapapp.tool.UtilHelper;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConfigTest extends TestCase {
    public void testTimeConfigBelow9(){
        assertEquals(Config.ft(5,5), "05:05");
    }

    public void testTimeConfigAbove9(){
        assertEquals(Config.ft(11,11), "11:11");
    }


}