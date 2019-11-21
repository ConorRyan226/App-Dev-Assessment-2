package ie.com.Conor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ie.com.Conor.entities.Job;
import ie.com.Conor.entities.UserDetails;

public interface JobDao extends JpaRepository<Job, Integer>{
	
  	 boolean existsById(Integer id);
   	 
	 @Query("SELECT c.jobTitle FROM Job c where c.id = :id")
	 String findNameById(@Param("id") int id);

}
