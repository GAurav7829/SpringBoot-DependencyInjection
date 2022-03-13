package com.i18n;

import com.grv.service.GreetingService;

//@Service
public class I18nGreetingServiceFactory {
	public GreetingService getI18nService(String type) {
		switch (type) {
		case "EN":
			return new I18nEnglishGreetingService(null);
		case "ES":
			return new I18nSpanishGreetingService();
		default:
			return new I18nSpanishGreetingService();
		}
	}
}
