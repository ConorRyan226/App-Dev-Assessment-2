package ie.com.Conor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ie.com.Conor.entities.UserDetails;

public interface UserDao extends JpaRepository<UserDetails, Integer>{
	
	 @Query("SELECT c.firstName FROM UserDetails c where c.id = :id") 
	 String findNameById(@Param("id") int id);
// just a test
	//boolean existsByUserName(String name);
}