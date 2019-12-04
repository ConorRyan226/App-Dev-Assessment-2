package ie.com.Conor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ie.com.Conor.entities.Job;
import ie.com.Conor.entities.UserDetails;
import ie.com.Conor.service.JobService;
import ie.com.Conor.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Component   // this class becomes a Spring-managed bean
@Slf4j       // part of Lombok, this creates a logger called log 
public class SchedulingTasks {

 // cron = "seconds hours minutes day month year"
 // At 13:02:00 every day of every month of every year....
 @Scheduled(cron = "0 0 0 20 * *")
 public void closeJob() {
        log.info("Job closed");
 }

 // Scheduled events can also interact with the database.
 // Here I am using it to log the towns currently in the database
 // but you might use it to change the status of jobs which are
 // over 20 days old. 
 @Autowired
 JobService jobService;


 @Scheduled(fixedRate = 10000)
 public void listProjects() {
   List<Job> job = jobService.findAllJobs();
   String s = "";
   for (Job closeJobs: job)
      s +=jobService.closeJob((Job) job) + " "; //Should change this to username througout the project
   log.info(s);
 }
 @Bean
 public
 PasswordEncoder passwordEncoder ()
 {
 return new
 BCryptPasswordEncoder();
 }
}