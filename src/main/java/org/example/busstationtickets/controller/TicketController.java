package org.example.busstationtickets.controller;

import org.example.busstationtickets.model.Ticket;
import org.example.busstationtickets.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/tickets")
@RestController
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // Додавання квитка
    @PostMapping
    public Ticket addTicket(@NonNull @RequestBody Ticket ticket) {
        return ticketService.addTicket(ticket);
    }

    // Отримати всі квитки
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    // Отримати квиток за id
    @GetMapping(path = "/{id}")
    public Optional<Ticket> getTicketById(@PathVariable("id") Long id) {
        return ticketService.getTicketById(id);
    }

    // Видалити квиток за id
    @DeleteMapping(path = "/{id}")
    public void deleteTicketById(@PathVariable("id") Long id) {
        ticketService.deleteTicketById(id);
    }

    // Оновити квиток за id
    @PutMapping(path = "/{id}")
    public Ticket updateTicket(@PathVariable("id") Long id, @NonNull @RequestBody Ticket ticket) {
        return ticketService.updateTicket(id, ticket);
    }

    // Пошук квитків за назвою рейса
    @GetMapping("/search/byTripName")
    public List<Ticket> findByTripName(@RequestParam String tripName) {
        return ticketService.findTicketsByTripName(tripName);
    }

    // Пошук квитків за часом відправлення
    @GetMapping("/search/byDepartureTime")
    public List<Ticket> findByDepartureTime(@RequestParam String departureTime) {
        // парсимо рядок у LocalTime
        LocalTime time = LocalTime.parse(departureTime);
        return ticketService.findTicketsByDepartureTime(time);
    }

    // Пошук квитків за номером автобуса
    @GetMapping("/search/byBusNumber")
    public List<Ticket> findByBusNumber(@RequestParam String busNumber) {
        return ticketService.findTicketsByBusNumber(busNumber);
    }

    // Додатковий метод - видалити всі квитки (якщо потрібно)
    @DeleteMapping("/deleteAll")
    public void deleteAllTickets() {
        ticketService.deleteAllTickets();
    }
}
