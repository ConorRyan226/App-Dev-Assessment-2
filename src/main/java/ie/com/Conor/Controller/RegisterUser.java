package ie.com.Conor.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ie.com.Conor.Form.UserForm;
import ie.com.Conor.dao.UserDao;
import ie.com.Conor.entities.UserDetails;
import ie.com.Conor.service.UserService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterUser {

	@Autowired
	private UserService userService;
	
	@GetMapping
	 public String showRegistrationForm(Model model) 
	{
		 return "registration";
  }
	
	@GetMapping("newUser")
	public String addNewUser(Model model)
	{
		model.addAttribute("userForm", new UserForm());
		return "userDetails";
	}
	
	@GetMapping("/showUser")
	public String showUserById(@RequestParam(name="id") int id, Model model)
	{
		UserDetails user = userService.findById(id);
		if (user == null){
			model.addAttribute("id", id);
			return "notfounderror";
		}
		model.addAttribute("userDetails", userService.findById(id));//create findbyid method 
		return "userDetails";
	}
	


	/*
	@PostMapping("/registration")
	public String addNewUserSave(@Valid UserForm userForm, BindingResult binding, RedirectAttributes redirectAttributes)
	{
		if (binding.hasErrors())
			return "index";
		UserDetails userDetails = new UserDetails(userForm.getFirstName(), userForm.getLastName(), userForm.getEmail(), userForm.getPassword());
		userDetails = userService.save(userDetails);
		
		if (userDetails !=null )
			return "redirect:index/"+userDetails.getId();
		
		else {
			redirectAttributes.addFlashAttribute("duplicate", true);
			return "redirect:registration";
		}
	
	}
	
	@GetMapping
	 public String registerUserAccount(Model model) 
	{	
		  model.addAttribute("registration", new RegisterUser());
	      return "registration";     
	}*/
}
