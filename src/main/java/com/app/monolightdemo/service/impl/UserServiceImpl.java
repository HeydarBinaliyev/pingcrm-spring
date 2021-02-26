package com.app.monolightdemo.service.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.monolightdemo.bean.UserBean;
import com.app.monolightdemo.dto.UserCreateDTO;
import com.app.monolightdemo.dto.UserDTO;
import com.app.monolightdemo.entity.User;
import com.app.monolightdemo.repository.UserRepository;
import com.app.monolightdemo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserBean userBean;
	
	@Autowired
	ModelMapper mapper;
	
	
	@Override
	public List<UserDTO> getUsers(String search, String trashed, String role) {
		
		return userRepository.getAllUsers(search, trashed, role);
	}
	
	@Override
	public void storeUser(UserCreateDTO userDTO) {
		
		User user = mapper.map(userDTO, User.class);
		user.setAcccountId(userBean.getUser().getAcccountId());
		user.setPassword( new BCryptPasswordEncoder().encode(userDTO.getPassword()) );
		userRepository.saveUser(user);
		
	}
	
	@Override
	public UserDTO getUserById(Integer id) {
		User user = userRepository.getUserById(id);
		UserDTO userDTO = mapper.map(user, UserDTO.class);
		return userDTO;
	}
	
	@Override
	public void updateUser(Integer id, UserCreateDTO userDTO) {
		
		User user = userRepository.getUserById(id);
		
		user.setFirst_name(userDTO.getFirst_name());
		user.setLast_name(userDTO.getLast_name());
		user.setEmail(userDTO.getEmail());
		user.setUpdated_at(new Date());
		
		if(userDTO.getPassword() != null)
			user.setPassword( new BCryptPasswordEncoder().encode(userDTO.getPassword()) );
		
		userRepository.mergeUser(user);
	}
	
	@Override
	public void deleteUser(Integer id) {
	
		User user = userRepository.getUserById(id);
		user.setDeleted_at(new Date());
		userRepository.mergeUser(user);
		
	}
	
	@Override
	public void restoreUser(Integer id) {
		User user = userRepository.getUserById(id);
		user.setDeleted_at(null);
		userRepository.mergeUser(user);
		
	}
}
