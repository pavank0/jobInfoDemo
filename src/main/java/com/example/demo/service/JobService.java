package com.example.demo.service;

import com.example.demo.model.Job;
import com.example.demo.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    public List<Job> getAllJobs() {


        return jobRepository.findAll();
    }

    public Optional<Job> getJobById(String jobId) {


        return jobRepository.findById(Long.parseLong(jobId));
    }

    public Job saveJobs(Job jb){


        Job jbId = jobRepository.save(jb);

        return jbId;
    }

}
