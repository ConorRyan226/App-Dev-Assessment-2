package ie.com.Conor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ie.com.Conor.entities.UserDetails;

public interface UserDao extends JpaRepository<UserDetails, Integer>{
	
   	 boolean existsById(Integer id); 
   	 boolean existsByEmail(String email);
   	 
	 @Query("SELECT c.firstName FROM UserDetails c where c.id = :id")
	 String findNameById(@Param("id") int id);
	 boolean existsByFirstName(String name);//delete 
	 
	 
	 @Query("SELECT c.firstName FROM UserDetails c where c.email = :email")
	 String findNameofUserByEmail(@Param("email") String email);
	
}