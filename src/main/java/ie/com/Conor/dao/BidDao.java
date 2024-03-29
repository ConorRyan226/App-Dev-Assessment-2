package ie.com.Conor.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.com.Conor.entities.Bid;
import ie.com.Conor.entities.UserDetails;


public interface BidDao extends JpaRepository<Bid, Integer>{


	/*List<Bid> findByUserDetails_userId(int userId);
	List<Bid> findByUserDetails_FirstName(String firstName);
	List<Bid> findByUserDetails_LastName(String LastName);
	List<Bid> findByUserDetails_Email(String Email);*/
	
	
	
	List<Bid> findByJob_JobTitle(String jobTitle);
	List<Bid> findByJob_JobId(int jobId);		
	List<Bid> findAllByOrderByBidId();	
	boolean existsByBidId(int bidId);
	
		
	
}
	