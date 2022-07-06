package com.dave.apis.cabin.resources;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dave.apis.cabin.core.Event;
import com.dave.apis.cabin.core.EventRepository;

import io.dropwizard.jersey.params.LongParam;

@Path("events")
@Produces(MediaType.APPLICATION_JSON)
public class EventResource {
	
	private EventRepository repo;
	
	public EventResource(EventRepository repo) {
		this.repo = repo;
	}
	
	@GET
	@Path("{id}")
	public Event event(@PathParam("id") LongParam id) {
		
		return repo.findById(id.get())
				.orElseThrow(() -> new WebApplicationException("Event not found", 404));
	}
	
	@GET
	public List<Event> allEvents() {
//		Event e = new Event();
//		e.setId(1L);
//		e.setName("Dave's Birthday");
//		e.setDescription("Today we'll be having a big party... Hurry up!!!");
//		e.setDate(new Date());
//		e.setLocation("Sedney Park, Nairobi");
		
//		return Collections.singletonList(e);
		
		return repo.findAll();
	}
	
	@POST
	public Event create(Event event) {
		return repo.save(event);
	}
	
	@PUT
	@Path("{id}")
	public Event update(@PathParam("id") LongParam id, Event event) {
		return repo.update(id.get(), event)
				.orElseThrow(() ->
				new WebApplicationException("Event not found", 404));
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") LongParam id) {
		repo.delete(id.get());
		return Response.ok().build();
	}
}
