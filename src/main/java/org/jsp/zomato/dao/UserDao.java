package org.jsp.zomato.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.zomato.entity.User;

public interface UserDao {

	User saveUser(User user);

	List<User> findAllUsers();

	Optional<User> findUserByEmail(String email);

	Optional<User> findUserById(int id);

	void deleteUserById(int id);

	Optional<User> findUserByEmailAndPassword(String email, String password);

	Optional<User> findUserByPhoneAndPassword(long phone, String password);

}
