package ie.com.Conor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ie.com.Conor.dao.JobDao;
import ie.com.Conor.dao.UserDao;
import ie.com.Conor.entities.Bid;
import ie.com.Conor.entities.Job;
import ie.com.Conor.entities.UserDetails;

@SpringBootApplication
public class Application implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    UserDao userDao;
    
    @Autowired
    JobDao jobDao;
    
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		UserDetails user1 = new UserDetails("Fred", "Bloggs", "fred.bloggs@cit.ie", "password");
		userDao.save(user1);
		
		Job kitchen = new Job("Fit kitchen", "IKEA full kitchen", user1);
		jobDao.save(kitchen);
		
		UserDetails user2 = new UserDetails("Test","test","test@cit.ie","password");
		userDao.save(user2);
		
		
	}

}