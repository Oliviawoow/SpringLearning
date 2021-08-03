package com.programming.techie;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
//@Primary
public class BasicSpellChecker implements SpellChecker {

	public void init() {
		System.out.println("Inside init Basic Spell Checker");
	}

	public void checkSpelling(String emailMessage) {
		if (emailMessage != null) {
			System.out.println("Checking spelling using Basic Spell Checker...");
			System.out.println("Spell Checking Completed!");
		} else {
			throw new RuntimeException("An exception occured while checking Spelling");
		}
	}

	public void destroy() {
		System.out.println("Inside destroy Basic Spell Checker");
	}
}
