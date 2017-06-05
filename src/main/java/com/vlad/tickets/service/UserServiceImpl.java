package com.vlad.tickets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vlad.model.User;
import com.vlad.tickets.dao.UserDao;

@Service(value="userDAO")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDAO;

	@Override
	public void save(User user) {
		userDAO.save(user);
		
	}

	@Override
	public User findByUserName(String username) {
		return userDAO.findByUserName(username);
	}
}
