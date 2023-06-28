package com.example.demo.job_info10.snapshot;

import com.example.demo.Application;
import com.example.demo.model.Job;
import com.example.demo.repository.JobRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    JobRepository jobRepository;

    @Test
    void contextLoads() {
    }

    Job job0 = new Job();
    Job job1 = new Job();
    Job job2 = new Job();

    @Before
    public void init() {

        job0.setJobDescription("Sr. Java Developer");
        job0.setJobTital("Developer");
        job0.setSalary(850000);


        job1.setJobDescription("Java Developer");
        job1.setJobTital("Developer");
        job1.setSalary(55000);


        job2.setJobDescription("Sr. QA");
        job2.setJobTital("Developer");
        job2.setSalary(850000);

    }

    /*
    * Unit test case for saving the Jobs
     */
    @Test
    public void test1() {


        Assert.assertNotNull(jobRepository.save(job0));
        Assert.assertNotNull(jobRepository.save(job1));
        Assert.assertNotNull(jobRepository.save(job2));


    }

    /*
        Unit testcase for find all saved jobs
     */
    @Test
    public void test2() {

        Assert.assertNotNull(jobRepository.findAll());

    }

    /*
        Unit test case for find job by UUID
     */
    @Test
    public void test3() {
        Assert.assertNotNull(jobRepository.findById(1L));

        Assert.assertFalse(jobRepository.findById(5L).isPresent());
    }

}
