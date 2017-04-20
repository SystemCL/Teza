package com.vlad.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vlad.model.TypeMessage;
import com.vlad.tickets.dao.TypeMessageDAO;

@Service(value="typeMessageDAO")
@Transactional
public class TypeMessageServiceImpl implements TypeMessageService {
	@Autowired
	private TypeMessageDAO typeMessageDAO;
	
	@Override
	public void addTypeMessage(TypeMessage typeMessage) {
		typeMessageDAO.addTypeMessage(typeMessage);
		
	}

	@Override
	public void updateTypeMessage(TypeMessage typeMessage) {
		typeMessageDAO.updateTypeMessage(typeMessage);
		
	}

	@Override
	public TypeMessage getTypeMessage(int id) {
		return typeMessageDAO.getTypeMessage(id);
		
	}

	@Override
	public void deleteTypeMessage(int id) {
		typeMessageDAO.deleteTypeMessage(id);
		
	}
	
	@Override
	public List<TypeMessage> getTypeMessages() {
		return typeMessageDAO.getTypeMessages();
		
	}

}
