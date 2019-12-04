package ie.com.Conor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.com.Conor.dao.JobDao;
import ie.com.Conor.entities.Job;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
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
	public List<Job> findAllJobs() {
		// TODO Auto-generated method stub
		return jobDao.findAll();
	}
	
	@Override
	public List<Job> findJobsAlphabticalOrder() {
		
		return jobDao.findAllByOrderByJobTitleAsc();
	}

	@Override
	public List<Job> findJobByJobName(String jobTitle) {
		return jobDao.findJobByJobTitle(jobTitle);
	}

	@Override
	public Job findJob(int jobId) {
		if(jobDao.existsById(jobId))
			return jobDao.findById(jobId).get();
		return null;
	}

	@Override
	public Job save(Job job) {
		
		log.info(job.toString());
	    //if (jobDao.existsByJobTitleAndDesc(job.getJobTitle(), job.getJobDesc(), job.getUser()))
			//return null;
		return jobDao.save(job);
	}

	@Override
	public boolean closeJob(Job job) {
		if (! jobDao.existsById(job.getJobId()))
			return false;
		jobDao.delete(job);
		System.out.println(jobDao.existsByJobName(job.getJobTitle()));
		return true;
	}
}