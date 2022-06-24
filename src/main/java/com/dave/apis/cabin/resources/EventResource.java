package com.dave.apis.cabin.resources;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dave.apis.cabin.core.Event;

@Path("events")
@Produces(MediaType.APPLICATION_JSON)
public class EventResource {
	
	@GET
	public List<Event> allEvents() {
		Event e = new Event();
		e.setId(1L);
		e.setName("Dave's Birthday");
		e.setDescription("Today we'll be having a big party... Hurry up!!!");
		e.setDate(new Date());
		e.setLocation("Sedney Park, Nairobi");
		
		return Collections.singletonList(e);
	}
}
