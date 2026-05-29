package sv.udb.eventbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.udb.eventbooking.entity.Event;
import sv.udb.eventbooking.enums.BookingStatus;

import sv.udb.eventbooking.repository.BookingRepository;
import sv.udb.eventbooking.repository.EventRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private BookingRepository bookingRepository;

    //
    // LISTAR TODOS
    //
    public List<Map<String, Object>> getAllEvents() {

        List<Event> events =
                eventRepository.findAll();

        List<Map<String, Object>> response =
                new ArrayList<>();

        for (Event event : events) {

            Integer reserved =
                    bookingRepository
                            .totalReservedTickets(
                                    event.getId_event(),
                                    BookingStatus.CONFIRMED
                            );

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

        return response;
    }

    //
    // BUSCAR POR ID
    //
    public Optional<Event> getEventById(Integer id) {

        return eventRepository.findById(id);
    }

    //
    // CREAR EVENTO
    //
    public Event saveEvent(Event event) {

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

        return eventRepository.save(event);
    }

    //
    // ELIMINAR EVENTO
    //
    public void deleteEvent(Integer id) {

        eventRepository.deleteById(id);
    }
}