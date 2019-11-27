package ie.com.Conor.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.com.Conor.entities.Bid;
import ie.com.Conor.entities.UserDetails;


public interface BidDao extends JpaRepository<Bid, Integer>{

/*
	List<Bid> findByUserFirstName(String firstName);
	List<Bid> findByLastName(String lastName);
	List<Bid> findByUserEmail(String email);
	List<Bid> findByUserId(int id);
	
	List<Bid> findByJobName(String jobName);
	List<Bid> findByJobId(int jobId);
	*/
		
	List<Bid> findAllByOrderByBidId();
	
	boolean existsByBidIdAndUserBid_Id(int bidId, int id);

	List<Bid> findByJobId_jobId(int jobId);
	
		
	
}
	