package com.rnd.employee.service;

import java.util.List;

import com.rnd.employee.entity.Employee;

public interface EmployeeService {

	public Boolean Add(Employee E);

	public Boolean Update(Employee E);

	public Boolean Delete(int id);

	public Employee getById(int id);

	public List<Employee> getAll();

	public List<Employee> sortasc();
	
	public List<Employee> sortdesc();
	
	public List <Employee> search(String FirstName);
}
