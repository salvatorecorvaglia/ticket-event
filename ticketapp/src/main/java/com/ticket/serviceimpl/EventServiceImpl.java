package com.ticket.serviceimpl;

import com.ticket.entities.Event;
import com.ticket.repositories.EventRepository;
import com.ticket.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event saveEvent(Event event) {
        try {
            return eventRepository.save(event);
        } catch (Exception e) {
            throw new RuntimeException("Error saving event", e);
        }
    }

    @Override
    public Event updateEvent(Long id, Event event) {
        try {
            Event existingEvent = eventRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Event not found"));
            existingEvent.setName(event.getName());
            existingEvent.setDescription(event.getDescription());
            existingEvent.setDateTime(event.getDateTime());
            existingEvent.setVenue(event.getVenue());
            return eventRepository.save(existingEvent);
        } catch (Exception e) {
            throw new RuntimeException("Error updating event", e);
        }
    }

    @Override
    public void deleteEvent(Long id) {
        try {
            eventRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting event", e);
        }
    }

    @Override
    public Event getEventById(Long id) {
        try {
            return eventRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Event not found"));
        } catch (Exception e) {
            throw new RuntimeException("Error fetching event", e);
        }
    }

    @Override
    public List<Event> getAllEvents() {
        try {
            return eventRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching events", e);
        }
    }
}
