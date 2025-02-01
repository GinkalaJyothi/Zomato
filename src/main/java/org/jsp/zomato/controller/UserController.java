package org.jsp.zomato.controller;

import org.jsp.zomato.dto.UserLogin;
import org.jsp.zomato.entity.User;
import org.jsp.zomato.responsestructure.ResponseStructure;
import org.jsp.zomato.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user){
		return service.saveUser(user);  
		
	}
	@GetMapping
	public ResponseEntity<?> findAllUsers(){
		return service.findAllUsers();  
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> findUserById(@PathVariable int id){
		return service.findUserById(id);  
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable int id){
		return service.deleteUserById(id);  
	}
	@PatchMapping("/{id}/updateLastLogin")
	public ResponseEntity<?> updateLastLogin(@PathVariable int id){
		return service.updateLastLogin(id); 
	}
	@PostMapping("/login")
	public ResponseEntity<?> findUserByEmailAndPassword(@RequestBody UserLogin login){
		return service.findUserByEmailAndPassword(login);  
	}
	

}
