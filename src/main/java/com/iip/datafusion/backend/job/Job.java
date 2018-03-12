package com.iip.datafusion.backend.job;

public interface Job {
    Integer getUserID();
    JobType getJobType();
    Integer getJobID();
    String getDescription();
    void setUserID(Integer id);
    void setJobID(Integer id);
    void setStatus(JobStatusType status);
    void setJobType(JobType jobType);
}
