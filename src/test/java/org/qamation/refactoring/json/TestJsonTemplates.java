package org.qamation.refactoring.json;

import org.qamation.refactoring.service.templates.JsonTemplates;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestJsonTemplates {
    @BeforeMethod
    public void methodSetUp() {
    }
    @AfterMethod
    public void methodTearDown() {
    }

    @Test
    public void testTemplateWithTwoInts() {
        String actual = JsonTemplates.generateAdditionRequest("5","6");
        String expected = "{\n" +
                "\"a\":5.00000000000000000,\n" +
                "\"b\":6.00000000000000000\n" +
                "}";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testTemplateWithTwoLargeInts() {
        String actual = JsonTemplates.generateAdditionRequest("55927433.0","-2345122");
        String expected = "{\n" +
                "\"a\":55927433.00000000000000000,\n" +
                "\"b\":-2345122.00000000000000000\n" +
                "}";
        Assert.assertEquals(actual,expected);
    }

    @Test(expectedExceptions = {NumberFormatException.class})
    public void testTemplatesWithFirstParamOnly() {
        JsonTemplates.generateAdditionRequest("4.00000000000000000","");
    }

    @Test
    public void testTemplatesWithNotDoubleArgs() {
        JsonTemplates.generateAdditionRequest("4","-4");
        String expected = "{\n" +
                "\"a\":4.00000000000000000,\n" +
                "\"b\":-4.00000000000000000\n" +
                "}";
    }

}
