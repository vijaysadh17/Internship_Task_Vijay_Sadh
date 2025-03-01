package com.codebetter.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codebetter.entities.User;

public interface UserRepository  extends JpaRepository<User,String>{

	public List<User> findByEmailAndPassword(String email,String password);

//	public Optional findById( String id);
	public Optional findById( String id);
}
