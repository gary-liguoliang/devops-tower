package com.ninjadevops.tower.service;

import com.ninjadevops.tower.model.ConfigObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigServiceTest {

    private ConfigService configService;

    @Before
    public void setUp() throws Exception {
        configService = new ConfigService();
    }

    @Test
    public void getConfigObjectById() throws Exception {
        String id = "sql-get-env-name";
        ConfigObject configObject = configService.getConfigObjectById(id);
        assertEquals(id, configObject.getId());
    }

    @Test
    public void negativeTest() throws Exception {
        assertEquals(1, 1);
    }
}