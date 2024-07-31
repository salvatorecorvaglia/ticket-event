package com.ticket.services;

import com.ticket.entities.Ticket;

import java.util.List;

public interface TicketService {
    Ticket saveTicket(Ticket ticket);
    Ticket updateTicket(Long id, Ticket ticket);
    void deleteTicket(Long id);
    Ticket getTicketById(Long id);
    List<Ticket> getAllTickets();
}
