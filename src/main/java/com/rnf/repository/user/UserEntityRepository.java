package com.rnf.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rnf.entity.user.UserEntity;
 

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Integer>  {
	public Optional<UserEntity> findByUsername(String username);
	
	@Query("select u from UserEntity u where u.username = :username and u.password = :password")
	public Optional<UserEntity> findUserByCredentials(@Param("username") String username, @Param("password") String password);
	
	public boolean existsByUsername(String username);
	
  
}
