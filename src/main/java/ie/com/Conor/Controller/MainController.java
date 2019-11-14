package ie.com.Conor.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping(value= {"/", "/index"})
	public String handleIndexRequest()
	{
		return "index";
	}

}