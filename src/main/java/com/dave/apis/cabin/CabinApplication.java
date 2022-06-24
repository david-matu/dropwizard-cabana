package com.dave.apis.cabin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.dave.apis.cabin.resources.EventResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class CabinApplication extends Application<CabinConfiguration> {

    public static void main(final String[] args) throws Exception {
        new CabinApplication().run(args);
    }

    @Override
    public String getName() {
        return "Cabin";
    }

    @Override
    public void initialize(final Bootstrap<CabinConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final CabinConfiguration configuration, final Environment environment) {
    	DateFormat eventDateFromat = new SimpleDateFormat(configuration.getDateFormat());
        environment.getObjectMapper().setDateFormat(eventDateFromat);
        
        EventResource eventResource = new EventResource();
        environment.jersey().register(eventResource);
    }

}
