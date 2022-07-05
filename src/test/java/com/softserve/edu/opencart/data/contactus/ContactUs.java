package com.softserve.edu.opencart.data.contactus;

import java.util.Objects;

interface IYourName {
	IEmail setYourName(String yourname);
}

interface IEmail {
	IEnquiry setEmail(String email);
}

interface IEnquiry {
	IContactUsBuild setEnquiry(String enquiry);
}

interface IContactUsBuild {
	IContactUs build();
}

public class ContactUs implements IYourName, IEmail, IEnquiry, IContactUsBuild, IContactUs {
	
	private String yourname;
	private String email;
	private String enquiry;
	
	private ContactUs() {	
	}
	
	// setters
	public static IYourName get() {
		return new ContactUs();
	}
	
	public IEmail setYourName(String yourname) {
		this.yourname = yourname;
		return this;
	}
	
	public IEnquiry setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public IContactUsBuild setEnquiry(String enquiry) {
		this.enquiry = enquiry;
		return this;
	}
	
	public IContactUs build() {
		return this;
	}
	
	// getters
	public String getYourName() {
		return yourname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getEnquiry() {
		return enquiry;
	}

	@Override
	public String toString() {
		return "ContactUs{" + 
				"yourname=" + yourname + '\'' +
				", email=" + email + '\'' +
				", enquiry=" + enquiry + '\'' +
				"}";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, enquiry, yourname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactUs other = (ContactUs) obj;
		return Objects.equals(email, other.email) && Objects.equals(enquiry, other.enquiry)
				&& Objects.equals(yourname, other.yourname);
	}
	
	

}
