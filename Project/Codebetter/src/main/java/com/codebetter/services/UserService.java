package com.codebetter.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codebetter.dao.UserRepository;
import com.codebetter.entities.Category;
import com.codebetter.entities.User;

@Component
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public boolean addUser(User u) {

		boolean b = false;
		if (u != null) {
			userRepository.save(u);
			b = true;
		}
		return b;

	}

	public boolean getUser(User u) {
		// TODO Auto-generated method stub
		boolean b = false;
		List<User> ls = userRepository.findByEmailAndPassword(u.getEmail(), u.getPassword());
		if (ls.size() != 0) {
			b = true;
		}
		return b;
	}

	// Show All users
	public List<User> ShowAllUsers() {
		// TODO Auto-generated method stub

		List<User> ls = null;
		List<User> list = userRepository.findAll();
		return list;
	}

	public Optional<User> ShowUserById(String id) {
		// TODO Auto-generated method stub
		Optional<User> ls = userRepository.findById(id);
		return ls;

	}
//
//	public void UpdateById(User u, String id) {
//		// TODO Auto-generated method stub
//		List<User> ls = (List<User>) userRepository.findById(id);
//		System.out.println(id);
//		if (ls.size() != 0) {
//			User user = ls.get(0);
//			user.setName(u.getName());
//			user.setMobile(u.getMobile());
//			user.setEmail(u.getEmail());
//			user.setRole(u.getRole());
//			user.setPassword(u.getPassword());
//			userRepository.save(user);
//		} else {
//			throw new RuntimeException("User with ID " + id + " not found.");
//		}

	public void UpdateById(User u, String id) {
		// TODO Auto-generated method stub
		Optional<User> ls = userRepository.findById(id);
		if (ls.isPresent()) {
			User user = ls.get();
			user.setName(u.getName());
			user.setEmail(u.getEmail());
			user.setMobile(u.getMobile());
			user.setPassword(u.getPassword());
			user.setRole(u.getRole());
			userRepository.save(user);
		}
	}

	public void UserDeleteById(String id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		
	}
}
