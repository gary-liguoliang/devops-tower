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
public class ConfigDataStoreInMemoryTest {

    public static final String DB_CONNECTION_DEV = "db-connection-dev";
    ConfigDataStoreInMemory testingDataStore;

    Map<String, ConfigObject> configObjectMap;

    @Before
    public void setUp() throws Exception {
        testingDataStore = new ConfigDataStoreInMemory();

        configObjectMap = new HashMap<>();
        DBConnection dbConnection = new DBConnection(DB_CONNECTION_DEV);
        configObjectMap.put(dbConnection.getId(), dbConnection);

        testingDataStore.setObjectsRepo(configObjectMap);
    }

    @Test
    public void testGetConfigById() throws Exception {
        ConfigObject result = testingDataStore.getDBConnectionById(DB_CONNECTION_DEV);
        assertEquals(DB_CONNECTION_DEV, result.getId());
    }

    @Test
    public void testSaveNewConfig() throws Exception {
        DBConnection dbConn = DBConnection.newInstance("db-conn", "jdbc://h2:mem:test");
        int repoSizeBeforeSaving = configObjectMap.size();
        testingDataStore.saveDBConnection(dbConn);
        assertEquals(configObjectMap.size(), repoSizeBeforeSaving + 1);
        assertTrue(configObjectMap.containsKey("db-conn"));

    }
}