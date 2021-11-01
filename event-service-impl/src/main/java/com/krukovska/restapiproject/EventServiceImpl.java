package com.krukovska.restapiproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository repository;

    @Autowired
    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public Event createEvent(Event event) {
        return repository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return repository.save(event);
    }

    @Override
    public Event getEvent(long eventId) {
        return repository.findById(eventId);
    }

    @Override
    public void deleteEvent(long eventId) {
        repository.deleteById(eventId);
    }

    @Override
    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    @Override
    public List<Event> getAllEventsByTitle(String title) {
        return repository.findAllByTitle(title);
    }
}
