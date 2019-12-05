package ie.com.Conor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.com.Conor.dao.BidDao;
import ie.com.Conor.entities.Bid;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BidServiceImpl implements BidService{
	
	@Autowired
	BidDao bidDao;
	
	@Override
	public List<Bid> findAllByOrderByBidId() {
		return bidDao.findAllByOrderByBidId();
	}
	
	@Override
	public List<Bid> findBidsByJobId(int jobId) {
		return bidDao.findByJob_JobId(jobId);
	}

	@Override
	public Bid findBid(int bidId) {

		if(bidDao.existsById(bidId))
			return bidDao.findById(bidId).get();
		return null;
	}

	@Override
	public Bid save(Bid bid) {
		
		log.info(bid.toString());
	//	bidDao.existsByBidId(bid.getBidId());
		return bidDao.save(bid);
	}

}
