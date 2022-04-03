package com.rnd.employee.useradminservice;

import java.util.List;

import com.rnd.employee.entity.Role;
import com.rnd.employee.entity.User;

public interface UserAdminService {

	public String AddU(User user);

	public String AddR(Role role);

	public List<User> AllUsers();

	public List<Role> AllRoles();
}
