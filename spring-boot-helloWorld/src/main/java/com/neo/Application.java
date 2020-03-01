package com.neo;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.neo.mapper")
@SpringBootApplication
@NacosPropertySource(dataId = "example", autoRefreshed = true)
@EnableNacosDiscovery
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
