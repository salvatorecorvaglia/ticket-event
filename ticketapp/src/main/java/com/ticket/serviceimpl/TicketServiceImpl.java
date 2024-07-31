package com.ticket.serviceimpl;

import com.ticket.entities.Ticket;
import com.ticket.repositories.TicketRepository;
import com.ticket.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket saveTicket(Ticket ticket) {
        try {
            return ticketRepository.save(ticket);
        } catch (Exception e) {
            throw new RuntimeException("Error saving ticket", e);
        }
    }

    @Override
    public Ticket updateTicket(Long id, Ticket ticket) {
        try {
            Ticket existingTicket = ticketRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Ticket not found"));
            existingTicket.setSeatNumber(ticket.getSeatNumber());
            existingTicket.setPrice(ticket.getPrice());
            existingTicket.setUser(ticket.getUser());
            existingTicket.setEvent(ticket.getEvent());
            return ticketRepository.save(existingTicket);
        } catch (Exception e) {
            throw new RuntimeException("Error updating ticket", e);
        }
    }

    @Override
    public void deleteTicket(Long id) {
        try {
            ticketRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting ticket", e);
        }
    }

    @Override
    public Ticket getTicketById(Long id) {
        try {
            return ticketRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Ticket not found"));
        } catch (Exception e) {
            throw new RuntimeException("Error fetching ticket", e);
        }
    }

    @Override
    public List<Ticket> getAllTickets() {
        try {
            return ticketRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching tickets", e);
        }
    }
}
