package com.chat.database;

import java.util.HashMap;
import java.util.Map;


import com.chat.model.Contact;

public class DatabaseClass {
	private static Map<Integer , Contact> contacts = new HashMap<>();
	
	
	public static Map<Integer ,Contact> getContacts(){
		return contacts;
	}
	
	

}
