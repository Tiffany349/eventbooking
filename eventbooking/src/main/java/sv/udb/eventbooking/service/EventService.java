package sv.udb.eventbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.udb.eventbooking.entity.Event;
import sv.udb.eventbooking.repository.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

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

        return eventRepository.save(event);
    }

    // ELIMINAR EVENTO
    public void deleteEvent(Integer id) {
        eventRepository.deleteById(id);
    }
}