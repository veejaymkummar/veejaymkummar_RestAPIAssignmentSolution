package com.rnd.employee.dao;

import java.util.List;

import com.rnd.employee.entity.Employee;

public interface Employeedao {

	public boolean addEmployee(Employee employee);

	public boolean updateEmployee(Employee employee);

	public boolean deleteEmployee(int id);

	public Employee getEmployeebyID(int id);

	public List<Employee> getbyFirstName(String FirstName);

	public List<Employee> getAllEmployee();

	public List<Employee> getAllEmployeeasc();

	public List<Employee> getAllEmployeedesc();
}
