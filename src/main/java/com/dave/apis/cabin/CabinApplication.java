package com.dave.apis.cabin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.dave.apis.cabin.core.DummyEventRepository;
import com.dave.apis.cabin.core.EventRepository;
import com.dave.apis.cabin.resources.EventResource;

import ch.qos.logback.classic.Logger;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
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
    public void run(final CabinConfiguration config, final Environment environment) {
    	
    	
    	DateFormat eventDateFromat = new SimpleDateFormat(config.getDateFormat());
        environment.getObjectMapper().setDateFormat(eventDateFromat);
        
        //Dependency inversion, and a good use of Interfaces
        EventRepository repo = new DummyEventRepository();
        
        /*
         * Initialize the DB
         */
        final DBIFactory factory = new DBIFactory();
        final DBI jdbc = factory.build(environment, config.get, getName())
        
        EventResource eventResource = new EventResource(repo);
        environment.jersey().register(eventResource);
    }

}
