package ie.com.Conor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import ie.com.Conor.dao.JobDao;
import ie.com.Conor.dao.RoleDao;
import ie.com.Conor.dao.UserDao;
import ie.com.Conor.entities.Bid;
import ie.com.Conor.entities.Job;
import ie.com.Conor.entities.Role;
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
    @Autowired
    RoleDao roleDao;
    @Autowired
    PasswordEncoder passwordEncoder;
    
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Role role1 = new Role("test@cit.ie","ROLE_USER");
		roleDao.save(role1);
		
		//UserDetails user2 = new UserDetails("Test@test.ie",passwordEncoder.encode("password"),role1,true);
		Role fredsRole = new Role("fred.bloggs@cit.ie", "ROLE_USER");
		roleDao.save(fredsRole);
		
		UserDetails user1 = new UserDetails( "Fred", "Bloggs","fred.bloggs@cit.ie",passwordEncoder.encode("password"), true, fredsRole);
		userDao.save(user1);
		
		UserDetails user2 = new UserDetails("Test","test","test@cit.ie","password");
		userDao.save(user2);
		
		Job kitchen = new Job("Fit kitchen", "IKEA full kitchen", user1);
		jobDao.save(kitchen);
		Job bathroom = new Job("Fix toilet", "IKEA new Toilet", user2);
		jobDao.save(bathroom);
		
		
	}

}