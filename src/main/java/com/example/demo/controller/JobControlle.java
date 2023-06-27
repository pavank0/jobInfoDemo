package com.example.demo.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Job;
import com.example.demo.service.JobService;

@RestController
@RequestMapping("/jobs")
public class JobControlle {

    @Autowired
    JobService jobService;


    @PostMapping
    public ResponseEntity<String> postJobs(@RequestBody Job jsonString) {


        Optional<Job> jobOpt = jobService.getJobById(Long.toString(jsonString.getJobId()));


        if (jobOpt.isPresent()) {

            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
        } else
            jobService.saveJobs(jsonString);


        return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Job> findByUUId(@PathVariable String uuid) {

        Optional<Job> job = null;

        job = jobService.getJobById(uuid);

        if (job.isPresent()) {

            return new ResponseEntity<>(job.get(), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping
    public ResponseEntity<List<Job>> findAll() {

        try {

            List<Job> jobList = new ArrayList<>();

            jobService.getAllJobs().forEach(jobList::add);

            return new ResponseEntity<>(jobList, HttpStatus.OK);

        } catch (Exception ex) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }


    }


}
