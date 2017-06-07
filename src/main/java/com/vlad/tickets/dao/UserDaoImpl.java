package com.vlad.tickets.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
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
		int value = getLastId();
		value++;
		user.setId(value);
		user.setEnabled(true);
		getCurrentSession().save(user);
		sessionFactory.getCurrentSession().flush();
		
	}

	@Override
	public boolean isUserExists(User user) {
		boolean result = false;
		
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Users where id='" + user.getId() + "");
			User u = (User) query.uniqueResult();
			if (u != null)
				result = true;
		} catch (Exception ex) {
			// TODO: handle exception
		} finally {
			//sessionFactory.getCurrentSession().close();
		}
		return result;
	}

	public int getLastId(){
		Criteria c = sessionFactory.getCurrentSession().createCriteria(User.class);
        c.addOrder(Order.desc("id"));
        c.setMaxResults(1);
        int id = (int) ((User) c.uniqueResult()).getId();
		return id;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> getSearchRoles() {
		return getCurrentSession().createQuery("from user_roles").list();
		
	}
	
}