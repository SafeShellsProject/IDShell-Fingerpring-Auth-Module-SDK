package com.idshell.finger.sdk.Example;

import com.idshell.finger.sdk.AuthenticationAPI;

import java.util.Map;

public class AuthExample {

    private static String ip = "127.0.0.1";

    //从服务端获取到的客户端ID
    private static String clientId = "88012BA907AB599B";
    //从服务端获取到的客户端key
    private static String clientKey = "A437CD57DBD6AE8276CEECC015E91DAD";
    //计算出的唯一设备ID
    private static String deviceId = "1234567890123456";

    public static void main(String[] args) {

        AuthenticationAPI authenticationAPI = new AuthenticationAPI();

        //初始化获取访问token
        Map<String, String> resultMap = authenticationAPI.initial(clientId, clientKey, ip);
        String token = resultMap.get("token");

        //注册设备
        boolean status = authenticationAPI.register(deviceId, token, ip);
        if (!status) {
            System.out.println("设备注册失败");
        } else {
            System.out.println("设备注册成功");
        }

        //身份认证
        status = authenticationAPI.authentication(deviceId, token, ip);
        if (!status) {
            System.out.println("身份认证失败");
        } else {
            System.out.println("身份认证通过");
        }

        //设备注销
        status = authenticationAPI.deregister(deviceId, token, ip);
        if (!status) {
            System.out.println("设备注销失败");
        } else {
            System.out.println("设备注销成功");
        }
    }
}
