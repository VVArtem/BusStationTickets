package org.example.busstationtickets.service;

import org.example.busstationtickets.model.Ticket;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface TicketService {
    // додавання
    Ticket addTicket(Ticket ticket);

    // перегляд за id
    Optional<Ticket> getTicketById(Long id);

    // перегляд повного переліку
    List<Ticket> getAllTickets();

    // видалення за id
    void deleteTicketById(Long id);

    // видалення повного переліку
    void deleteAllTickets();

    // модифікація за id
    Ticket updateTicket(Long id, Ticket newTicket);

    // перегляд за назвою рейса
    List<Ticket> findTicketsByTripName(String tripName);

    // перегляд за часом відправлення
    List<Ticket> findTicketsByDepartureTime(LocalTime departureTime);

    // перегляд за номером автобуса
    List<Ticket> findTicketsByBusNumber(String busNumber);
}
