package org.crazyit.act.c37_activitiAdminCxf;

import java.io.InputStream;

import javax.ws.rs.core.Response;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;

public class StartProcessMain {

    public static void main(String[] args) throws Exception {
        // 创建WebClient，设置URL、认证用户名和密码，注意用户名密码在 ACT_ID_USER 表配置
        WebClient client = WebClient.create(
                "http://localhost:8080/activiti-rest/service/runtime/process-instances",
                "abc", "123", null);
        // 设置认证格式为基础认证格式
        String authorizationHeader = "Basic "
                + org.apache.cxf.common.util.Base64Utility
                        .encode("user:password".getBytes());
        client.header("Authorization", authorizationHeader);
        client.header("Content-Type", "application/json;charset=UTF-8");
        
        String params = "{\"processDefinitionId\":\"restProcess:1:257504\", \"businessKey\":\"restProcess\"}";
        
        
        // 获取响应
        Response response = client.post(params);
        // 获取响应内容
        InputStream ent = (InputStream) response.getEntity();
        String content = IOUtils.readStringFromStream(ent);
        // 输出字符串
        System.out.println(content);
    }

}
