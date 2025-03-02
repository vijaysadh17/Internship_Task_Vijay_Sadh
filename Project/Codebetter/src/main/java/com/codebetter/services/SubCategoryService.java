package com.codebetter.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codebetter.dao.CategoryRepository;
import com.codebetter.dao.SubCategoryRepository;
import com.codebetter.entities.Category;
import com.codebetter.entities.SubCategory;

@Component
public class SubCategoryService {

	@Autowired
	private SubCategoryRepository sr;
	@Autowired
	private CategoryRepository cr;

	public List<SubCategory> addSubCategory(List<SubCategory> sc) {
		// TODO Auto-generated method stub
		List<SubCategory> ls = sr.saveAll(sc);
		return ls;
	}

	public SubCategory addSubcategoryById(SubCategory sc,String id) {

		Optional<Category> op = cr.findById(id);
		if (op.isPresent()) {
			sc.setCategory(op.get());
//			sr.save(sc);
			return sr.save(sc);
		} else {
			throw new RuntimeException("Category with ID " + id + " not found.");
		}

	}

	public List<SubCategory> getSubcategoryByCategory(String id) {
		// TODO Auto-generated method stub
		List<SubCategory> ls = sr.findByCategoryId(id);
		return ls;
	}

	public void UpdateBySubCategoryId(String id, SubCategory sc) {
		// TODO Auto-generated method stub
		Optional<SubCategory> op = sr.findById(id);
		if (op.isPresent()) {
			SubCategory s = op.get();
			s.setSubcategoryName(s.getSubcategoryName());
			sr.save(s);
		}

	}

	public void deleteSubcategoryById(String id) {
		// TODO Auto-generated method stub

		cr.deleteById(id);

	}

	public void deleteCategoryById(String categoryId) {
		// First, delete all associated subcategories
		sr.deleteByCategoryId(categoryId); // Custom method to delete subcategories

		// Now delete the category
		cr.deleteById(categoryId);
	}

}
