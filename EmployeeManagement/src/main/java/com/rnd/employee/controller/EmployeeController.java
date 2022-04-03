package com.rnd.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rnd.employee.entity.Employee;
import com.rnd.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService eService;

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String home() {
		return "Welcome to Employee Management";
	}

	@GetMapping("/employee/all")
	public List<Employee> ShowAll() {
		return eService.getAll();
	}

	@GetMapping("/employee/byname/{firstname}")
	public List<Employee> getbyName(@PathVariable String firstname) {
		return eService.search(firstname);
	}

	@GetMapping("/employee/{id}")
	public Employee EmployeebyID(@PathVariable int id) {
		Employee E = eService.getById(id);
		return E;
	}
	@GetMapping("/employee/allasc")
	public List<Employee> ShowAllasc() {
		return eService.sortasc();
	}
	@GetMapping("/employee/alldesc")
	public List<Employee> ShowAlldesc() {
		return eService.sortdesc();
	}
	@PutMapping("/employee/add")
	@ResponseBody
	public Employee EmployeebyID(String id, String firstname, String lastname, String email) {
		int ID = Integer.parseInt(id);
		Employee E = new Employee(ID, firstname, lastname, email);
		eService.Add(E);
		return E;
	}
	@PostMapping("/employee/delete/{id}")
	public String DeleteEmployee(@PathVariable int id) {
		eService.Delete(id);
		return "Id: " + id + " Deleted";
	}
	@PutMapping("/employee/update")
	public Employee updateEmployee(@RequestBody Employee E) {
		eService.Update(E);
		return E;
	}
	
}
