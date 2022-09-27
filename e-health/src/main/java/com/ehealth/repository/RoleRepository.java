package com.ehealth.repository;

import java.util.Optional;

import com.ehealth.entity.ERole;
import com.ehealth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(ERole name);
}
