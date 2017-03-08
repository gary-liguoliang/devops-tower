package com.ninjadevops.tower.storage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ninjadevops.tower.exception.StorageException;
import com.ninjadevops.tower.model.DBConnection;
import com.ninjadevops.tower.model.JobConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by me@liguoliang.com on 2/26/2017.
 */
@Service
public class ConfigDataStoreFile implements ConfigDataStore {
    private static final Type listTypeDBConnection = new TypeToken<ArrayList<DBConnection>>() {}.getType();
    private static final Type listTypeJobConfig = new TypeToken<ArrayList<JobConfig>>() {}.getType();

    @Value("${dbConnectionsSource:C:\\dev\\projects\\devops-tower\\src\\main\\resources\\db-connections.json}")
    private String dbConnectionsSource;

    @Value("${dbConnectionsSource:C:\\dev\\projects\\devops-tower\\src\\main\\resources\\job-configs.json}")
    private String configJobsSource ;

    public void setDbConnectionsSource(String dbConnectionsSource) {
        this.dbConnectionsSource = dbConnectionsSource;
    }

    public void setConfigJobsSource(String configJobsSource) {
        this.configJobsSource = configJobsSource;
    }

    private FileReader getFileReader(String filePath) throws StorageException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileReader;
    }

    @Override
    public DBConnection getDBConnectionById(String id) throws StorageException {
        System.out.println("finding: " + id + ", form: " + this.dbConnectionsSource);
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
