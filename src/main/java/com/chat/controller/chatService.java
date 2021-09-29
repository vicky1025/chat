package com.chat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.chat.database.DatabaseChat;
import com.chat.model.Chat;
import com.chat.model.inputChat;




public class chatService {
	private Map<Integer , Chat> chats = DatabaseChat.getChats();
	public chatService() {
		chats.put(1, new Chat(1,"Vignesh","Welcome,Vignesh","Sent"));
		chats.put(2, new Chat(2,"Aravind","Hello,Aravind","Sent"));
		chats.put(3, new Chat(3,"Chandru","Hello,Chandru","Sent"));
	}
//	public chatService() {
//		chats.put(1, new Chat(1,"Vignesh","Welcome, Vignesh","Sent"));
//		chats.put(2, new Chat(2,));
//		chats.put(3, new Chat(3,));
//		
//	}
	
	public List<Chat> getAllChats(){
		
		return new ArrayList<Chat>(chats.values());
	}
	
	public Chat getChat(int chatId) {
//		System.out.println(contacts.get("Vignesh"));
		chats.get(chatId).setMessageStatus("Read");
		return chats.get(chatId);
	}
	
	public Chat addChat(inputChat data) {
		Chat input = new Chat(chats.size()+1,data.getUserName(),data.getMessage(),"sent");
		//Chat input = new Chat (chats.size()+1, data.getName(),data.getLastMessage(),data.getLastSeen(),data.getMessageStatus());
		int temp = chats.size()+1;
		return chats.put(temp,input);
	}
	
	public Chat updateChat(inputChat data) {
		Chat input  = new Chat(data.getChatID(),data.getUserName(),data.getMessage(),"sent");
		int i = data.getChatID();
		chats.put(i, input);
		return chats.get(i);
	}
	



	public Chat removeChat(int chatId) {
		return chats.remove(chatId);
	}

}
