package com.programming.techie;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class AdvancedSpellChecker implements SpellChecker, 
InitializingBean, DisposableBean{
	public void checkSpelling(String emailMessage) {
		if(emailMessage != null) {
			System.out.println("Checking spelling using Advances Spell Checker...");
			System.out.println("Spell Checking Completed!");
		} else {
			throw new RuntimeException("An exception occured while checking Spelling");
		}
	}

	public void destroy() throws Exception {
		System.out.println("Destroy Properties");		
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Setting Properties after Bean is initialized");		
	}
}
