package com.codebetter.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codebetter.entities.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, String>{

	public List<SubCategory> findByCategoryId(String id);
//	public void deleteByCategoryId(int id);
	public Optional findById(String id);
	public void deleteById(String id);
	
	@Modifying
	@Query("DELETE FROM SubCategory s WHERE s.category.id = :categoryId")
	void deleteByCategoryId(@Param("categoryId") String categoryId);

	
}
