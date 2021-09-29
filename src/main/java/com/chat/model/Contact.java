package com.chat.model;

public class Contact {
	private int contactId;
	private String phoneNo;
	private String firstName;
	private String lastName;
	private String email;
	
	public Contact() {}
	
	public Contact(int contactId,String phoneNo, String firstName, String lastName, String email) {
		super();
		this.contactId = contactId;
		this.phoneNo = phoneNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int id) {
		this.contactId = id;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
