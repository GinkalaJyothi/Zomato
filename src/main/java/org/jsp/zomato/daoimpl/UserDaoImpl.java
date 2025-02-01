package org.jsp.zomato.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.zomato.dao.UserDao;
import org.jsp.zomato.entity.User;
import org.jsp.zomato.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private UserRepository repository;

	@Override
	public User saveUser(User user) {
		
		return repository.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		
		return repository.findAll();
	}

	@Override
	public Optional<User> findUserByEmail(String email) {
		
		return repository.findByEmail(email);
	}

	@Override
	public Optional<User> findUserById(int id) {
		
		return repository.findById(id);  
	}

	@Override
	public void deleteUserById(int id) {
		
		repository.deleteById(id);
	}

	@Override
	public Optional<User> findUserByEmailAndPassword(String email, String password) {
		
		return repository.findByEmailAndPassword(email,password);  
	}

	@Override
	public Optional<User> findUserByPhoneAndPassword(long phone, String password) {
		
		return repository.findByPhoneAndPassword(phone,password);
	}

}
