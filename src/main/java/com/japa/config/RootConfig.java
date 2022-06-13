package com.japa.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class RootConfig {
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource source
			= new ReloadableResourceBundleMessageSource();
		source.setBasenames("classpath:/message/message","classpath:/message/errors");
		// /message/message.properties
		// /message/message_ko.properties
		source.setDefaultEncoding("utf-8");
		return source;
	}
	
	@Bean
	public SessionLocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}		
	
}
