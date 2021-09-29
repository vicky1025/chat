package com.chat.database;

import java.util.HashMap;
import java.util.Map;

import com.chat.model.Chat;

public class DatabaseChat {
	private static Map<Integer, Chat> chats = new HashMap<>();
	
	public static Map<Integer , Chat> getChats(){
		return chats;
	}

}
