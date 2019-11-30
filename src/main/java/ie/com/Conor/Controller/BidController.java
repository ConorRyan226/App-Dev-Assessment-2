package ie.com.Conor.Controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ie.com.Conor.Form.BidForm;
import ie.com.Conor.entities.Bid;
import ie.com.Conor.entities.Job;
import ie.com.Conor.service.BidService;
import ie.com.Conor.service.JobService;
import ie.com.Conor.service.UserService;



@Controller
public class BidController {

	@Autowired 
	BidService bidService;
	@Autowired
	JobService jobService;
	@Autowired 
	UserService userService;
	
	@GetMapping("/showbidsbyjobid")
	public String showBidsByJobId(@PathVariable(name="id") int id, Model model)
	{
		
		List<Bid> bids = bidService.findBidsByJobId(id);
		model.addAttribute("bids", bids);
		return "bids";
	}
	
	@GetMapping("/showbids")
	public String showBidsById(Model model) {
	
		List<Bid> bids = bidService.findAllByOrderByBidId();
		model.addAttribute("bids", bids);
		return "bids";
	}
	
	@GetMapping("/showbid")
	public String showBidById(@RequestParam(name="id") int id, Model model)
	{
		Bid bid = bidService.findBid(id);
		if (bid == null){
			model.addAttribute("id", id);
			return "notfounderror";
		}
		model.addAttribute("bid", bidService.findBid(id));
		return "bid";
	}
	
	@GetMapping("/bidsinJob/{id}")
	public String showBidsInJob(@PathVariable(name="id") int id, Model model)
	{
		Job job = jobService.findJob(id);
		if ( job == null) {
			model.addAttribute("id", id);
			return "notfounderror";
		}
		model.addAttribute("job", job);
		return "bidsInJob";
	}
		
	
	@GetMapping("newbid")
	public String addNewBid(Model model)
	{
		model.addAttribute("bidForm", new BidForm());
		model.addAttribute("users", userService.listFirstNameInAlphabeticalOrder());
		model.addAttribute("jobs", jobService.findJobsAlphabticalOrder());	
		return "newbid";
	}

	
	@PostMapping("/newbid")
	public String addNewBid(Model model, @Valid BidForm bidForm, BindingResult binding, RedirectAttributes redirectAttributes)
	{
		if (binding.hasErrors())
		{
			return "newbid";
		}
		
		Bid bid = new Bid(bidForm.getBidValue(), jobService.findJob(bidForm.getJobId()), userService.findUser(bidForm.getUserId()));
		
		if (bidService.save(bid) == null)
			{
				redirectAttributes.addFlashAttribute("duplicate", true);
				return "redirect:newbid";
			}
		return "redirect:/showbid?id="+bid.getBidId();
	}

}
