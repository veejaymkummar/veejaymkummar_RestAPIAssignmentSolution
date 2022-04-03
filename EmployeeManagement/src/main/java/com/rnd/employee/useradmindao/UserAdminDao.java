package com.rnd.employee.useradmindao;

import java.util.List;

import com.rnd.employee.entity.Role;
import com.rnd.employee.entity.User;

public interface UserAdminDao {

	public String AddUser(User user);

	public String AddRole(Role role);

	public List<User> getallUsers();

	public List<Role> getallroles();
}
