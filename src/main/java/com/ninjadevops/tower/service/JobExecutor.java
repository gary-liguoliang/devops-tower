package com.ninjadevops.tower.service;

import com.ninjadevops.tower.model.DBConnection;
import com.ninjadevops.tower.model.runtime.JobInstance;
import com.ninjadevops.tower.model.runtime.JobRunResult;

import java.sql.*;

/**
 * Created by me@liguoliang.com on 2/18/2017.
 */
public class JobExecutor {

    public JobRunResult execute(JobInstance jobInstance) throws JobExecutionException {
        DBConnection dbConnection = (DBConnection) jobInstance.getConfigObject();

        try {
            Class.forName("org.h2.Driver");
            Connection connection = DriverManager.getConnection(dbConnection.getConnectionString());

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(jobInstance.getJobConfig().getCommand());
            String result = "";
            while (resultSet.next()) {
                result += resultSet.getString(1);
            }

            JobRunResult jobRunResult = new JobRunResult();
            jobRunResult.setValue(result);
            return jobRunResult;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new JobExecutionException(e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new JobExecutionException(e);
        }
    }

    class JobExecutionException extends Exception {
        public JobExecutionException(Throwable cause) {
            super(cause);
        }

        public JobExecutionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}
