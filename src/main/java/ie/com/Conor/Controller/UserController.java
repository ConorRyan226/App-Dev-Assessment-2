package ie.com.Conor.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ie.com.Conor.entities.UserDetails;
import ie.com.Conor.service.UserService;

//@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/userDetails")
	public String userDetails(Model model) {
		List<UserDetails> userDetails = userService.getUserDetails();
		model.addAttribute("userDetails", userDetails);
		return "userDetails";
	}

}
