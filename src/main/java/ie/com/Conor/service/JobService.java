package ie.com.Conor.service;

import java.util.List;

import ie.com.Conor.entities.Job;


public interface JobService {
	Job findJobById(int jobId);
	List<Job> findAllJobs();
	Job save(Job job);
	Job findJob(int id);
	
	List<Job> findJobsAlphabticalOrder();
	List<Job> findJobByJobName(String jobName);
	
	boolean closeJob(Job job);
	
}
