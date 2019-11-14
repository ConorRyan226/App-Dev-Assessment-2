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

	}