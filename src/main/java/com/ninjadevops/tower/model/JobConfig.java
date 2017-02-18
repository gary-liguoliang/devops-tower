package com.ninjadevops.tower.model;

/**
 * Created by me@liguoliang.com on 2/18/2017.
 */
public class JobConfig implements ConfigObject{
    String id;
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
}
