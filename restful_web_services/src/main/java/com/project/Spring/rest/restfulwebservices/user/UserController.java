package com.project.Spring.rest.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
	  List<User> users= service.findAll();
		return users;
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id){
	  User user= service.findUser(id);
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user){
	 
	User savedUser= service.saveUser(user);	
	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
	
	return ResponseEntity.created(location).build();
	}
	
}
