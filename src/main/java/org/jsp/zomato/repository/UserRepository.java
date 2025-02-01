package org.jsp.zomato.repository;

import java.util.Optional;

import org.jsp.zomato.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String email);

	Optional<User> findById(int id);

	Optional<User> findByEmailAndPassword(String email, String password);

	Optional<User> findByPhoneAndPassword(long email, String password);

}
