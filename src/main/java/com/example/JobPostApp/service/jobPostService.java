package com.example.JobPostApp.service;

import com.example.JobPostApp.model.JobPost;
import com.example.JobPostApp.repo.JobPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class jobPostService {

    @Autowired
    private JobPostRepo jobPostRepo;

    public List<JobPost> getJobs() {
        return jobPostRepo.getJobs();
    }

    public JobPost getjob(int postId) {
        return jobPostRepo.getJob(postId);
    }

    public JobPost addJob(JobPost jobPost) {
        jobPostRepo.addJob(jobPost);
        return jobPostRepo.getJob(jobPost.getPostId());
    }

    public void deleteJob(int postId) {
        jobPostRepo.deletejob(postId);
    }
}
