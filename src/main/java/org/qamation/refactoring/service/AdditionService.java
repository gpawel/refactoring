package org.qamation.refactoring.service;
import org.json.JSONObject;
public class AdditionService {



    public JSONObject sum(JSONObject jsonObject) {
        double a = jsonObject.getDouble("a");
        double b = jsonObject.getDouble("b");
        return wrapValueIntJsonResponse(a+b);
    }

    public String sum(String strJsonSumRequest) {
        JSONObject jsonSumRequest = new JSONObject(strJsonSumRequest);
        JSONObject response = sum(jsonSumRequest);
        return response.toString();
    }

    private JSONObject wrapValueIntJsonResponse(double value) {
        JSONObject response = new JSONObject();
        response.put("sum",Double.valueOf(value));
        return response;
    }
}
