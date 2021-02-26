package com.app.monolightdemo.repository.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.app.monolightdemo.dto.UserDTO;
import com.app.monolightdemo.entity.User;
import com.app.monolightdemo.repository.UserRepository;





@Repository
@Transactional
public class UserRepositoryImpl  implements UserRepository{

	@Autowired
	EntityManager em;
	
	@Override
	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("FROM User u where u.email=:username");
		query.setParameter("username", userName);
		User user = null;
		try {
			 user = (User) query.getSingleResult();
			
		}catch (NoResultException e) {
			// TODO: handle exception
			return null;
		}
		return user;
	}
	
	@Override
	public User getUserById(Integer id) {
		Query query = em.createQuery("FROM User u where u.id=:id");
		query.setParameter("id", id);
		User user = null;
		try {
			 user = (User) query.getSingleResult();
			
		}catch (NoResultException e) {
			// TODO: handle exception
			return null;
		}
		return user;
	}
	
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
	
	@Override
	public void saveUser(User user) {
		em.persist(user);
		em.flush();
	}

	@Override
	public void mergeUser(User user) {
		em.merge(user);
		em.flush();
	}
	
}
