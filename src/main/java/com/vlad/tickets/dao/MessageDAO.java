package com.vlad.tickets.dao;

import java.util.List;

import com.vlad.model.Message;

public interface MessageDAO {
	public void addMessage(Message message);
	public void updateMessage(Message message);
	public Message getMessage(int id);
	public void deleteMessage(int id);
	public List<Message> getMessages();

}
