package com.vlad.tickets.dao;

import java.util.List;

import com.vlad.model.TypeMessage;


public interface TypeMessageDAO {
	
	public void addTypeMessage(TypeMessage typeMessage);
	public void updateTypeMessage(TypeMessage typeMessage);
	public TypeMessage getTypeMessage(int id);
	public void deleteTypeMessage(int id);
	public List<TypeMessage> getTypeMessages();

}
