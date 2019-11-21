package ie.com.Conor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ie.com.Conor.entities.UserDetails;
import ie.com.Conor.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Component   // this class becomes a Spring-managed bean
@Slf4j       // part of Lombok, this creates a logger called log 
public class SchedulingTasks {

 // cron = "seconds hours minutes day month year"
 // At 13:02:00 every day of every month of every year....
 @Scheduled(cron = "0 02 13 * * *")
 public void timeForTea() {
        log.info("Hello it is time for tea");
 }

 // Scheduled events can also interact with the database.
 // Here I am using it to log the towns currently in the database
 // but you might use it to change the status of jobs which are
 // over 20 days old. 
 @Autowired
 UserService userService;

 // Every 60000ms print the list of towns.
 @Scheduled(fixedRate = 60000)
 public void listProjects() {
   List<UserDetails> users = userService.getUserDetails();
   String s = "";
   for (UserDetails details: users)
      s += details.getFirstName() + " "; //Should change this to username througout the project
   log.info(s);
 }
}