package com.app.monolightdemo.service;

import java.util.List;

import com.app.monolightdemo.dto.UserCreateDTO;
import com.app.monolightdemo.dto.UserDTO;


public interface UserService {

	public List<UserDTO> getUsers(String search, String trashed, String role);
	public void storeUser(UserCreateDTO userDTO);
	public UserDTO getUserById(Integer id);
	public void updateUser(Integer id, UserCreateDTO userDTO);
	public void deleteUser(Integer id);
	public void restoreUser(Integer id);
}
