package com.neo.service;

import com.alibaba.nacos.api.config.annotation.NacosValue;

import lombok.Getter;
import org.springframework.stereotype.Component;


@Component
@Getter
public class NacosConfig {

    @NacosValue(value = "${chengran:11}", autoRefreshed = true)
    private String chengran;
}
