package org.example.busstationtickets.dao;

import org.example.busstationtickets.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

}

