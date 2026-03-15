package com.example.JobPostApp.controller;


import com.example.JobPostApp.model.JobPost;
import com.example.JobPostApp.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class JobPostController {

    @Autowired
    private JobPostService service;


    @GetMapping("jobPosts")
    public List<JobPost> getJobs(){
        return service.getJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId){
        return service.getJob(postId);
    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        service.deleteJob(postId);
        return "Deleted";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> search(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }

    @GetMapping("load")
    public String loadJobPosts(){
        service.loadJobPosts();
        return "Jobs Loaded Successfully";
    }
}
