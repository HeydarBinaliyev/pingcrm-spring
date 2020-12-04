
package com.app.monolightdemo.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.app.monolightdemo.entity.Organization;

public interface OrganizationRepository extends JpaRepository< Organization, Integer >{

	 Page<Organization> findByNameContaining(String name, Pageable pageable);
}
