package com.ninjadevops.tower.model;

/**
 * Created by me@liguoliang.com on 2/18/2017.
 */
public class DBConnection implements ConfigObject {
    String id;
    String connectionString;
    String bgColor;

    public DBConnection(String id) {
        this.id = id;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public String getConnectionString() {
        return connectionString;
    }

    @Override
    public String getId() {
        return id;
    }

    public static DBConnection newInstance(String id, String connectionString) {
        DBConnection dbConnection = new DBConnection(id);
        dbConnection.setConnectionString(connectionString);
        return dbConnection;
    }

    @Override
    public String toString() {
        return "DBConnection{" +
                "id='" + id + '\'' +
                ", connectionString='" + connectionString + '\'' +
                '}';
    }
}
