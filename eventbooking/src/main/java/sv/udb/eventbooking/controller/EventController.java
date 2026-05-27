package sv.udb.eventbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sv.udb.eventbooking.entity.Event;
import sv.udb.eventbooking.service.EventService;

import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "*")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Optional<Event> getEventById(
            @PathVariable Integer id
    ) {
        return eventService.getEventById(id);
    }

    @PostMapping
    public Event createEvent(
            @RequestBody Event event
    ) {
        return eventService.saveEvent(event);
    }

    @PutMapping("/{id}")
    public Event updateEvent(
            @PathVariable Integer id,
            @RequestBody Event event
    ) {

        return eventService.updateEvent(
                id,
                event
        );
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(
            @PathVariable Integer id
    ) {
        eventService.deleteEvent(id);
    }
}