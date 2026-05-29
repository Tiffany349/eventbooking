package sv.udb.eventbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
=======
<<<<<<< HEAD
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import sv.udb.eventbooking.entity.Event;

import sv.udb.eventbooking.enums.BookingStatus;

import sv.udb.eventbooking.repository.BookingRepository;
<<<<<<< HEAD
=======

import sv.udb.eventbooking.repository.EventRepository;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;

import java.util.Map;

=======
import org.springframework.stereotype.Service;
<<<<<<< HEAD

import sv.udb.eventbooking.entity.Event;
import sv.udb.eventbooking.enums.BookingStatus;

import sv.udb.eventbooking.repository.BookingRepository;
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
import sv.udb.eventbooking.repository.EventRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
<<<<<<< HEAD
=======
=======
import sv.udb.eventbooking.entity.Event;
import sv.udb.eventbooking.repository.EventRepository;

import java.util.List;
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
    @Autowired
    private BookingRepository bookingRepository;

    //
<<<<<<< HEAD
    // LISTAR EVENTOS CON PAGINACION
    //
    public Page<Map<String, Object>> getAllEvents(
            Pageable pageable
    ) {

        Page<Event> eventsPage =
                eventRepository.findAll(pageable);
=======
<<<<<<< HEAD
    // LISTAR EVENTOS
=======
    // LISTAR TODOS
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
    //
    public List<Map<String, Object>> getAllEvents() {

        List<Event> events =
                eventRepository.findAll();
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be

        List<Map<String, Object>> response =
                new ArrayList<>();

<<<<<<< HEAD
        for (Event event : eventsPage.getContent()) {
=======
        for (Event event : events) {
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be

            Integer reserved =
                    bookingRepository
                            .totalReservedTickets(
                                    event.getId_event(),
                                    BookingStatus.CONFIRMED
                            );

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
            if (reserved == null) {

                reserved = 0;
            }

<<<<<<< HEAD
=======
=======
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
            Integer remaining =
                    event.getCapacity() - reserved;

            Map<String, Object> map =
                    new HashMap<>();

            map.put(
                    "id_event",
                    event.getId_event()
            );

            map.put(
                    "title",
                    event.getTitle()
            );

            map.put(
                    "description",
                    event.getDescription()
            );

            map.put(
                    "event_date",
                    event.getEvent_date()
            );

            map.put(
                    "venue",
                    event.getVenue()
            );

            map.put(
                    "capacity",
                    event.getCapacity()
            );

            map.put(
                    "remaining_capacity",
                    remaining
            );

            map.put(
                    "price_per_ticket",
                    event.getPrice_per_ticket()
            );

            response.add(map);
        }

<<<<<<< HEAD
        return new PageImpl<>(
                response,
                pageable,
                eventsPage.getTotalElements()
        );
    }

    //
=======
        return response;
    }

    //
<<<<<<< HEAD
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
    // BUSCAR EVENTO
    //
    public Optional<Event> getEventById(
            Integer id
    ) {
<<<<<<< HEAD
=======
=======
    // BUSCAR POR ID
    //
    public Optional<Event> getEventById(Integer id) {
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be

        return eventRepository.findById(id);
    }

    //
    // CREAR EVENTO
    //
<<<<<<< HEAD
    public Event saveEvent(
            Event event
    ) {
=======
<<<<<<< HEAD
    public Event saveEvent(
            Event event
    ) {
=======
    public Event saveEvent(Event event) {
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be

        return eventRepository.save(event);
    }

    //
    // ACTUALIZAR EVENTO
    //
    public Event updateEvent(
            Integer id,
            Event eventData
    ) {

        Event event =
                eventRepository
                        .findById(id)
                        .orElseThrow();

        event.setTitle(
                eventData.getTitle()
        );

        event.setDescription(
                eventData.getDescription()
        );

        event.setEvent_date(
                eventData.getEvent_date()
        );

        event.setVenue(
                eventData.getVenue()
        );

        event.setCapacity(
                eventData.getCapacity()
        );

        event.setPrice_per_ticket(
                eventData.getPrice_per_ticket()
        );
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
    // LISTAR TODOS
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // BUSCAR POR ID
    public Optional<Event> getEventById(Integer id) {
        return eventRepository.findById(id);
    }

    // CREAR EVENTO
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    // ACTUALIZAR EVENTO
    public Event updateEvent(Integer id, Event eventData) {

        Event event = eventRepository.findById(id).orElseThrow();

        event.setTitle(eventData.getTitle());
        event.setDescription(eventData.getDescription());
        event.setEvent_date(eventData.getEvent_date());
        event.setVenue(eventData.getVenue());
        event.setCapacity(eventData.getCapacity());
        event.setPrice_per_ticket(eventData.getPrice_per_ticket());
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be

        return eventRepository.save(event);
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
    //
    // ELIMINAR EVENTO
    //
    @Transactional
    public void deleteEvent(
            Integer id
    ) {

<<<<<<< HEAD
        bookingRepository.deleteByEventId(id);

=======
        //
        // ELIMINAR BOOKINGS
        //
        bookingRepository.deleteByEventId(id);

        //
        // ELIMINAR EVENTO
        //
=======
<<<<<<< HEAD
    //
    // ELIMINAR EVENTO
    //
    public void deleteEvent(Integer id) {

=======
    // ELIMINAR EVENTO
    public void deleteEvent(Integer id) {
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
        eventRepository.deleteById(id);
    }
}