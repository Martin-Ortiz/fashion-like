package com.fashionlike.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashionlike.entity.Password;

@Repository
public interface PasswordRepository extends JpaRepository<Password, String> {
	
	int deleteByIdPassword(String idPassword);
}
