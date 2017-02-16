package com.ninjadevops.tower.model;

/**
 * Created by me@liguoliang.com on 2/16/2017.
 * ConfigObject represents the configuration of a job, e.g. SQL query for a DB job.
 */
public class ConfigObject {

    private String id;

    public ConfigObject(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
