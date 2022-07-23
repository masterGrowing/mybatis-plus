package com.test.testformybatis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.testformybatis.dao.UserMapper;
import com.test.testformybatis.pojo.User;

import org.apache.http.HttpEntity;

import org.apache.http.StatusLine;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;

import java.nio.charset.StandardCharsets;

import java.util.List;


@SpringBootTest
class TestForMybatisApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        int i = userMapper.deleteById(1);
        System.out.println("删除成功，影响行数：" + i);
        System.out.println(users);

    }

    @Test
    void testHttp() {
        HttpEntity entity;
        String result;

        CloseableHttpClient client = HttpClientBuilder.create().build();

        String url = "http://localhost:8080/updateUser";

        HttpGet getMethod = new HttpGet(url);
        CloseableHttpResponse response;


        //发送请求
        try {
            response = client.execute(getMethod);

            //获取状态码
            StatusLine statusLine = response.getStatusLine();
            System.out.println(statusLine);

            System.out.println(statusLine.getStatusCode());
            if (statusLine.getStatusCode() != 200) {
                System.out.println("调用接口失败！");
            }

            //获取响应信息
            entity = response.getEntity();
            result = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public PageInfo<User> pageTest(){
        PageHelper.startPage(1, 3);
        List<User> users = userMapper.selectList(null);
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        System.out.println("获取到用户信息："+userPageInfo);
        return userPageInfo;
    }
}


/*    @Test
    public void HttpClientTest(){

            String url = "http://localhost:8080/addUser";
            HttpClient httpClient = new HttpClient();
            HttpPost post = new HttpPost(url);
            Map<String, String> params = new HashMap<>();
            params.put("username","张三");
            params.put("phone","1231231312");
            params.put("email","dasdsa@ddad.com.cn");
            post.addHeader();
        RequestEntity entity = new StringRequestEntity()

}*/
