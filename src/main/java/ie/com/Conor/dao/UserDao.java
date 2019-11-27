package ie.com.Conor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ie.com.Conor.entities.UserDetails;

public interface UserDao extends JpaRepository<UserDetails, Integer>{
	
   	 boolean existsById(Integer id); 
   	 boolean existsByEmail(String email);
   	 
   	UserDetails findByFirstName(String firstName);
	boolean existsByFirstName(String x);
	
   	 
   	List<UserDetails> findAllByOrderByFirstNameAsc();
	@Query("SELECT u.firstName FROM UserDetails u where u.id = :id") 
	String findFirstNameOfUserById(@Param("id") int id);
   	 
	 @Query("SELECT c.firstName FROM UserDetails c where c.id = :id")
	 String findNameById(@Param("id") int id);
	 
	 
	 @Query("SELECT c.firstName FROM UserDetails c where c.email = :email")
	 String findNameofUserByEmail(@Param("email") String email);
	
}