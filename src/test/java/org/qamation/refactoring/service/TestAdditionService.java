package org.qamation.refactoring.service;

import org.json.JSONObject;
import org.qamation.refactoring.service.templates.JsonTemplates;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class TestAdditionService {
    private AdditionService service;

    @BeforeMethod
    public void testMethodSetUp() {
        service = new AdditionService();
    }

    @Test(dataProvider = "generateDoubleArgs")
    public void testAdditionServiceWithDoubleArgs(double a, double b) {
        JSONObject request = new JSONObject(JsonTemplates.generateAdditionRequest(a,b));
        JSONObject response = service.sum(request);
        Assert.assertEquals(response.getDouble("sum"),a+b);
    }

    @Test (dataProvider = "generateLongArgs")
    public void testAddionServiceWithLongArgs(long a, long b) {
        JSONObject request = new JSONObject(JsonTemplates.generateAdditionRequest(a,b));
        JSONObject response = service.sum(request);
        Assert.assertEquals(response.getDouble("sum"),a+b);
    }

    @Test(dataProvider = "generateRandomArgs")
    public void testAdditionServiceWithRandomDoubls(double a, double b) {
        testAdditionServiceWithDoubleArgs(a,b);
    }

    @Test(expectedExceptions = {org.json.JSONException.class})
    public void testFirstEmptyValue() {
        String requestStr = new JSONObject(JsonTemplates.generateAdditionRequest(1,2)).toString().replace("1","");
        JSONObject request = new JSONObject(requestStr);
        JSONObject response = service.sum(request);

    }


    @DataProvider(name="generateRandomArgs")
    public Iterator<Object[]> generateRandomDoubles() {
        ArrayList<Object[]> args = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Double[] dd = new Double[] {random.nextDouble(),random.nextDouble()};
            args.add(dd);
        }
        return args.iterator();
    }

    @DataProvider (name="generateDoubleArgs")
    public Object[][] generateDoubleArgs() {
        Double[][] args = new Double[][] {
                {5.0,3.0},
                {-1.0,-4.0},
                {0.0,0.0},
                {-5.0,6.0},
                {6.0,-5.0},
                {3.1415926,0.00},
                {-3.1415926,-3.1415926},
                {0.0,3.14151926}
        };
        return args;
    }

    @DataProvider (name="generateLongArgs")
    public Object[][] generateLongArgs() {
        Integer[][] args = new Integer[][] {
                {5,3},
                {-1,-4},
                {0,0},
                {-5,6},
                {0,-1},
                {-1,0}
        };
        return args;
    }




}
