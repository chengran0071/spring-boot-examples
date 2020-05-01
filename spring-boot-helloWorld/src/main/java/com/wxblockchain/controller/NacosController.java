package com.wxblockchain.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosController {

    @Autowired
    private com.wxblockchain.service.NacosConfig nacosConfig;

    @NacosInjected
    ConfigService configService;

    @NacosValue(value = "${useLocalCache:xxx}", autoRefreshed = true)
    private String useLocalCache;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String get() {
        // http://localhost:8080/config/get
        System.out.println(useLocalCache);
        return "chengran";
    }

    @RequestMapping(value = "/publish", method = RequestMethod.GET)
    @ResponseBody
    public String doPublish() {
        // http://localhost:8080/config/publish
        try {
            configService.publishConfig("example", "CHENGRAN_DEMO", "chengran=api更改");
            String config = configService.getConfig("example", "CHENGRAN_DEMO", 20000);
            configService.getConfig("example", "CHENGRAN_DEMO", 20000);
            return "chengran";
        } catch (NacosException e) {
            e.printStackTrace();
            return "chengran";
        }
    }
}
