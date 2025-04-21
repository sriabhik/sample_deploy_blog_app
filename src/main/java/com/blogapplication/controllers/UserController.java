package com.blogapplication.controllers;


import javax.validation.Valid;

import com.blogapplication.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.blogapplication.config.AppConstants;
import com.blogapplication.payloads.ApiResponse;
import com.blogapplication.payloads.UserResponse;
import com.blogapplication.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);


	@Autowired
	private UserService userService;
	
	//put update user
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user, @PathVariable("userId") Integer userId){
		User updatedUser = userService.updateUser(user,userId);
	//	logger.info("Update User");
		return new ResponseEntity<>(updatedUser,HttpStatus.OK);
	}
	//deleteMapping
	//ApiReponse in payload package is used to give message as response and used as global ,we can use again
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId){
	
	  this.userService.deleteUser(userId);
	  //logger.info("Delete User using userId");
	  return new ResponseEntity<ApiResponse>(HttpStatus.OK);
	  
	}
	
	
	//get user all user
	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>>  getAllUsers(){
		logger.info("Get all  User ");
		return new ResponseEntity<>(this.userService.getAllUsers(),HttpStatus.OK);
	}
	//get user -by id get user
	@GetMapping("/getUser/{userId}")
	public User getSingleUser(@PathVariable Integer userId){
		User user = this.userService.getUserById(userId);
		//logger.info("Get all User by userId ");
		return user;
	}
}
