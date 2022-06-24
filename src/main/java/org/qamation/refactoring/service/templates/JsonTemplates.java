package org.qamation.refactoring.service.templates;

public class JsonTemplates {
    public static final String ADDITION_JSON_TEMPLATE = "{\n" +
            "\"a\":%.17f,\n" +
            "\"b\":%.17f\n" +
            "}";

    public static String generateAdditionRequest(String a, String b) {
        return generateAdditionRequest(Double.parseDouble(a),Double.parseDouble(b));
    }

    public static String generateAdditionRequest(double a, double b) {
        return String.format(ADDITION_JSON_TEMPLATE,a,b);
    }



}
