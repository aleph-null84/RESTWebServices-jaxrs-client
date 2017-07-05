package com.yuriy.traning.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.yuriy.traning.messenger.database.DatabaseClass;
import com.yuriy.traning.messenger.exception.DataNotFoundException;
import com.yuriy.traning.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		if (messages.isEmpty()) {
		    System.out.println("Constructor of MessageService");
		    messages.put(1L, new Message(1L, "Hello World!", "Yuriy"));
		    messages.put(2L, new Message(2L, "Some Text!", "Homer"));
		}
	}
	
	/*
	public List<Message> getAllMessages() {
		Message m1 = new Message(1L, "Hello World!", "Yuriy");
		Message m2 = new Message(2L, "Some Text!", "Homer");
		
		List<Message> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;
	}
	*/
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values()); 
	}
	
	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size) {
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if (start + size > list.size()) return new ArrayList<Message>();
		return list.subList(start, start + size); 
	}
	
	public Message getMessage(long id) {
		Message message =  messages.get(id);
		if (message == null) {
			throw new DataNotFoundException("Message with id: " + id + " not found");
		}
		return message;
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		System.out.println("id " + message.getId());
		System.out.println("message before " + message.getMessage());
		messages.put(message.getId(), message);
		System.out.println("message after " + message.getMessage());
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}	

}
