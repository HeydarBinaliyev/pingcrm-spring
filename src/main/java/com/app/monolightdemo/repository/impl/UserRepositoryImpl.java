package com.app.monolightdemo.repository.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.app.monolightdemo.dto.AuthorityDTO;
import com.app.monolightdemo.dto.MenuDTO;
import com.app.monolightdemo.dto.UserDTO;
import com.app.monolightdemo.entity.Authority;
import com.app.monolightdemo.entity.AuthorityType;
import com.app.monolightdemo.entity.User;
import com.app.monolightdemo.exception.GeneralException;
import com.app.monolightdemo.repository.UserRepository;





@Repository
@Transactional
public class UserRepositoryImpl  implements UserRepository{

	@Autowired
	EntityManager em;
	
	
	@Override
	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("FROM User u where u.name=:username");
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
	public UserDTO getUserDTOByUserName(String userName) throws Exception {

		Query query = em.createQuery("FROM User u where u.name=:username");
		query.setParameter("username", userName);
		User user =null;
		try{
			user = (User) query.getSingleResult();
		}
		catch (NonUniqueResultException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new GeneralException("error.entity.101");
		}
		catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new GeneralException("error.entity.102");
		}
		UserDTO userDTO = new UserDTO();
		List<AuthorityDTO> authoritiesDTO = new ArrayList<AuthorityDTO>();
		user.getAuhtorities().forEach(authority->{
			AuthorityDTO authorityDTO = new AuthorityDTO();
			authorityDTO.setId(authority.getId());
			authorityDTO.setName(authority.getName().toString());
			List<MenuDTO> menusDTO = new ArrayList<MenuDTO>();
			authority.getAuthorityMenuList().forEach(menu->{
				MenuDTO menuDTO = new MenuDTO();
				menuDTO.setName(menu.getMenu().getName());
				menuDTO.setUrl(menu.getMenu().getUrl());
				menusDTO.add(menuDTO);
			});
			authorityDTO.setMenus(menusDTO);
			authoritiesDTO.add(authorityDTO);
		});
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setEmail(user.getEmail());
		userDTO.setAuthorities(authoritiesDTO);
		
		return userDTO;
	}
	
	@Override
	public User createuser(UserDTO userDTO) throws Exception {
		// TODO Auto-generated method stub
		Query query = em.createQuery("FROM User u where u.name=:username");
		query.setParameter("username", userDTO.getName());
		try {
			User user = (User) query.getSingleResult();
			if(user != null)
				throw new GeneralException("error.register.101");
		}catch (NoResultException e) {
			// TODO: handle exception
			
		}
		User newUser = new User();
		newUser.setName(userDTO.getName());
		newUser.setEmail(userDTO.getEmail());
		newUser.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
		em.persist(newUser);
		em.flush();
		return newUser;
	}
	@Override
	public List<UserDTO> getAllUsers(Integer max,Integer offset,String userName) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from User where name like :name");
		query.setParameter("name", "%" + userName + "%");
		query.setMaxResults(max);
		query.setFirstResult(offset);
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		users.forEach(user->{
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setEmail(user.getEmail());
			usersDTO.add(userDTO);
		});
		return usersDTO;
	}
	@Override
	public Integer getAllUsersCount(String userName) {
		// TODO Auto-generated method stub.
		Query query = em.createQuery("from User where name like :name");
		query.setParameter("name", "%" + userName + "%");
		Integer count = query.getResultList().size();
		return count;
	}
	
	@Override
	public void updateUser(UserDTO userDTO) throws GeneralException {
		// TODO Auto-generated method stub
		
		User user =null;
		try{
			user = em.find(User.class, userDTO.getId());
		}
		catch (NonUniqueResultException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new GeneralException("error.entity.101");
		}
		catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new GeneralException("error.entity.102");
		}
		user.setName(userDTO.getName());
		Set<Authority> newAuthorities = new HashSet<Authority>();
		for (AuthorityDTO authorityDTO : userDTO.getAuthorities()) {
			Authority authority = new Authority();
			authority.setId(authorityDTO.getId());
			authority.setName(AuthorityType.valueOf(authorityDTO.getName()));
			authority.setAuthorityMenuList(null);
			newAuthorities.add(authority);
		}
		user.setAuhtorities(newAuthorities);
		em.merge(user);
		em.flush();
		
	}
	
	@Override
	public void deleteUser(Long id) throws GeneralException {
		// TODO Auto-generated method stub
		User user =null;
		try{
			user = em.find(User.class, id);
		}
		catch (NonUniqueResultException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new GeneralException("error.entity.101");
		}
		catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new GeneralException("error.entity.102");
		}
		em.remove(user);
		em.flush();
	}
}