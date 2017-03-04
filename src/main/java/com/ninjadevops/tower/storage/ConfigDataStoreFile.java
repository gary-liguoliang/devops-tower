package com.ninjadevops.tower.storage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ninjadevops.tower.exception.StorageException;
import com.ninjadevops.tower.model.DBConnection;
import com.ninjadevops.tower.model.JobConfig;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by me@liguoliang.com on 2/26/2017.
 */
public class ConfigDataStoreFile implements ConfigDataStore {
    private static final Type listTypeDBConnection = new TypeToken<ArrayList<DBConnection>>() {}.getType();
    private static final Type listTypeJobConfig = new TypeToken<ArrayList<JobConfig>>() {}.getType();
    private File dbConnectionsSource;
    private File configJobsSource ;

    public void setDbConnectionsSource(File dbConnectionsSource) {
        this.dbConnectionsSource = dbConnectionsSource;
    }

    public void setConfigJobsSource(File configJobsSource) {
        this.configJobsSource = configJobsSource;
    }

    private FileReader getFileReader(File f) throws StorageException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileReader;
    }

    @Override
    public DBConnection getDBConnectionById(String id) throws StorageException {
        List<DBConnection> dbConnections = null;
        dbConnections = new Gson().fromJson(getFileReader(dbConnectionsSource), listTypeDBConnection);
        for (DBConnection dbConnection : dbConnections) {
            if (id.equals(dbConnection.getId())) {
                return dbConnection;
            }
        }

        return null;
    }



    @Override
    public DBConnection saveDBConnection(DBConnection dbConnection) {
        return null;
    }

    @Override
    public JobConfig getJobConfigByID(String id) throws StorageException {
        List<JobConfig> jobConfigs = null;
        jobConfigs = new Gson().fromJson(getFileReader(configJobsSource), listTypeJobConfig);
        for (JobConfig jobConfig: jobConfigs) {
            if (id.equals(jobConfig.getId())) {
                return jobConfig;
            }
        }

        return null;
    }

    @Override
    public JobConfig saveJobConfig(JobConfig jobConfig) {
        return null;
    }


}
