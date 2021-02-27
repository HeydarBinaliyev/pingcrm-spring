package com.app.monolightdemo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
		user.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
		userRepository.save(user);

	}

	@Override
	public UserDTO getUserById(Integer id) {
		
		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent())
			return null;

		UserDTO userDTO = mapper.map(user.get(), UserDTO.class);

		return userDTO;
	}

	@Override
	public void updateUser(Integer id, UserCreateDTO userDTO) {

		User user = null;

		try {
			user = userRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return;
		}

		user.setFirst_name(userDTO.getFirst_name());
		user.setLast_name(userDTO.getLast_name());
		user.setEmail(userDTO.getEmail());
		user.setUpdated_at(new Date());

		if (!userDTO.getPassword().isEmpty())
			user.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));

		userRepository.saveAndFlush(user);
	}

	@Override
	public void deleteUser(Integer id) {

		User user = null;
		try {
			user = userRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return;
		}
		user.setDeleted_at(new Date());
		userRepository.saveAndFlush(user);

	}

	@Override
	public void restoreUser(Integer id) {

		User user = null;
		try {
			user = userRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return;
		}
		user.setDeleted_at(null);
		userRepository.saveAndFlush(user);

	}
}
