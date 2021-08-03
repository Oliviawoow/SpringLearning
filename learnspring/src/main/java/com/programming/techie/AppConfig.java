package com.programming.techie;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.programming.techie")
public class AppConfig {
	@Bean(name = "basicSpellChecker", initMethod = "init", destroyMethod = "destroy")
	public BasicSpellChecker creaBasicSpellChecker() {
		return new BasicSpellChecker();
	}
//	
//	@Bean(name = "advancedSpellChecker")
//	public AdvancedSpellChecker creaAdvancedSpellChecker() {
//		return new AdvancedSpellChecker();
//	}
//	
//	@Bean(name = "emailClient")
//	public EmailClient creatEmailClient() {
//		EmailClient emailClient= new EmailClient();
//		emailClient.setSpellChecker(creaAdvancedSpellChecker());
//		return emailClient;
//	}
}
