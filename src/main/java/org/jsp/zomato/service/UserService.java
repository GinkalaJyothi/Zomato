package org.jsp.zomato.service;

import org.jsp.zomato.dto.UserLogin;
import org.jsp.zomato.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

	ResponseEntity<?> saveUser(User user);

	ResponseEntity<?> findAllUsers();

	ResponseEntity<?> findUserById(int id);

	ResponseEntity<?> deleteUserById(int id);

	ResponseEntity<?> updateLastLogin(int id);

	ResponseEntity<?> findUserByEmailAndPassword(UserLogin login);

	

}
