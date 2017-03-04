package com.ninjadevops.tower.service;

import com.ninjadevops.tower.model.ConfigObject;
import com.ninjadevops.tower.model.DBConnection;
import com.ninjadevops.tower.storage.ConfigDataStore;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConfigServiceTest {

    private ConfigService configService;

    @Before
    public void setUp() throws Exception {
        configService = new ConfigService();
        ConfigDataStore configDataStore = mock(ConfigDataStore.class);
        when(configDataStore.getDBConnectionById(anyString())).thenAnswer(
                (InvocationOnMock invocation) -> DBConnection.newInstance((String) invocation.getArguments()[0], "")
        );
        configService.setConfigDataStore(configDataStore);

    }

    @Test
    public void getConfigObjectById() throws Exception {
        String id = "sql-get-env-name";
        ConfigObject configObject = configService.getDBConnectionById(id);
        assertEquals(id, configObject.getId());
    }

}