package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class MainController {
    @GetMapping("/hi")
    public String getHi() throws Exception {

        JaxWsDynamicClientFactory jaxWsDynamicClientFactory = JaxWsDynamicClientFactory.newInstance();

        Client client = jaxWsDynamicClientFactory.createClient("http://127.0.0.1:8090/ws/hello?wsdl");

        Object[] objects;

        HashMap params = new HashMap();

        params.put("task", "yzn");

        objects = client.invoke("sayHello", JSONObject.toJSONString(params));

        if (objects != null) {
            return (String) objects[0];
        }

        return "222";
    }
}
