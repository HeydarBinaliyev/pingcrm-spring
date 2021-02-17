package com.app.monolightdemo.repository;





import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.monolightdemo.entity.Contacts;

@Repository
public interface ContactsRepositoy extends JpaRepository<Contacts, Integer> {

	@Query(value =" from Contacts c where c.first_name like :first_name and c.last_name like :last_name")
	public Page<Contacts> findByNameAndSurname(@Param("first_name") String first_name,@Param("last_name") String last_name, Pageable pageable);
	
	@Query(value =" from Contacts c where c.first_name like :first_name and c.last_name like :last_name and c.deleted_at!=null")
	public Page<Contacts> findByNameAndSurnameAndOnlyTrashed(@Param("first_name") String first_name,@Param("last_name") String last_name, Pageable pageable);

}
