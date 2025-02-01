package org.jsp.zomato.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.jsp.zomato.dao.UserDao;
import org.jsp.zomato.dto.UserLogin;
import org.jsp.zomato.entity.User;
import org.jsp.zomato.exceptionclasses.DuplicateEmailException;
import org.jsp.zomato.exceptionclasses.InvalidCredentialException;
import org.jsp.zomato.exceptionclasses.InvalidUserIdException;
import org.jsp.zomato.responsestructure.ResponseStructure;
import org.jsp.zomato.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired 
	private UserDao dao;  

	@Override
	public ResponseEntity<?> saveUser(User user) {
		
		Optional<User> optional=dao.findUserByEmail(user.getEmail());
		if(optional.isPresent())
			throw DuplicateEmailException.builder().message("Email is already registeres unable to create the Account...").build();
		
		user=dao.saveUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User Saved Successfully").body(user).build());
	}

	@Override
	public ResponseEntity<?> findAllUsers() {
		List<User> users=dao.findAllUsers();
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("All Users are Founded Successfully").body(users).build());
	}

	@Override
	public ResponseEntity<?> findUserById(int id) {
		
		Optional<User> optional=dao.findUserById(id);
		if(optional.isEmpty())
			throw InvalidUserIdException.builder().message("Invalid User Id Unable to found the User..").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User Founded Successfully..").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> deleteUserById(int id) {
		
		Optional<User> optional=dao.findUserById(id);
		if(optional.isEmpty())
			throw InvalidUserIdException.builder().message("Invalid User Id Unable to found the User..").build();
		dao.deleteUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User Founded Successfully..").body("User Deleted Successfully..").build());
	}

	public ResponseEntity<?> updateLastLogin(int id) {
		Optional<User> optional=dao.findUserById(id);
		if(optional.isEmpty())
			throw InvalidUserIdException.builder().message("Invalid User Id Unable to Update Last Login Time...").build();
		User user=optional.get();
		user.setLastLogin(LocalDateTime.now());
		user=dao.saveUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Last Login is Updated Successfully...").body(user).build());
	}

	@Override
	public ResponseEntity<?> findUserByEmailAndPassword(UserLogin login) {
		
		String e=login.getEmail();
		
		char ch=e.charAt(0);  
		Optional<User> optional=null;
		if(e.length()==10 && (ch>='6' && ch<='9')) {
			boolean flag=true;
			for(int i=0;i<e.length();i++) {
				if(!(e.charAt(i)>='0' && e.charAt(i)<='9')) {
					flag=false;
				}
			}
			if(flag) {     
				optional=dao.findUserByPhoneAndPassword(Long.parseLong(login.getEmail()),login.getPassword());
			}
		}         
		else {
			optional=dao.findUserByEmailAndPassword(login.getEmail(),login.getPassword()); 

		}        
		if(optional.isEmpty())
			throw InvalidCredentialException.builder().message("Invalid Credentials").build();
		User user=optional.get();
		user.setLastLogin(LocalDateTime.now());
		user=dao.saveUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("last login updated successfully by email and password").body(user).build());
	}

	
}
