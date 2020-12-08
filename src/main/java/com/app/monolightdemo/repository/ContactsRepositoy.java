package com.app.monolightdemo.repository;

import java.util.Map;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.monolightdemo.entity.Contacts;

@Repository
public interface ContactsRepositoy extends JpaRepository<Contacts, Integer> {

	@Query(value ="select c.id as id, concat(c.first_name,' ', c.last_name) as name, c.phone as phone, "
				+ "c.city as city, c.deleted_at as deleted_at  "
				+ " from Contacts c left join Organization o on c.organization_id = o.id "
				+ " where c.first_name like :first_name and c.last_name like :last_name")
	public Page<Map<String, Object>> findByNameAndSurname(@Param("first_name") String first_name,@Param("last_name") String last_name, Pageable pageable);
}
