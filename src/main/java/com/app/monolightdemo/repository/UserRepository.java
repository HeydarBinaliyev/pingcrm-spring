package com.app.monolightdemo.repository;

import java.util.List;

import com.app.monolightdemo.dto.UserDTO;
import com.app.monolightdemo.entity.User;

public interface UserRepository {

	public User getUserByUserName(String userName);
	public List<UserDTO> getAllUsers(String search, String trashed, String role);
	public void saveUser(User user);
	public User getUserById(Integer id);
	public void mergeUser(User user);
}
