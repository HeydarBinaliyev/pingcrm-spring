
package com.app.monolightdemo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.app.monolightdemo.entity.Organization;

public interface OrganizationRepository extends JpaRepository< Organization, Integer >{

	 Page<Organization> findByName(String name, Pageable pageable);
	 List<Organization> findByName(String name);
}
