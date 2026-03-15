package com.example.JobPostApp.service;

import com.example.JobPostApp.model.JobPost;
import com.example.JobPostApp.repo.JobPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobPostService {

    @Autowired
    private JobPostRepo jobPostRepo;

    public List<JobPost> getJobs() {
        return jobPostRepo.findAll();
    }

    public JobPost getJob(int postId) {
        return jobPostRepo.findById(postId).orElse(new JobPost());
    }

    public JobPost addJob(JobPost jobPost) {
        jobPostRepo.save(jobPost);
        return jobPostRepo.findById(jobPost.getPostId()).orElse(new JobPost());
    }

    public void deleteJob(int postId) {
        jobPostRepo.deleteById(postId);
    }

    public List<JobPost> search(String keyword){
        return jobPostRepo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }

    public void loadJobPosts(){
        List<JobPost> jobs = new ArrayList<>(List.of(
                new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                        List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
                        List.of("HTML", "CSS", "JavaScript", "React")),
                new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                        List.of("Python", "Machine Learning", "Data Analysis")),
                new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                        List.of("Networking", "Cisco", "Routing", "Switching")),
                new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                        List.of("iOS Development", "Android Development", "Mobile App"))
        ));

        jobPostRepo.saveAll(jobs);
    }
}


