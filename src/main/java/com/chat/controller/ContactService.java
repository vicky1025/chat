package com.chat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.chat.database.DatabaseClass;
import com.chat.model.Contact;
import com.chat.model.inputContact;


public class ContactService {
private Map<Integer , Contact> contacts = DatabaseClass.getContacts();
	
	public ContactService() {
		contacts.put(1, new Contact(1,"5276281989","Vignesh","G","vickii@gmail.com"));
		contacts.put(2, new Contact(2,"2676176288","Chandru","V","chandru@gmail.com"));
		contacts.put(3, new Contact(3,"6748839999","Aravind","H","aravind@gmail.com"));
		
	}
	
	public List<Contact> getAllContacts(){
		return new ArrayList<Contact>(contacts.values());
	}
	
	public Contact getContact(int contactId) {
//		System.out.println(contacts.get("Vignesh"));
		return contacts.get(contactId);
	}
	
	public Contact addContact(inputContact data ) {
		
		Contact input = new Contact(contacts.size() + 1,data.getPhoneNo() , data.getFirstName(), data.getLastName(),data.getEmail());
		int temp=contacts.size()+1;
		return contacts.put(temp,input);
		 
	}

	public Contact updateContact(inputContact data) {
//		inputContact input = new inputContact(data.getId(),data.getPhoneNo(),data.getFirstName(),data.getLastName(),data.getEmail());
		
////		if(data.getId() <= 0) {
//			return null;
//		}
//		contacts.put(firstName.getId(), firstName);
//		return firstName;
		Contact input = new Contact(data.getContactId(),data.getPhoneNo(),data.getFirstName(),data.getLastName(),data.getEmail());
		int temp = data.getContactId();
		System.out.println(data.getEmail());
		System.out.println(data.getFirstName());
//		contacts.get(temp).setPhoneNo(data.getPhoneNo());
//		contacts.get(temp).setFirstName(data.getFirstName());
//		contacts.get(temp).setPhoneNo(data.getLastName());
//		contacts.get(temp).setPhoneNo(data.getPhoneNo());
		contacts.put(temp, input);
		return contacts.get(temp);
	}
	
	
	public Contact removeContact(int contactId) {
		return contacts.remove(contactId);
	}

	
}
