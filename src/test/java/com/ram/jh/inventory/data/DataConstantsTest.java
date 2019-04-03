package com.ram.jh.inventory.data;

import com.ram.jh.inventory.util.Utils;
import org.junit.Assert;
import org.junit.Test;

public class DataConstantsTest {


    @Test
    public void test_black_lookup(){

        String basicColor = "Black";
        String expectedVal = "000000";
        String actualVal = Utils.lookupColor(basicColor);
        Assert.assertEquals(expectedVal,actualVal);
    }

    @Test
    public void test_color_not_found(){

        String basicColor = "XYZ";
        String expectedVal = "na";
        String actualVal = Utils.lookupColor(basicColor);
        Assert.assertEquals(expectedVal,actualVal);
    }
}
