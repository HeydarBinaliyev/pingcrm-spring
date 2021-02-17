package com.app.monolightdemo.repository;

import java.util.List;

import com.app.monolightdemo.dto.UserDTO;
import com.app.monolightdemo.entity.User;

public interface UserRepository {

	User getUserByUserName(String userName);
	List<UserDTO> getAllUsers(String search, String trashed, String role);
}
