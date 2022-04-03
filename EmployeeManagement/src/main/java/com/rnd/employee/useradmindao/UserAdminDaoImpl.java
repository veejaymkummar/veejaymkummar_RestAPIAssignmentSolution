package com.rnd.employee.useradmindao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rnd.employee.entity.Role;
import com.rnd.employee.entity.User;

@Repository
public class UserAdminDaoImpl implements UserAdminDao {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	public UserAdminDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException exception) {
			session = sessionFactory.openSession();
		}
	}

	@Override
	public String AddUser(User user) {
		Transaction txn = session.beginTransaction();
		session.save(user);
		txn.commit();
		return "User Created";
	}

	@Override
	public String AddRole(Role role) {
		Transaction txn = session.beginTransaction();
		session.save(role);
		txn.commit();
		return "Role Created";
	}

	@Override
	public List<User> getallUsers() {
		return session.createQuery("from User", User.class).getResultList();
	}

	@Override
	public List<Role> getallroles() {
		return session.createQuery("from Role", Role.class).getResultList();
	}

}
