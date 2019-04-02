package com.ram.jh.inventory.data;

import com.ram.jh.inventory.util.Utilities;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LookupRGBMapTest {


    @Test
    public void test_black_lookup(){

        String basicColor = "Black";
        String expectedVal = "000000";
        String actualVal = Utilities.lookupColor(basicColor);
        Assert.assertEquals(expectedVal,actualVal);
    }

    @Test
    public void test_color_not_found(){

        String basicColor = "XYZ";
        String expectedVal = "na";
        String actualVal = Utilities.lookupColor(basicColor);
        Assert.assertEquals(expectedVal,actualVal);
    }
}
