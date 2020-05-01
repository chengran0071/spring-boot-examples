package com.wxblockchain;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.wxblockchain.mapper")
@SpringBootApplication
@NacosPropertySource(dataId = "chengran", autoRefreshed = true)
@EnableNacosDiscovery
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
