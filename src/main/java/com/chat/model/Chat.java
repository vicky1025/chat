package com.chat.model;

public class Chat { 
	private int chatID;
	private String userName;
	private String message;
	private String messageStatus;
	public Chat() {
		// TODO Auto-generated constructor stub
	}
	
	public Chat(int chatID, String userName, String message, String messageStatus) {
		super();
		this.chatID = chatID;
		this.userName = userName;
		this.message = message;
		this.messageStatus = messageStatus;

	}
	
	

	public int getChatID() {
		return chatID;
	}
	public void setChatID(int chatID) {
		this.chatID = chatID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageStatus() {
		return messageStatus;
	}
	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}
	
	
	

}
