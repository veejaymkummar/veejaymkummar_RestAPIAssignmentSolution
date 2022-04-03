package com.rnd.employee.useradminservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rnd.employee.entity.Role;
import com.rnd.employee.entity.User;
import com.rnd.employee.useradmindao.UserAdminDao;

@Service
public class UserAdminServiceImpl implements UserAdminService {

	@Autowired
	UserAdminDao userAdminDao;

	@Override
	public String AddU(User user) {
		return userAdminDao.AddUser(user);
	}

	@Override
	public String AddR(Role role) {
		return userAdminDao.AddRole(role);
	}

	@Override
	public List<User> AllUsers() {
		return userAdminDao.getallUsers();
	}

	@Override
	public List<Role> AllRoles() {
		return userAdminDao.getallroles();
	}

}
