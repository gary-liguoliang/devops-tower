package com.ninjadevops.tower.model.runtime;

import com.google.gson.Gson;

/**
 * Created by me@liguoliang.com on 2/18/2017.
 */
public class JobRunResult {
    private String value;
    private JobInstance jobInstance;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    public JobInstance getJobInstance() {
        return jobInstance;
    }

    public void setJobInstance(JobInstance jobInstance) {
        this.jobInstance = jobInstance;
    }
}
