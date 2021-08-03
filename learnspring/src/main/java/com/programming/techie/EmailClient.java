package com.programming.techie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EmailClient {
	@Autowired
	@Qualifier("advancedSpellChecker") 
	private SpellChecker spellChecker;
	
//	EmailClient() {
//	}
//	
//	public SpellChecker getSpellChecker() {
//		return spellChecker;
//	}
//
//	@Autowired
//	public void setSpellChecker(@Qualifier("advancedSpellChecker") SpellChecker spellChecker) {
//		this.spellChecker = spellChecker;
//	}

	void sendEmail(String emailMessage) {
		spellChecker.checkSpelling(emailMessage);
	}
}
