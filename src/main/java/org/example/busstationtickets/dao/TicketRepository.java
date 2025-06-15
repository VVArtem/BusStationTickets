package org.example.busstationtickets.dao;

import org.example.busstationtickets.model.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalTime;
import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
    List<Ticket> findByTripName(String tripName);
    List<Ticket> findByDepartureTime(LocalTime departureTime);
    List<Ticket> findByBusNumber(String busNumber);
}

