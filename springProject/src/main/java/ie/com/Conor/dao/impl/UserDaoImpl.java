package ie.com.Conor.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import ie.com.Conor.dao.UserDao;
import ie.com.Conor.model.UserDetails;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
    private EntityManager entityManager;
	
	public List<UserDetails> getUserDetails() {
		return null;
	}

}
