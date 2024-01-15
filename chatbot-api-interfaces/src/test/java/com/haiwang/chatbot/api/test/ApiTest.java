package com.haiwang.chatbot.api.test;


import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");

        get.addHeader("cookie","zsxq_access_token=76C74455-ED6F-0358-7C29-09551D483CAB_1796C7FD53ADDC62; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22182881521281222%22%2C%22first_id%22%3A%2218cfdcf36ac6e3-04a021b641511e8-26001951-1327104-18cfdcf36adbcc%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjZmRjZjM2YWM2ZTMtMDRhMDIxYjY0MTUxMWU4LTI2MDAxOTUxLTEzMjcxMDQtMThjZmRjZjM2YWRiY2MiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIxODI4ODE1MjEyODEyMjIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22182881521281222%22%7D%2C%22%24device_id%22%3A%2218cfdcf36ac6e3-04a021b641511e8-26001951-1327104-18cfdcf36adbcc%22%7D; zsxqsessionid=b3213c6bfcc7c029917fa24a86fc492a\n");

        get.addHeader("Content-Type","application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);

        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/811442211518242/comments");
        post.addHeader("cookie","zsxq_access_token=76C74455-ED6F-0358-7C29-09551D483CAB_1796C7FD53ADDC62; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22182881521281222%22%2C%22first_id%22%3A%2218cfdcf36ac6e3-04a021b641511e8-26001951-1327104-18cfdcf36adbcc%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjZmRjZjM2YWM2ZTMtMDRhMDIxYjY0MTUxMWU4LTI2MDAxOTUxLTEzMjcxMDQtMThjZmRjZjM2YWRiY2MiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIxODI4ODE1MjEyODEyMjIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22182881521281222%22%7D%2C%22%24device_id%22%3A%2218cfdcf36ac6e3-04a021b641511e8-26001951-1327104-18cfdcf36adbcc%22%7D; zsxqsessionid=b3213c6bfcc7c029917fa24a86fc492a\n");
        post.addHeader("Content-Type","application/json;charset=utf8");

        String paramJson ="{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"测试2\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json","UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);

        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
