package com.ticket.controllers;

import com.ticket.entities.Venue;
import com.ticket.services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venues")
public class VenueController {

    @Autowired
    private VenueService venueService;

    @PostMapping
    public ResponseEntity<?> createVenue(@RequestBody Venue venue) {
        try {
            return new ResponseEntity<>(venueService.saveVenue(venue), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating venue: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVenue(@PathVariable Long id, @RequestBody Venue venue) {
        try {
            return new ResponseEntity<>(venueService.updateVenue(id, venue), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating venue: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVenue(@PathVariable Long id) {
        try {
            venueService.deleteVenue(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting venue: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVenueById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(venueService.getVenueById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching venue: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllVenues() {
        try {
            return new ResponseEntity<>(venueService.getAllVenues(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching venues: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
