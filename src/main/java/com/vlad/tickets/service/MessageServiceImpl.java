package com.vlad.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vlad.model.Message;
import com.vlad.tickets.dao.MessageDAO;

@Service(value="messageDAO")
@Transactional
public class MessageServiceImpl implements MessageService{
	@Autowired
	private MessageDAO messageDAO;
	
	@Override
	public void addMessage(Message message) {
		messageDAO.addMessage(message);
		
	}

	@Override
	public void updateMessage(Message message) {
		messageDAO.updateMessage(message);
		
	}

	@Override
	public Message getMessage(int id) {
		return messageDAO.getMessage(id);
		
	}

	@Override
	public void deleteMessage(int id) {
		messageDAO.deleteMessage(id);
		
	}
	
	@Override
	public List<Message> getMessages() {
		return messageDAO.getMessages();
		
	}
	

}
