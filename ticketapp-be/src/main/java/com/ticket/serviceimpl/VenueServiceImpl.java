package com.ticket.serviceimpl;

import com.ticket.entities.Venue;
import com.ticket.repositories.VenueRepository;
import com.ticket.services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueServiceImpl implements VenueService {

    @Autowired
    private VenueRepository venueRepository;

    @Override
    public Venue saveVenue(Venue venue) {
        try {
            return venueRepository.save(venue);
        } catch (Exception e) {
            throw new RuntimeException("Error saving venue", e);
        }
    }

    @Override
    public Venue updateVenue(Long id, Venue venue) {
        try {
            Venue existingVenue = venueRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Venue not found"));
            existingVenue.setName(venue.getName());
            existingVenue.setAddress(venue.getAddress());
            existingVenue.setCapacity(venue.getCapacity());
            return venueRepository.save(existingVenue);
        } catch (Exception e) {
            throw new RuntimeException("Error updating venue", e);
        }
    }

    @Override
    public void deleteVenue(Long id) {
        try {
            venueRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting venue", e);
        }
    }

    @Override
    public Venue getVenueById(Long id) {
        try {
            return venueRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Venue not found"));
        } catch (Exception e) {
            throw new RuntimeException("Error fetching venue", e);
        }
    }

    @Override
    public List<Venue> getAllVenues() {
        try {
            return venueRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching venues", e);
        }
    }
}

