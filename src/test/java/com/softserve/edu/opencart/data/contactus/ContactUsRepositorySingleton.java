package com.softserve.edu.opencart.data.contactus;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class ContactUsRepositorySingleton {
	
	private static volatile ContactUsRepositorySingleton instance = null;
	private final String TIME_TEMPLATE = "HH_mm_ss_S";
	
	private ContactUsRepositorySingleton() {
	}
	
	public static ContactUsRepositorySingleton get() {
		if(instance == null) {
			synchronized (ContactUsRepositorySingleton.class) {
				if (instance == null) {
					instance = new ContactUsRepositorySingleton();
				}
			}
		}
		return instance;
	}
	
	public IContactUs getDefault() {
		return guest();
	}
	
	public IContactUs guest() {
		String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
	    String guestEmail = "temp" + currentTime + "@gmail.com";
		return ContactUs.get()
				.setYourName("user")
				.setEmail(guestEmail)
				.setEnquiry("Guest message")
				.build();
	}
	
	public IContactUs loggedUser() {
		return ContactUs.get()
				.setYourName("")
				.setEmail("")
				.setEnquiry("Logged Message")
				.build();
	}
	
	public IContactUs invalidData() {
		return ContactUs.get()
				.setYourName("")
				.setEmail("")
				.setEnquiry("")
				.build();
	}
	
}
