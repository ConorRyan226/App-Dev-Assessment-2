package ie.com.Conor.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.qos.logback.core.net.SyslogOutputStream;
import ie.com.Conor.Form.UserForm;
import ie.com.Conor.entities.UserDetails;
import ie.com.Conor.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/userDetails")
	public String userDetails(Model model) {
		List<UserDetails> userDetails = userService.getUserDetails();
		model.addAttribute("userDetails", userDetails);
		return "userDetails";
	}
	
	@GetMapping("/newUser")
	public String addNewUser(Model model)
	{
		model.addAttribute("userForm", new UserForm());
		return "registration";
	}
	
	
	
	@PostMapping("/login")
	public String login(@Valid UserForm userForm, BindingResult binding,RedirectAttributes redirectAttributes )
	{
		if(binding.hasErrors())
			return "login";
		
		UserDetails userDetails = new UserDetails(userForm.getFirstName(),userForm.getLastName(),userForm.getEmail(),userForm.getPassword());
		userDetails = userService.save(userDetails);
		
		if(userDetails != null)
			return "redirect:login";// change to login page
		else {
			redirectAttributes.addFlashAttribute("duplicate", true);
			return "redirect:login";
		}
		
	}
	
	
	
	@GetMapping("/user")
	public String showUserByIdPlease(@RequestParam(name="id") int id, Model model)
	{
		UserDetails user = userService.findById(id);
		if (user == null){
			model.addAttribute("id", id);
			return "notfounderror";
		}
		model.addAttribute("userDetails", user);
		return "userDetail";
	}
	
	
	@PostMapping("/register")
	public String register (@Valid UserForm userForm, BindingResult binding,RedirectAttributes redirectAttributes )
	{
		if(binding.hasErrors())
			return "registration";
		
		UserDetails userDetails = new UserDetails(userForm.getFirstName(),userForm.getLastName(),userForm.getEmail(),userForm.getPassword());
		userDetails = userService.save(userDetails);
		
		if(userDetails != null)
			return "redirect:index";// change to login page
		else {
			redirectAttributes.addFlashAttribute("duplicate", true);
			return "redirect:newUser";
		}
		
	}
}
