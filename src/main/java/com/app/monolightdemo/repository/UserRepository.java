package com.app.monolightdemo.repository;

import java.util.List;

import com.app.monolightdemo.dto.UserDTO;
import com.app.monolightdemo.entity.User;
import com.app.monolightdemo.exception.GeneralException;


public interface UserRepository {

	User getUserByUserName(String userName);
	UserDTO getUserDTOByUserName(String userName) throws Exception;
	User createuser(UserDTO userDTO) throws Exception;
	List<UserDTO> getAllUsers(Integer max,Integer offset,String userName);
	Integer getAllUsersCount(String userName);
	void updateUser(UserDTO userDTO) throws GeneralException;
	void deleteUser(Long id) throws GeneralException;
}
