package com.codebetter.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codebetter.dao.CategoryRepository;
import com.codebetter.entities.Category;

@Component
public class CategoryService {

	@Autowired
	private CategoryRepository cr;

	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		Category cat = cr.save(category);
		return cat;
	}

	public List<Category> ShowAllCategory() {

		List<Category> list = cr.findAll();
		return list;
	}

	public void addAllCategory(List<Category> category) {
		// TODO Auto-generated method stub
		cr.saveAll(category);
	}

	public List<Category> ShowCategoryByName(String name) {
		// TODO Auto-generated method stub
		List<Category> ls = cr.findByCategoryName(name);
		return ls;
	}

	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		Optional<Category> op = cr.findById(category.getId());
		if (op.isPresent()) {
			Category c = op.get();
			c.setCategoryName(c.getCategoryName());
			cr.save(c);
		}
	}

	public void updateCategoryById(Category c,String id) {
		 Optional<Category> op = cr.findById(id);
		if(op.isPresent())
		{
			Category c1 = op.get();
			c1.setCategoryName(c.getCategoryName());
			cr.save(c1);
			
		}
	}

	public void deleteCategory(Category category) {
		// TODO Auto-generated method stub
		cr.delete(category);
		}

	public Optional<Category> ShowCategoryById(String id) {
		Optional<Category> ls = cr.findById(id);
		return ls;
		
	}

	public void deleteCategoryById(Category category, String id) {
		// TODO Auto-generated method stub
		cr.deleteById(id);
	}
 
		
	}
	
	

