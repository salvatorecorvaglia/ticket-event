package com.ticket.controllers;

import com.ticket.entities.Event;
import com.ticket.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody Event event) {
        try {
            return new ResponseEntity<>(eventService.saveEvent(event), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating event: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        try {
            return new ResponseEntity<>(eventService.updateEvent(id, event), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating event: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long id) {
        try {
            eventService.deleteEvent(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting event: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEventById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(eventService.getEventById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching event: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllEvents() {
        try {
            return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching events: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
