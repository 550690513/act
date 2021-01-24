package org.crazyit.act.c37_activitiAdminCxf;

import java.io.InputStream;

import javax.ws.rs.core.Response;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;

public class TempClient {

    public static void main(String[] args) throws Exception {
        // repository/process-definitions

        // // 创建WebClient，设置URL、认证用户名和密码
        // WebClient client = WebClient
        // .create("http://localhost:8080/activiti-rest/service/"
        // + "repository/process-definitions?key=abcProcess",
        // "abc", "123", null);
        // // 设置认证格式为基础认证格式
        // String authorizationHeader = "Basic "
        // + org.apache.cxf.common.util.Base64Utility
        // .encode("user:password".getBytes());
        // client.header("Authorization", authorizationHeader);
        // // 获取响应
        // Response response = client.get();
        // // 获取响应内容
        // InputStream ent = (InputStream) response.getEntity();
        // String content = IOUtils.readStringFromStream(ent);
        // // 输出字符串
        // System.out.println(content);

        // 启动流程
        String defId = "abcProcess:1:255004";
        String key = "abcProcess";
        StringBuffer params = new StringBuffer("{");
        params.append("\"processDefinitionId\":");
        params.append("\"" + defId + "\",");
        params.append("\"businessKey\":");
        params.append("\"" + key + "\"");
        params.append("}");
        
        
        System.out.println(params);

        // 创建WebClient，设置URL、认证用户名和密码
        WebClient client = WebClient.create(
                "http://localhost:8080/activiti-rest/service/"
                        + "runtime/process-instances", "abc", "123", null);
        // 设置认证格式为基础认证格式
        String authorizationHeader = "Basic "
                + org.apache.cxf.common.util.Base64Utility
                        .encode("user:password".getBytes());
        client.header("Authorization", authorizationHeader);
        client.header("Content-Type", "application/json;charset=UTF-8");

        Response response = client.post(params.toString());
        InputStream ent = (InputStream) response.getEntity();
        String content = IOUtils.readStringFromStream(ent);
        System.out.println(content);
    }

}
