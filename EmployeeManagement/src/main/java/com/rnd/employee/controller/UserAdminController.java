package com.rnd.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rnd.employee.entity.Role;
import com.rnd.employee.entity.User;
import com.rnd.employee.useradminservice.UserAdminService;

@RestController
public class UserAdminController {

	@Autowired
	UserAdminService userAdminService;

	@GetMapping("/user")
	public String UserManageementHome() {
		return "Welcome to User Management";
	}

	@GetMapping("/user/all")
	public List<User> AllUsers() {
		return userAdminService.AllUsers();
	}

	@PutMapping("/user/add")
	public User AddUser(@RequestBody User user) {
		userAdminService.AddU(user);
		return user;
	}

	@GetMapping("/role")
	public String RoleManagementHome() {
		return "Welcome to Role Management";
	}

	@GetMapping("/role/all")
	public List<Role> AllRoles() {
		return userAdminService.AllRoles();
	}

	@PutMapping("/role/add")
	public Role AddRole(@RequestBody Role role) {
		userAdminService.AddR(role);
		return role;

	}

}
