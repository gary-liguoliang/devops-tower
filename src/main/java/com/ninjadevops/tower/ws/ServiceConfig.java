package com.ninjadevops.tower.ws;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Created by me@liguoliang.com on 3/5/2017.
 */
@Component
@ComponentScan("com.ninjadevops.tower")
public class ServiceConfig extends ResourceConfig{
    public ServiceConfig() {
        register(StatusEndpoint.class);
    }
}
