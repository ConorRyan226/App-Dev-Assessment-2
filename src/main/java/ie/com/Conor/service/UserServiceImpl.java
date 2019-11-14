package ie.com.Conor.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ie.com.Conor.dao.UserDao;
import ie.com.Conor.entities.UserDetails;

@Service
public class UserServiceImpl {
	
	@Autowired
	UserDao userDao;
		

	public List<UserDetails> getUserDetails() {
		return userDao.findAll();

		}	
	public String findUserById(int id) {
		if (userDao.existsById(id))
			return userDao.findNameById(id);
		return null;
	}
	
	public UserDetails save(UserDetails userDetails) {
		if (userDao.existsByUserName(userDetails.getFirstName()))
			return null;
		return userDao.save(userDetails);	
	}


	}