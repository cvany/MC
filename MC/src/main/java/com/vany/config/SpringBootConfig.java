package com.vany.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.vany.interceptor.CommonInterceptor;
/**
 * Springboot配置类：添加自定义拦截器
 * @author van元
 *
 */
@Configuration
public class SpringBootConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	CommonInterceptor commonInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(commonInterceptor);
		super.addInterceptors(registry);
	}

}
