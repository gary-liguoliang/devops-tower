package com.ninjadevops.tower.storage;

import com.ninjadevops.tower.model.ConfigObject;
import com.ninjadevops.tower.model.DBConnection;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by me@liguoliang.com on 2/20/2017.
 */
public class ConfigDataStoreTest {

    public static final String DB_CONNECTION_DEV = "db-connection-dev";
    ConfigDataStore testingDataStore;

    Map<String, ConfigObject> configObjectMap;

    @Before
    public void setUp() throws Exception {
        testingDataStore = new ConfigDataStore();

        configObjectMap = new HashMap<>();
        DBConnection dbConnection = new DBConnection(DB_CONNECTION_DEV);
        configObjectMap.put(dbConnection.getId(), dbConnection);

        testingDataStore.setObjectsRepo(configObjectMap);
    }

    @Test
    public void testGetConfigById() throws Exception {
        ConfigObject result = testingDataStore.getConfigObjectById(DB_CONNECTION_DEV);
        assertEquals(DB_CONNECTION_DEV, result.getId());
    }

    @Test
    public void testSaveNewConfig() throws Exception {
        ConfigObject dbConn = DBConnection.newInstance("db-conn", "jdbc://mysql.instance/db1");
        int repoSizeBeforeSaving = configObjectMap.size();
        testingDataStore.saveConfigObject(dbConn);
        assertEquals(configObjectMap.size(), repoSizeBeforeSaving + 1);
        assertTrue(configObjectMap.containsKey("db-conn"));

    }
}