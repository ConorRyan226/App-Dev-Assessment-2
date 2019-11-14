package ie.com.Conor.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ie.com.Conor.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterUser {
	@Autowired
	private UserDao userDao;
	
	/*
	@GetMapping
	 public String showRegistrationForm(Model model) 
	{
		 return "registration";
  }
  */
	
	@GetMapping
	 public String registerUserAccount(Model model) 
	{
		
		  model.addAttribute("registration", userDao.findAll());
	      return "registration";
	      
	}

}
