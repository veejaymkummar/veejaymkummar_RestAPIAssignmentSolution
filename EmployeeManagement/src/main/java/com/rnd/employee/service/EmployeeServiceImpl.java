package com.rnd.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rnd.employee.dao.Employeedao;
import com.rnd.employee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private Employeedao employeeDao;

	@Override
	public Boolean Add(Employee E) {
		return employeeDao.addEmployee(E);
	}

	@Override
	public Boolean Update(Employee E) {
		return employeeDao.updateEmployee(E);
	}

	@Override
	public Boolean Delete(int id) {
		return employeeDao.deleteEmployee(id);
	}

	@Override
	public Employee getById(int id) {
		return employeeDao.getEmployeebyID(id);
	}

	@Override
	public List<Employee> getAll() {
		return employeeDao.getAllEmployee();
	}

	@Override
	public List<Employee> sortasc() {
		return employeeDao.getAllEmployeeasc();
	}

	@Override
	public List<Employee> search(String FirstName) {
		return employeeDao.getbyFirstName(FirstName);
	}

	@Override
	public List<Employee> sortdesc() {
		return employeeDao.getAllEmployeedesc();
	}

}
