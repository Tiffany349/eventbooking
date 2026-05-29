package sv.udb.eventbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

=======
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

=======
import org.springframework.web.bind.annotation.*;
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
import sv.udb.eventbooking.entity.Event;
import sv.udb.eventbooking.service.EventService;

import java.util.List;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
import java.util.Map;

@RestController
@RequestMapping("/api/events")
@CrossOrigin("*")
<<<<<<< HEAD
=======
=======
import java.util.Optional;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "*")
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
public class EventController {

    @Autowired
    private EventService eventService;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
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
<<<<<<< HEAD
=======
=======
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

>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
    @PostMapping
    public Event createEvent(
            @RequestBody Event event
    ) {
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1

        return eventService.saveEvent(event);
    }

    //
    // ACTUALIZAR
    //
<<<<<<< HEAD
=======
=======
        return eventService.saveEvent(event);
    }

>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
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

<<<<<<< HEAD
    //
    // ELIMINAR
    //
=======
<<<<<<< HEAD
    //
    // ELIMINAR
    //
=======
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
    @DeleteMapping("/{id}")
    public void deleteEvent(
            @PathVariable Integer id
    ) {
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
        eventService.deleteEvent(id);
    }
}