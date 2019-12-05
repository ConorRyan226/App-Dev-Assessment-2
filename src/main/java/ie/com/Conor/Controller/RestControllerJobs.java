package ie.com.Conor.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ie.com.Conor.Form.JobForm;
import ie.com.Conor.entities.Job;
import ie.com.Conor.entities.UserDetails;
import ie.com.Conor.service.JobService;
import ie.com.Conor.service.UserService;



@RestController
@RequestMapping("/api")
public class RestControllerJobs {
	
	
	
	@Autowired
	JobService jobService;
	
	@Autowired 
	UserService userService;
	
	@GetMapping("/showjobs")
	public List<Job> restShowJobs(Model model)
	{
		return jobService.findJobsAlphabticalOrder();
	
	
	}
	
	
	@GetMapping("/showjob")
	public String showJobById(@RequestParam(name="id") int id, Model model)
	{
		Job job = jobService.findJob(id);
		if (job == null){
			model.addAttribute("id", id);
			return "notfounderror";
		}
		model.addAttribute("job", jobService.findJob(id));
		return "job";
	}
	
	@GetMapping("/jobsinuser/{id}")
	public String showJobsInUser(@PathVariable(name="id") int id, Model model)
	{
		UserDetails user = userService.findUser(id);
		if ( user == null) {
			model.addAttribute("id", id);
			return "notfounderror";
		}
		model.addAttribute("user", user);
		return "jobsInUser";
	}
		
	
	@GetMapping("newjob")
	public String addNewJob(Model model)
	{
		model.addAttribute("jobForm", new JobForm());
		model.addAttribute("users", userService.listFirstNameInAlphabeticalOrder());
		return "newjob";
	}

	
	@PostMapping("newjob")
	public String addNewJob(Model model, @Valid JobForm jobForm, BindingResult binding, RedirectAttributes redirectAttributes)
	{
		if (binding.hasErrors())
		{
			model.addAttribute("jobs", jobService.findJobsAlphabticalOrder());
			return "newjob";
		}
		
		//Job job = new Job(jobForm.getJobName(), userService.findUser(jobForm.getUserId()));
	//	Job job = new Job(jobForm.getJobDesc(),jobForm.getJobTitle(), jobForm.getEmail());
		
	//	if (jobService.save(job) == null)
		{
			redirectAttributes.addFlashAttribute("duplicate", true);
			return "redirect:/newjob";
		}
			
	//	return "redirect:/showjob?id="+job.getJobId();
	}

	
}
