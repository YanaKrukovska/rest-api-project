package com.krukovska.restapiproject;

import java.util.List;

public interface EventService {

    Event createEvent(Event event);

    Event updateEvent(Event event);

    Event getEvent(long eventId);

    void deleteEvent(long eventId);

    List<Event> getAllEvents();

    List<Event> getAllEventsByTitle(String title);

}
