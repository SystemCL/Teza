package com.vlad.tickets.service;

import java.util.List;

import com.vlad.model.Message;

public interface MessageService {
	public void addMessage(Message message);
	public void updateMessage(Message message);
	public Message getMessage(int id);
	public void deleteMessage(int id);
	public List<Message> getMessages();

}
