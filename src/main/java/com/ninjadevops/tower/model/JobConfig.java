package com.ninjadevops.tower.model;

/**
 * Created by me@liguoliang.com on 2/18/2017.
 */
public class JobConfig implements ConfigObject{
    private String id;
    private String command;

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static ConfigObject newInstance(String id, String command) {
        JobConfig newJobConfig = new JobConfig();
        newJobConfig.setId(id);
        newJobConfig.setCommand(command);
        return newJobConfig;
    }

    @Override
    public String toString() {
        return "JobConfig{" +
                "id='" + id + '\'' +
                ", command='" + command + '\'' +
                '}';
    }
}
