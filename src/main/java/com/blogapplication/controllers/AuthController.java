package com.blogapplication.controllers;

import java.security.Principal;

import com.blogapplication.payloads.JwtAuthRequest;
import com.blogapplication.repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blogapplication.entities.User;
import com.blogapplication.services.UserService;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

//	@Autowired
//	private JwtTokenHelper jwtTokenHelper;

	@Autowired
	private UserService userService;
	@Autowired
	private ModelMapper modelMapper;
	//register new user
	@Autowired
	private UserRepo userRepo;
	//Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@PostMapping("/registerUser")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		
		User registeredUser = this.userService.registerNewUser(user);
	//	logger.info(user.getEmail());
		return new ResponseEntity<User>(registeredUser, HttpStatus.CREATED);
		
	}
	@PostMapping("/login")
	public ResponseEntity<?> createToken(@RequestBody JwtAuthRequest request)  {
		System.out.println(request.getUsername());
		String email = request.getUsername();
		User isPresent = this.userRepo.findByEmail(email).get();
		System.out.println(isPresent.getPassword()+ " "+request.getUsername());
		if(isPresent.getPassword().equals(request.getPassword())){
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		return new ResponseEntity<String>("failed",HttpStatus.OK);
	}
}
