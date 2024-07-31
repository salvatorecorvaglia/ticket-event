package com.ticket.services;


import com.ticket.entities.Event;

import java.util.List;

public interface EventService {
    Event saveEvent(Event event);
    Event updateEvent(Long id, Event event);
    void deleteEvent(Long id);
    Event getEventById(Long id);
    List<Event> getAllEvents();
}
