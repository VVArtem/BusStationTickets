package org.example.busstationtickets.service;

import org.example.busstationtickets.dao.TicketRepository;
import org.example.busstationtickets.model.Ticket;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return (List<Ticket>) ticketRepository.findAll();
    }

    @Override
    public void deleteTicketById(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public void deleteAllTickets() {
        ticketRepository.deleteAll();
    }

    @Override
    public Ticket updateTicket(Long id, Ticket newTicket) {
        return ticketRepository.findById(id)
                .map(ticket -> {
                    ticket.setTripDate(newTicket.getTripDate());
                    ticket.setTripName(newTicket.getTripName());
                    ticket.setBusNumber(newTicket.getBusNumber());
                    ticket.setPrice(newTicket.getPrice());
                    ticket.setSeat(newTicket.getSeat());
                    ticket.setDepartureTime(newTicket.getDepartureTime());
                    return ticketRepository.save(ticket);
                })
                .orElseThrow(() -> new RuntimeException("Ticket not found with id " + id));
    }

    @Override
    public List<Ticket> findTicketsByTripName(String tripName) {
        return ticketRepository.findByTripName(tripName);
    }

    @Override
    public List<Ticket> findTicketsByDepartureTime(LocalTime departureTime) {
        return ticketRepository.findByDepartureTime(departureTime);
    }

    @Override
    public List<Ticket> findTicketsByBusNumber(String busNumber) {
        return ticketRepository.findByBusNumber(busNumber);
    }
}
