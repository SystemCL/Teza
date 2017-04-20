package com.vlad.tickets.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vlad.model.TypeMessage;

@Repository
public class TypeMessageDAOImpl implements TypeMessageDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addTypeMessage(TypeMessage typeMessage) {
		getCurrentSession().save(typeMessage);
		
	}

	@Override
	public void updateTypeMessage(TypeMessage typeMessage) {
		TypeMessage typeMessageToUpdate = getTypeMessage(typeMessage.getId());
		typeMessageToUpdate.setNomTypeMessage(typeMessage.getNomTypeMessage());
        //
		getCurrentSession().update(typeMessageToUpdate);
		
	}

	@Override
	public void deleteTypeMessage(int id) {
		TypeMessage typeMessage = getTypeMessage(id);
		if(typeMessage != null)
			getCurrentSession().delete(typeMessage);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeMessage> getTypeMessages() {
		return getCurrentSession().createQuery("from TypeMessage").list();
	}

	@Override
	public TypeMessage getTypeMessage(int id) {
		TypeMessage typeMessage = (TypeMessage) getCurrentSession().get(TypeMessage.class, id);
		return typeMessage;
	}

}
