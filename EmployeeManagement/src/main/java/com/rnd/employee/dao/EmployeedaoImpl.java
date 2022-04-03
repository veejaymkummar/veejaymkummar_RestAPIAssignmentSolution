package com.rnd.employee.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rnd.employee.entity.Employee;

@Repository
public class EmployeedaoImpl implements Employeedao {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	public EmployeedaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException exception) {
			session = sessionFactory.openSession();
		}
	}

	@Override
	public boolean addEmployee(Employee employee) {
		Transaction txn = session.beginTransaction();
		session.save(employee);
		txn.commit();
		return true;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		Transaction txn = session.beginTransaction();
		session.merge(employee);
		txn.commit();
		return true;
	}

	@Override
	public boolean deleteEmployee(int id) {
		Transaction txn = session.beginTransaction();
		Employee E = new Employee();
		E = session.get(Employee.class, id);
		session.delete(E);
		txn.commit();
		return true;
	}

	@Override
	public Employee getEmployeebyID(int id) {
		Employee E = session.get(Employee.class, id);
		return E;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return session.createQuery(" from Employee", Employee.class).getResultList();
	}

	@Override
	public List<Employee> getAllEmployeeasc() {
		Query<Employee> sortQuery = session.createQuery("from Employee order by firstname asc", Employee.class);
		List<Employee> employees = sortQuery.getResultList();
		return employees;
	}

	@Override
	public List<Employee> getbyFirstName(String firstname) {
		Query<Employee> SearchQuery = session.createQuery("from Employee Where firstname = :variable");
		SearchQuery.setParameter("variable", firstname);
		List<Employee> E = SearchQuery.getResultList();
		return E;
	}

	@Override
	public List<Employee> getAllEmployeedesc() {
		Query<Employee> sortQuery = session.createQuery("from Employee order by firstname desc", Employee.class);
		List<Employee> employees = sortQuery.getResultList();
		return employees;
	}

}
