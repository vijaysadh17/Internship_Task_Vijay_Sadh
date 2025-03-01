package com.codebetter.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codebetter.entities.Business;
import com.codebetter.entities.Category;
import com.codebetter.entities.Service;
import com.codebetter.entities.SubCategory;
import com.codebetter.entities.User;
import com.codebetter.services.BusinessService;
import com.codebetter.services.CategoryService;
import com.codebetter.services.ServiceBL;
import com.codebetter.services.SubCategoryService;
import com.codebetter.services.UserService;


@RestController
@RequestMapping("api")
public class MainController {
	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService catService;
	@Autowired
	private SubCategoryService subService;

	@Autowired
	private BusinessService businessService;
	
	@Autowired
	private ServiceBL service;

	// Register API

	@PostMapping("register")
	public ResponseEntity<User> Register(@RequestBody User u) {

		boolean b = userService.addUser(u);
		if (b == true) {
			return ResponseEntity.status(HttpStatus.CREATED).body(u);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
//========================================================================
	// Login API

	@Validated
	@PostMapping("login")
	public ResponseEntity<String> Login(@RequestBody User u) {

		boolean b = userService.getUser(u);
		if (b == true) {
			return ResponseEntity.status(HttpStatus.OK).body("User Logged In Successfully..");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user...");
		}
	}
//=============================================================================================
	// Category API

	// API For Get Category
//	ADD CATEGORY

	@PostMapping("categories")
	public ResponseEntity<String> addCategory(@RequestBody Category category) {
		try {
			Category c = catService.addCategory(category);
		} catch (Exception e) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("Category added Successfully");
	}

	@PostMapping("categories1")

	public ResponseEntity<String> addAllProduct(@RequestBody List<Category> category) {
		if (category != null) {
			catService.addAllCategory(category);
			return ResponseEntity.status(HttpStatus.CREATED).body("Category added Successfully");
		} else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

//=================================================================================================

	// READ CATEGORY

	@GetMapping("categories")
	public List<Category> getAllCategory() {

		List<Category> list = catService.ShowAllCategory();
		return list;
	}

	@GetMapping("categories/{id}")
	public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable String id) {
		if (id != null) {
			Optional<Category> list = catService.ShowCategoryById(id);
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@GetMapping("categories/{name}")
	public ResponseEntity<List<Category>> getCategoryByName(@PathVariable String name) {
		if (name != null) {
			List<Category> list = catService.ShowCategoryByName(name);
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

//	=============================================================================================================

//	Update Category

//	API FOR CATEGORY

	@PutMapping("categories")
	public ResponseEntity<Category> UpdateProduct(@RequestBody Category category) {
		if (category != null) {
			catService.updateCategory(category);
			return ResponseEntity.status(HttpStatus.OK).body(category);

		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@PutMapping("categories/{id}")
	public ResponseEntity<Category> UpdatebyId(@RequestBody Category c, @PathVariable String id) {
		if (c != null) {
			catService.updateCategoryById(c, id);
			return ResponseEntity.status(HttpStatus.OK).body(c);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

//	===================================================================================================================

	// Delete Category

	@DeleteMapping("categories")
	public ResponseEntity<Category> DeleteCategory(@RequestBody Category category) {
		if (category != null) {
			catService.deleteCategory(category);
			return ResponseEntity.status(HttpStatus.OK).build();

		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@DeleteMapping("categories1/{id}")
	public ResponseEntity<Category> DeleteCategoryById(@RequestBody Category category, @PathVariable String id) {
		if (category != null) {
			catService.deleteCategoryById(category, id);
			return ResponseEntity.status(HttpStatus.OK).build();

		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

//	=================================================================================

	// API for Sub-Category

	@PostMapping("subcategories")
	public ResponseEntity<List<SubCategory>> addMulSubCategory(@RequestBody List<SubCategory> sc) {

		if (sc != null) {
			List<SubCategory> list = subService.addSubCategory(sc);
			return ResponseEntity.status(HttpStatus.CREATED).body(list);

		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	// post man input for add subcategory
//	[
//
//	{
//	    "subcategoryName": "Electronics",
//	    "category": {
//	        "id": 1
//	    }
//	}
//	]

	@PostMapping("categories/{id}/subcategories")
	public ResponseEntity<SubCategory> getSubcategory(@RequestBody SubCategory sc, @PathVariable String id)

	{

		if (sc != null) {
			SubCategory s = subService.addSubcategoryById(sc, id);
			return ResponseEntity.status(HttpStatus.CREATED).body(sc);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

//	==================================================================================================
	// GET API FOR SUB CATEGORY

	@GetMapping("categories/{id}/subcategories")
	public ResponseEntity<List<SubCategory>> getSubcategoryByCategory(@PathVariable String id) {
		List<SubCategory> ls = subService.getSubcategoryByCategory(id);
		if (!ls.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(ls);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// ===============================================================================================================

	// Put API FOR Update Sub-Category

	@PutMapping("subcategories/{id}")
	public ResponseEntity<SubCategory> UpdateBySubCategoryId(@RequestBody SubCategory sc, @PathVariable String id) {
		if (sc != null && id != null) {
			subService.UpdateBySubCategoryId(id, sc);
			return ResponseEntity.status(HttpStatus.OK).body(sc);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// =================================================================================================

	@DeleteMapping("subcategories/{id}")
	public ResponseEntity<String> deleteSubcategoryById(@PathVariable String categoryId) {
		try {
			subService.deleteSubcategoryById(categoryId);
			return ResponseEntity.status(HttpStatus.OK).body("SubCategory deleted successfully.");
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

//	===================================================================================================

	// USER API

	// GET API

	@GetMapping("users")
	public ResponseEntity<List<User>> getAllUsers() {

		List<User> list = userService.ShowAllUsers();
		return ResponseEntity.ok(list);
	}

	@GetMapping("users/{id}")
	public ResponseEntity<Optional<User>> getUsersById(@PathVariable String id) {
		if (id != null) {
			Optional<User> ls = userService.ShowUserById(id);
			return ResponseEntity.status(HttpStatus.OK).body(ls);

		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

//=====================================================================================================	

	// POST MAPPING

	@PostMapping("users")
	public ResponseEntity<User> addUser(@RequestBody User u) {
		userService.addUser(u);

		return ResponseEntity.status(HttpStatus.OK).build();
	}

	// ====================================================================================================================

	// PUT MAPPING

	@PutMapping("users/{id}")
	public ResponseEntity<User> UpdateById(@RequestBody User u, @PathVariable String id) {
		if (u != null && id != null) {
			userService.UpdateById(u, id);
			return ResponseEntity.status(HttpStatus.OK).body(u);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

//	====================================================================================================================

//DELETE MAPPING

	@DeleteMapping("users/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable String id) {
		if (id != null) {
			userService.UserDeleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

//	====================================================================================================================	

	// APIS FOR Businesses

	// POST MAPPING
//	===============

	@PostMapping("business/register")
	public ResponseEntity<Business> addBusiness(@RequestBody Business b) {
		businessService.addBusiness(b);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	// Json Input
//	{
//		  "name": "New Business",
//		  "address":"indore",
//		  "mobile":"1234567890",
//		  "logo":"xyz",
//		  "userId":
//		  {
//		  "id": "4ae0f8aa-3c46-4f68-b7f7-d2c993a15420"
//		  }
//		}

//	======================================================================================
	@GetMapping("business/{id}")
	public ResponseEntity<Optional<Business>> getBusinessById(@PathVariable String id) {
		if (id != null) {
			Optional<Business> op = businessService.getBusinessById(id);
			return ResponseEntity.status(HttpStatus.OK).body(op);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

//=================================================================================
	// put api for Business

	@PutMapping("business/{id}")
	public ResponseEntity<Business> updateBusinessById(@RequestBody Business b, @PathVariable String id) {
		if (id != null) {
			businessService.updateBusinessById(b, id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}
	// ================================================================================
	// Delete Api for Business

	@DeleteMapping("business/{id}")
	public ResponseEntity<Business> deleteBusinessById(@RequestBody Business b, @PathVariable String id) {
		if (id != null) {
			businessService.deleteBusinessById(b, id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

//=========================================================================================	

	//API for SERVICES
	
//	post mapping for service
	
	@PostMapping("services")
	public ResponseEntity<Service> addService(@RequestBody Service s) {
		service.addService(s);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
	
}
