
package ie.com.Conor.service;

import java.util.List;
import ie.com.Conor.entities.UserDetails;

public interface UserService {

	List <UserDetails> getUserDetails();
	UserDetails findById(int id);
	String findNameofUserByEmail(String Email);
	UserDetails save(UserDetails userDetails);
	
	UserDetails findUser(int userId);
	List<UserDetails> listFirstNameInAlphabeticalOrder();
	UserDetails findByFirstName(String userFirstName);
	

}
