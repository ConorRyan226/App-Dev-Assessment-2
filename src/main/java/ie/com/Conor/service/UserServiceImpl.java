package ie.com.Conor.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.com.Conor.dao.UserDao;
import ie.com.Conor.entities.UserDetails;

@Service
public class UserServiceImpl implements UserService {
	
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
		if (userDao.existsByFirstName(userDetails.getEmail()))
			return null;
		return userDao.save(userDetails);	
	}
	
	@Override
	public UserDetails findById(int id) {
		// TODO Auto-generated method stub
		return userDao.findById(id).get();
	}
	
	@Override
	public String findNameofUserByEmail(String email) {
		// TODO Auto-generated method stub
	if (userDao.existsByEmail(email))
		return userDao.findNameofUserByEmail(email);
		return null;
	}
	
	@Override
	public UserDetails findUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<UserDetails> listFirstNameInAlphabeticalOrder() {
		return userDao.findAllByOrderByFirstNameAsc();
	}
	@Override
	public UserDetails findByFirstName(String userFirstName) {
		// TODO Auto-generated method stub
		return null;
	}
}