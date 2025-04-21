package com.blogapplication.services;


import com.blogapplication.entities.User;
import com.blogapplication.payloads.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
	
	User registerNewUser(User user);

	User updateUser(User user, Integer userId);

	User getUserById(Integer userId);

	void deleteUser(Integer userId);


	List<User> getAllUsers();
	
}
