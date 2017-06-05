package com.vlad.tickets.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.vlad.model.*;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();
		
		users = sessionFactory.getCurrentSession().createQuery("from User where username=?").setParameter(0, username)
				.list();
		
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

	@Override
	public void save(User user) {
		//Session session = sessionFactory.getCurrentSession();
		Utilisateur utilisateur = new Utilisateur();
		UserRole userRole = new UserRole();
/*		user.setUsername(user.getUsername());
		user.setPassword(user.getPassword()); //bCryptPasswordEncoder.encode(...)
		user.setEnabled(true);*/
		/*session.save(user);*/
		//utilisateur.setId(user.getId());
		userRole.setUserRoleId(user.getId());
		user.setId(user.getId());
		user.setUsername(user.getUsername());
		user.setPassword(user.getPassword()); //bCryptPasswordEncoder.encode(...)
		user.setEnabled(true);
		userRole.setUser(user);
		
		
		
		
		getCurrentSession().save(user);
		//session.flush();
		
	}

}