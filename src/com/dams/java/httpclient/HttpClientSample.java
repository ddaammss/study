package com.dams.java.httpclient;

import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpClientSample {
    private static final String USER_AGENT = "Mozila/5.0";
    private static final String GET_URL = "http://www.google.com";

    public static void main(String[] args) throws ClientProtocolException, IOException {
        sendGet();
    }

    public static void sendGet() throws ClientProtocolException, IOException {

        //http client 생성
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //get 메서드와 URL 설정
        HttpGet httpGet = new HttpGet(GET_URL);

        //agent 정보 설정
        httpGet.addHeader("User-Agent", USER_AGENT);

        //get 요청
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        System.out.println("::GET Response Status::");

        //response의 status 코드 출력
        System.out.println(httpResponse.getCode());


        BufferedReader reader = new BufferedReader(new InputStreamReader(
                httpResponse.getEntity().getContent()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }

        reader.close();

        //Print result
        System.out.println(response.toString());
        httpClient.close();
    }
}
