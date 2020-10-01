package com.lzh.dayDayUp.web;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.*;
import com.lzh.dayDayUp.util.HttpUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cmcc/sso")
public class CmccSsoController {


    @GetMapping("/getToken")
    public String getToken(@RequestParam(name = "token") String token) {
        //获取token
        System.out.println("getToken..." + token);
        //发送到checkToken，同时cookie中携带token
        String urlPath = "http://cmsroa.com:9088/view/mainTool/checkToken";
        String name = "username";
        //String sb =  sendRequest(urlPath,cookie);

/*        Cookie cookie = new Cookie("cmsr-token",token);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60*5);//五分钟*/
        String cmsrToken= "cmsr-token="+token;
        String result = doGet(urlPath,cmsrToken);
        System.out.println("result:"+result);

        // 返回一个结果得到用户名
        if (result!=null && !result.equals("")){
            System.out.println("username:"+result);
            String info = "登录成功";
            Map<String, Object> headers = new HashMap<>(16);
            headers.put("Content-Type", "application/json");
            headers.put("Accept", "application/json");
            Map<String, Object> params = new HashMap<>(16);
            params.put("info", info);
            HttpUtils.httpGet(urlPath,params,headers);
        }
        return "ok";
    }


    @GetMapping("/getToken2")
    public String getToken(HttpServletRequest request, HttpServletResponse response) {
        String token="";
        if (request.getCookies()!=null) {
            Cookie[] cookies = request.getCookies();
            for (Cookie c : cookies) {
                if (c.getName().equals("cmsr-token")){
                    token= c.getValue();
                }
            }
        }
        //获取token
        System.out.println("getToken..." + token);
        //发送到checkToken，同时cookie中携带token
        String urlPath = "http://cmsroa.com:9088/view/mainTool/checkToken";
        String name = "username";
        //String sb =  sendRequest(urlPath,cookie);

/*        Cookie cookie = new Cookie("cmsr-token",token);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60*5);//五分钟*/
        String cmsrToken= "cmsr-token="+token;
        String result = doGet(urlPath,cmsrToken);
        // 返回一个结果得到用户名
        System.out.println("result:"+result);
        if (result!=null && !result.equals("")){
            System.out.println("username:"+result);
            String info = "登录成功";
            Map<String, Object> headers = new HashMap<>(16);
            headers.put("Content-Type", "application/json");
            headers.put("Accept", "application/json");
            Map<String, Object> params = new HashMap<>(16);
            params.put("info", info);
            HttpUtils.httpGet(urlPath,params,headers);
        }
        System.out.println("ok");
        return "ok";
    }

    @GetMapping("/checkToken")
    public String checkToken(HttpServletRequest request, HttpServletResponse response) {
        if (request.getCookies()!=null) {
            Cookie[] cookies = request.getCookies();
            for (Cookie c : cookies) {
                System.out.println("++++++++++++++++++++" + c.getValue());
                System.out.println("++++++++++++++++++++" + c.getName());
            }
        }
        return "username";
    }
    public static String doGet(String url, String token) {
        try {
            //创建get请求
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader(new BasicHeader("Cookie", token));
            httpGet.setHeader("Connection", "keep-alive");
            HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
            CloseableHttpClient httpClient = httpClientBuilder.build();
            HttpResponse httpResponse = httpClient.execute(httpGet);
            // 响应状态
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = httpResponse.getEntity();
                return EntityUtils.toString(entity, "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
}
