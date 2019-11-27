package ie.com.Conor.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ie.com.Conor.entities.Job;
import ie.com.Conor.service.JobService;
import ie.com.Conor.service.UserService;
import ie.com.Conor.Form.JobForm;


@Controller
public class JobController {
	
	@Autowired
	JobService jobService;
	
	@Autowired 
	UserService userService;
	
	@GetMapping("/jobs")
	public String showJobs(Model model)
	{
		List<Job> job = jobService.findAllJobs();
		model.addAttribute("job", job);
		return "jobs";
	}
	
	@GetMapping("/newjob")
	public String addNewJob(Model model)
	{
		model.addAttribute("jobForm", new JobForm());
		return "newjob";
	}
	
	
	@PostMapping("/newjob")
	public String addNewJob(@Valid JobForm jobForm, BindingResult binding,RedirectAttributes redirectAttributes )
	{
		if(binding.hasErrors())
			return "newjob";
		
		Job job = new Job(jobForm.getJobTitle(),jobForm.getJobDesc(), null); //shouldn't be null and add Principal 
		job = jobService.save(job);
		
		if(job != null)
			return "redirect:newjob";
		else {
			redirectAttributes.addFlashAttribute("duplicate", true);
			return "redirect:newjob";
		}
		
	}
}
