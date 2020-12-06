
package com.app.monolightdemo.repository;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.app.monolightdemo.entity.Organization;
@Transactional
public interface OrganizationRepository extends JpaRepository< Organization, Integer >{

	
	 Page<Organization> findByNameContainingOrderByName(String name, Pageable pageable);
	 Optional<Organization> findById(Integer id);
}
