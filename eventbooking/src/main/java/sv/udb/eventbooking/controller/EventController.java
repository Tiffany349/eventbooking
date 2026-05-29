package sv.udb.eventbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import sv.udb.eventbooking.entity.Event;

import sv.udb.eventbooking.service.EventService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

=======
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
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
import java.util.Map;

@RestController
@RequestMapping("/api/events")
@CrossOrigin("*")
<<<<<<< HEAD

@SecurityRequirement(name = "bearerAuth")
=======
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
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
public class EventController {

    @Autowired
    private EventService eventService;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
    //
    // LISTAR
    //
    @GetMapping
<<<<<<< HEAD
    public Page<Map<String, Object>> getAllEvents(
            Pageable pageable
    ) {

        return eventService.getAllEvents(
                pageable
        );
=======
    public List<Map<String, Object>> getAllEvents() {

        return eventService.getAllEvents();
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
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
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
    @PostMapping
    public Event createEvent(
            @RequestBody Event event
    ) {
<<<<<<< HEAD

        return eventService.saveEvent(
                event
        );
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1

        return eventService.saveEvent(event);
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
    }

    //
    // ACTUALIZAR
    //
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
        return eventService.saveEvent(event);
    }

>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
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
<<<<<<< HEAD
    //
    // ELIMINAR
    //
=======
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
    @DeleteMapping("/{id}")
    public void deleteEvent(
            @PathVariable Integer id
    ) {
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
        eventService.deleteEvent(id);
    }
}