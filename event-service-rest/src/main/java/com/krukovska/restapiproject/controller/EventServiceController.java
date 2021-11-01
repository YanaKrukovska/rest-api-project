package com.krukovska.restapiproject.controller;

import com.krukovska.restapiproject.Event;
import com.krukovska.restapiproject.EventService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/event")
public class EventServiceController {

    private final EventService eventService;

    @Autowired
    public EventServiceController(EventService eventService) {
        this.eventService = eventService;
    }

    @ApiOperation("Create new event")
    @PostMapping(value = "")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        log.info("REST call to create new event {}", event);
        Event createdEvent = eventService.createEvent(event);
        log.info("Created new event {}", createdEvent);
        return new ResponseEntity<>(createdEvent, HttpStatus.OK);
    }

    @ApiOperation("Updated existing event")
    @PutMapping(value = "")
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
        log.info("REST call to update new event {}", event);
        Event updatedEvent = eventService.updateEvent(event);
        log.info("Updated new event {}", updatedEvent);
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }

    @ApiOperation("Get event by id")
    @GetMapping(value = "/{eventId}")
    public ResponseEntity<Event> getEvent(@PathVariable("eventId") Long eventId) {
        log.info("REST call to find event with id {}", eventId);
        Event event = eventService.getEvent(eventId);
        log.info("Found event {}", event);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @ApiOperation("Delete event by id")
    @DeleteMapping(value = "/{eventId}")
    public ResponseEntity<HttpStatus> deleteEvent(@PathVariable("eventId") Long eventId) {
        log.info("REST call to delete event with id {}", eventId);
        eventService.deleteEvent(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation("Get all events")
    @GetMapping(value = "/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        log.info("REST call to find all events");
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);

    }

    @ApiOperation("Get all events by title")
    @GetMapping(value = "/all/{title}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<Event>> getAllEventsByTitle(@PathVariable("title") String title) {
        log.info("REST call to find all events with title {}", title);
        return new ResponseEntity<>(eventService.getAllEventsByTitle(title), HttpStatus.OK);
    }

}
