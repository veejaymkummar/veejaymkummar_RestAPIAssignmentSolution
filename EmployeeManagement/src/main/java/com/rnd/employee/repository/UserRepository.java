package com.rnd.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rnd.employee.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("Select u From User u Where u.username=?1")
	public User getUserByUsername(String username);
}
