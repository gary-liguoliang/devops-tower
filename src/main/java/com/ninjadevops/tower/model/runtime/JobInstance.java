package com.ninjadevops.tower.model.runtime;

import com.ninjadevops.tower.model.ConfigObject;
import com.ninjadevops.tower.model.JobConfig;

/**
 * Created by me@liguoliang.com on 2/18/2017.
 */
public class JobInstance {
    JobConfig jobConfig;
    ConfigObject configObject;

    public JobInstance(JobConfig jobConfig, ConfigObject configObject) {
        this.jobConfig = jobConfig;
        this.configObject = configObject;
    }

    public JobConfig getJobConfig() {
        return jobConfig;
    }

    public ConfigObject getConfigObject() {
        return configObject;
    }
}
