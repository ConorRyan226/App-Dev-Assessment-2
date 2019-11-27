package ie.com.Conor.service;

import java.util.List;

import ie.com.Conor.entities.Bid;

public interface BidService {
	
	
	List<Bid> findBidsByJobId(int jobId);
	List<Bid> findAllByOrderByBidId();
	Bid findBid(int bidId);
	Bid save(Bid bid);
}
