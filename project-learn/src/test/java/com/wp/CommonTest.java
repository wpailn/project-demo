package com.wp;

import org.junit.Test;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class CommonTest {

    //认证接口
    @Test
    public void authenticate() {
        final String REST_BASE_URL = "https://testidp.haier.net/idp/restful/IDPAuthenticate";
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        params.add("appId","restfulTest");
        params.add("userName","00000008");
        params.add("password","Test,123");
        params.add("remoteIp","10.8.41.156");
        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>(params,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(REST_BASE_URL, HttpMethod.POST,requestEntity,String.class);
        String response = responseEntity.getBody();
        System.out.println("认证接口："+response);
    }

    //验证票据接口
    @Test
    public void isTokenValid(){
        final String REST_BASE_URL = "https://testidp.haier.net/idp/restful/isIDPTokenValid";
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        params.add("appId","restfulTest");
        params.add("tokenId","MTAuOC40MS4xNTY=|MDg0NTVmMTQwZjc4YzZkYmE2Y2MzYmNjM2ZkYWFlYmRiMzZiOTk2NDQ5OWY1OGE3YWY0Njk4OGY1ZmM4MDExNw==|wdfWyEFwQ4b6nfDpl+tU6zHqPNA=");
        params.add("remoteIp","10.8.41.156");
        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>(params,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(REST_BASE_URL, HttpMethod.POST,requestEntity,String.class);
        String response = responseEntity.getBody();
        System.out.println("验证票据接口："+response);
    }

    //获取用户信息接口
    @Test
    public void getUserAttributes(){
        final String REST_BASE_URL = "https://testidp.haier.net/idp/restful/getIDPUserAttributes";
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        params.add("appId","restfulTest");
        params.add("tokenId","MTAuOC40MS4xNTY=|MDg0NTVmMTQwZjc4YzZkYmE2Y2MzYmNjM2ZkYWFlYmRiMzZiOTk2NDQ5OWY1OGE3YWY0Njk4OGY1ZmM4MDExNw==|wdfWyEFwQ4b6nfDpl+tU6zHqPNA=");
        params.add("remoteIp","10.8.41.156");
        params.add("attributeNames","spOrgCodePath,sn,givenName,uid");
        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>(params,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(REST_BASE_URL, HttpMethod.POST,requestEntity,String.class);
        String response = responseEntity.getBody();
        System.out.println("获取用户信息接口："+response);
    }

    //认证中心获取票据接口
    @Test
    public void getToken(){
        final String REST_BASE_URL = "https://testidp.haier.net/idp/restful/getIDPToken";
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        params.add("appId","restfulTest");
        params.add("remoteIp","10.8.41.156");
        params.add("jsonpCallback","spOrgCodePath,sn,givenName,uid");
        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>(params,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(REST_BASE_URL, HttpMethod.POST,requestEntity,String.class);
        String response = responseEntity.getBody();
        System.out.println("获取用户信息接口："+response);
    }

    //认证中心设置票据接口---需要前端js调用
    @Test
    public void setToken(){
        final String REST_BASE_URL = "https://testidp.haier.net/idp/restful/setIDPCookie";
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        params.add("appId","restfulTest");
        params.add("remoteIp","10.8.41.156");
        params.add("tokenId","MTAuOC40MS4xNTY=|MDg0NTVmMTQwZjc4YzZkYmE2Y2MzYmNjM2ZkYWFlYmRiMzZiOTk2NDQ5OWY1OGE3YWY0Njk4OGY1ZmM4MDExNw==|wdfWyEFwQ4b6nfDpl+tU6zHqPNA=");
        params.add("jsonpCallback","spOrgCodePath,sn,givenName,uid");
        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>(params,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(REST_BASE_URL, HttpMethod.POST,requestEntity,String.class);
        String response = responseEntity.getBody();
        System.out.println("获取用户信息接口："+response);
    }

    //应用退出流程
    @Test
    public void logout(){
        final String REST_BASE_URL = "https://testidp.haier.net/idp/profile/SAML2/Redirect/GLO";
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, Object> params= new LinkedMultiValueMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        params.add("redirectToLogin",true);
        params.add("entityID","restfulTest");
        params.add("redirctToUrl","https://www.baidu.com");
        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>(params,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(REST_BASE_URL, HttpMethod.POST,requestEntity,String.class);
        String response = responseEntity.getBody();
        System.out.println("获取用户信息接口："+response);
    }


    public static String getRemoteIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
