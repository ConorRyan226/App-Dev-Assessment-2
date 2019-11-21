package ie.com.Conor.service;

import java.util.List;

import ie.com.Conor.entities.Job;


public interface JobService {
	List<Job> findJobsAlphabticalOrder();

	Job findJob(int jobId);
	Job save(Job job);
}
