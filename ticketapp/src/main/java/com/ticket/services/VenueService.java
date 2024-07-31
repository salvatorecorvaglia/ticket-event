package com.ticket.services;

import com.ticket.entities.Venue;

import java.util.List;

public interface VenueService {
    Venue saveVenue(Venue venue);
    Venue updateVenue(Long id, Venue venue);
    void deleteVenue(Long id);
    Venue getVenueById(Long id);
    List<Venue> getAllVenues();
}
