package sv.udb.eventbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sv.udb.eventbooking.entity.Event;
import sv.udb.eventbooking.service.EventService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/events")
@CrossOrigin("*")
public class EventController {

    @Autowired
    private EventService eventService;

    //
    // LISTAR
    //
    @GetMapping
    public List<Map<String, Object>> getAllEvents() {

        return eventService.getAllEvents();
    }

    //
    // BUSCAR POR ID
    //
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(
            @PathVariable Integer id
    ) {

        return eventService
                .getEventById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //
    // CREAR
    //
    @PostMapping
    public Event createEvent(
            @RequestBody Event event
    ) {

        return eventService.saveEvent(event);
    }

    //
    // ACTUALIZAR
    //
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

    //
    // ELIMINAR
    //
    @DeleteMapping("/{id}")
    public void deleteEvent(
            @PathVariable Integer id
    ) {

        eventService.deleteEvent(id);
    }
}