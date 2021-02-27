package com.app.monolightdemo.repository.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.app.monolightdemo.dto.UserDTO;
import com.app.monolightdemo.entity.User;
import com.app.monolightdemo.repository.UserRepositoryCustom;





@Repository
@Transactional
public class UserRepositoryImpl  implements UserRepositoryCustom{

	@Autowired
	EntityManager em;
	

	@Override
	public List<UserDTO> getAllUsers(String search, String trashed, String role) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from User where first_name like :name");
		query.setParameter("name", "%" + search + "%");
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		users.forEach(user->{
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setName(user.getFirst_name() + " " + user.getLast_name());
			userDTO.setEmail(user.getEmail());
			userDTO.setDeleted_at(user.getDeleted_at());
			userDTO.setOwner(user.getOwner()==1?true:false);
			usersDTO.add(userDTO);
		});
		return usersDTO;
	}
	
	
}
