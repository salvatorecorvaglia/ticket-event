package com.ticket.controllers;

import com.ticket.entities.Ticket;
import com.ticket.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<?> createTicket(@RequestBody Ticket ticket) {
        try {
            return new ResponseEntity<>(ticketService.saveTicket(ticket), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating ticket: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        try {
            return new ResponseEntity<>(ticketService.updateTicket(id, ticket), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating ticket: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable Long id) {
        try {
            ticketService.deleteTicket(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting ticket: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTicketById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(ticketService.getTicketById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching ticket: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllTickets() {
        try {
            return new ResponseEntity<>(ticketService.getAllTickets(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching tickets: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
