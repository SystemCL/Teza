package com.vlad.tickets.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vlad.model.Message;

@Repository
public class MessageDAOImpl implements MessageDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addMessage(Message message) {
		getCurrentSession().save(message);
		
	}

	@Override
	public void updateMessage(Message message) {
		Message messageToUpdate = getMessage(message.getId());
		messageToUpdate.setBodyMessage(message.getBodyMessage());
		messageToUpdate.setDateCreationM(message.getDateCreationM());
        //
		getCurrentSession().update(messageToUpdate);
		
	}

	@Override
	public void deleteMessage(int id) {
		Message message = getMessage(id);
		if(message != null)
			getCurrentSession().delete(message);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getMessages() {
		return getCurrentSession().createQuery("from Message").list();
	}

	@Override
	public Message getMessage(int id) {
		Message message = (Message) getCurrentSession().get(Message.class, id);
		return message;
	}

}
