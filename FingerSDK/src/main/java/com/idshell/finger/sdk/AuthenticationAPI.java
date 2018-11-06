package com.idshell.finger.sdk;

import com.alibaba.fastjson.JSONObject;
import com.idshell.finger.sdk.Utils.HttpUtil;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationAPI {

    public Map<String, String> initial(String clientId, String clientKey, String ip) {
        String url = "http://" + ip + ":20880/initial";
        Map<String, String> param = new HashMap<>();
        param.put("clientId", clientId);
        param.put("clientKey", clientKey);
        String result = HttpUtil.sendPost(url, param);
        Map mapTypes = (Map) JSONObject.parse(result);
        int code = (int) mapTypes.get("code");
        if (code != 200) {
            return null;
        }
        Map<String, String> dataMap = (Map<String, String>) mapTypes.get("data");
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("token", dataMap.get("token"));
        return resultMap;
    }

    public boolean register(String deviceId, String token, String ip) {
        String url = "http://" + ip + ":20880/auth/register";
        Map<String, String> param = new HashMap<>();
        param.put("deviceId", deviceId);
        param.put("token", token);
        String result = HttpUtil.sendPost(url, param);
        Map mapTypes = (Map) JSONObject.parse(result);
        int code = (int) mapTypes.get("code");
        if (code != 200) {
            return false;
        }

        return true;
    }

    public boolean authentication(String deviceId, String token, String ip) {
        String url = "http://" + ip + ":20880/auth/auth";
        Map<String, String> param = new HashMap<>();
        param.put("deviceId", deviceId);
        param.put("token", token);
        String result = HttpUtil.sendPost(url, param);
        Map mapTypes = (Map) JSONObject.parse(result);
        int code = (int) mapTypes.get("code");
        if (code != 200) {
            return false;
        }

        return true;
    }

    public boolean deregister(String deviceId, String token, String ip) {
        String url = "http://" + ip + ":20880/auth/deregister";
        Map<String, String> param = new HashMap<>();
        param.put("deviceId", deviceId);
        param.put("token", token);
        String result = HttpUtil.sendPost(url, param);
        Map mapTypes = (Map) JSONObject.parse(result);
        int code = (int) mapTypes.get("code");
        if (code != 200) {
            return false;
        }

        return true;
    }
}
