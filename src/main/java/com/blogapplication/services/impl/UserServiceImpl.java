package com.blogapplication.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blogapplication.config.AppConstants;
import com.blogapplication.entities.Role;
import com.blogapplication.entities.User;
import com.blogapplication.payloads.UserResponse;
import com.blogapplication.repositories.RoleRepo;
import com.blogapplication.repositories.UserRepo;
import com.blogapplication.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	//Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RoleRepo roleRepo;


	@Override
	public User updateUser(User user, Integer userId) {

		User user1 = this.userRepo.findById(userId).get();
		user1.setName(user.getName());
		user1.setEmail(user.getEmail());
		user1.setPassword((user.getPassword()));
		user1.setAbout(user.getAbout());

		User updatedUser = this.userRepo.save(user1);
		return updatedUser;
	}

	@Override
	public User getUserById(Integer userId) {

		User user = this.userRepo.findById(userId).get();
	//	logger.info("Get User By Id implementation ");
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		 return this.userRepo.findAll();
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).get();
		this.userRepo.delete(user);

	}


	@Override
	public User registerNewUser(User user) {

		User user1 = new User();
		user1.setName(user.getName());
		user1.setAbout(user.getAbout());
		user1.setEmail(user.getEmail());

		// encoded the password
		user1.setPassword((user.getPassword()));

		// roles

		Role role = this.roleRepo.findById(AppConstants.ADMIN_USER).get();

		user1.getRoles().add(role);

		User newUser = this.userRepo.save(user1);
	//	logger.info("Register new User Implementation ");
		
		return newUser;
	}

}