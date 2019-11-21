package ie.com.Conor.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ie.com.Conor.entities.Job;
import ie.com.Conor.entities.UserDetails;
import ie.com.Conor.service.JobService;

public class JobController {
	
	@Autowired
	JobService jobService;
	
	@GetMapping("/jobs")
	public String showTowns(Model model)
	{
		List<Job> job = jobService.findJobsAlphabticalOrder();
		model.addAttribute("job", job);
		return "job";
	}
}
