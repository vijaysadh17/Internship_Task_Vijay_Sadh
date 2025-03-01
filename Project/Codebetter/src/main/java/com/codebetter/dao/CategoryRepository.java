package com.codebetter.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codebetter.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,String>{

	
	public List<Category> findByCategoryName(String categoryName);
	public void deleteById(String id);
//	public List<Category> findByCategoryId(int id);

//	public Optional<Category> findById(String id);
}
