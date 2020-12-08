
package com.app.monolightdemo.repository;


import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.monolightdemo.entity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository< Organization, Integer >{

	
	 public Page<Organization> findByNameContainingOrderByName(String name, Pageable pageable);
	 
	 public Optional<Organization> findById(Integer id);
	 
	 @Transactional
	 @Modifying
	 @Query(value ="update organizations  set address=:address, city=:city, "
	 			 + "country=:country , email=:email , name=:name , phone=:phone, "
	 			 + "postal_code=:postal_code , region=:region  , updated_at=:update_date WHERE id =:id ", nativeQuery=true)
	 public void updateOrganization(@Param("id") Integer id, @Param("address") String address, @Param("city") String city,
			 				 @Param("country") String country, @Param("email") String email, @Param("name") String name,
			 				 @Param("phone") String phone, @Param("postal_code") String postal_code, @Param("region") String region,
			 				 @Param("update_date") Date update_date);
	 
	 @Transactional
	 @Modifying
	 @Query(value=" update organizations set deleted_at=:date where id=:id", nativeQuery=true)
	 public void deleteOrganization(@Param("id") Integer id, @Param("date") Date deleted_date);
	 
	 @Transactional
	 @Modifying
	 @Query(value=" update organizations set deleted_at=NULL where id=:id", nativeQuery=true)
	 public void restoreOrganization(@Param("id") Integer id);

}
