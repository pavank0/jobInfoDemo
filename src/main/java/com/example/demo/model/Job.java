package com.example.demo.model;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jobId;

    @Column(name = "jobTitle")
    private String jobTital;

    @Column(name = "jobDescription")
    private String jobDescription;

    @Column(name = "salary")
    private float salary;


    public long getJobId() {
        return jobId;
    }


    public String getJobTital() {
        return jobTital;
    }

    public void setJobTital(String jobTital) {
        this.jobTital = jobTital;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobDescription, jobId, jobTital, salary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Job other = (Job) obj;
        return Objects.equals(jobDescription, other.jobDescription) && jobId == other.jobId
                && Objects.equals(jobTital, other.jobTital)
                && Float.floatToIntBits(salary) == Float.floatToIntBits(other.salary);
    }

    @Override
    public String toString() {
        return "Job [jobId=" + jobId + ", jobTital=" + jobTital + ", jobDescription=" + jobDescription + ", salary="
                + salary + "]";
    }


}
