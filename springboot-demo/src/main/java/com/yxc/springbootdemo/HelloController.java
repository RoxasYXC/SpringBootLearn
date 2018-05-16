package com.yxc.springbootdemo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final Logger logger = org.apache.log4j.Logger.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(){
        if(client != null){
            ServiceInstance instance = client.getLocalServiceInstance();
            logger.info("/hello,host:"+instance.getHost()+",service_Id:"+instance.getServiceId());
        }
        return "hello world";
    }

    @RequestMapping("/test")
    public String test(){
        return "Test world";
    }
}
