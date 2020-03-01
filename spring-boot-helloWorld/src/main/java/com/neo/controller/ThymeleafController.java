package com.neo.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.neo.service.NacosConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThymeleafController {

	/**
	 * 使用modelAndView 渲染页面
	 */
	@RequestMapping("/demo")
	@ResponseBody
	public ModelAndView demo(Locale locale, Model model) throws NacosException {
		ModelAndView mv = new ModelAndView("chengran");
		return mv;
	}

}