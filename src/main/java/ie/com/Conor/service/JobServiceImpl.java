package ie.com.Conor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ie.com.Conor.dao.JobDao;
import ie.com.Conor.entities.Job;

public class JobServiceImpl implements JobService{
	
	@Autowired
	JobDao jobDao;


	@Override
	public Job findJobById(int jobId) {
		// TODO Auto-generated method stub
	if (jobDao.existsById(jobId))
		return jobDao.findById(jobId).get();
		return null;
	}

	@Override
	public Job save(Job job) {
		return jobDao.save(job);
	}


	@Override
	public List<Job> findAllJobs() {
		// TODO Auto-generated method stub
		return jobDao.findAll();
	}
}
