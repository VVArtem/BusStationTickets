package org.example.busstationtickets.service;

import org.example.busstationtickets.dto.TicketCreateRequest;
import org.example.busstationtickets.dto.TicketUpdateRequest;
import org.example.busstationtickets.repository.TicketRepository;
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
    public Ticket addTicket(TicketCreateRequest request) {
        Ticket ticket = new Ticket(
                request.getTripDate(),
                request.getTripName(),
                request.getBusNumber(),
                request.getPrice(),
                request.getSeat(),
                request.getDepartureTime()
        );
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
    public Ticket updateTicket(Long id, TicketUpdateRequest request) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        if (request.getTripDate() != null) ticket.setTripDate(request.getTripDate());
        if (request.getTripName() != null) ticket.setTripName(request.getTripName());
        if (request.getBusNumber() != null) ticket.setBusNumber(request.getBusNumber());
        if (request.getPrice() != null) ticket.setPrice(request.getPrice());
        if (request.getSeat() != null) ticket.setSeat(request.getSeat());
        if (request.getDepartureTime() != null) ticket.setDepartureTime(request.getDepartureTime());

        return ticketRepository.save(ticket);
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
