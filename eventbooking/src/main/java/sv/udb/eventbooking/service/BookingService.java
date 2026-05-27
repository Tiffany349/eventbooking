package sv.udb.eventbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.udb.eventbooking.entity.Booking;
import sv.udb.eventbooking.entity.Event;
import sv.udb.eventbooking.entity.User;

import sv.udb.eventbooking.enums.BookingStatus;

import sv.udb.eventbooking.repository.BookingRepository;
import sv.udb.eventbooking.repository.EventRepository;
import sv.udb.eventbooking.repository.UserRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    // CREAR RESERVA
    public Booking createBooking(
            Integer eventId,
            String username,
            Integer quantity
    ) {

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Evento no encontrado"
                        ));

        User user = userRepository
                .findByUsername(username)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Usuario no encontrado"
                        ));

        Integer reserved =
                bookingRepository.totalReservedTickets(
                        eventId,
                        BookingStatus.CONFIRMED
                );

        Integer available =
                event.getCapacity() - reserved;

        if (quantity > available) {

            throw new RuntimeException(
                    "No hay cupos disponibles"
            );
        }

        BigDecimal total =
                event.getPrice_per_ticket()
                        .multiply(
                                BigDecimal.valueOf(quantity)
                        );

        Booking booking = new Booking();

        booking.setEvent(event);

        booking.setUser(user);

        booking.setQuantity(quantity);

        booking.setTotal_amount(total);

        booking.setBooking_date(
                LocalDateTime.now()
        );

        booking.setStatus(
                BookingStatus.CONFIRMED
        );

        return bookingRepository.save(
                booking
        );
    }

    // LISTAR TODAS
    public List<Booking> getAllBookings() {

        return bookingRepository.findAll();
    }

    // MIS RESERVAS
    public List<Booking> getBookingsByUsername(
            String username
    ) {

        User user =
                userRepository
                        .findByUsername(username)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Usuario no encontrado"
                                ));

        return bookingRepository
                .findByUser(user);
    }

    // CANCELAR SOLO SI ES EL DUEÑO
    public Booking cancelBooking(
            Integer id,
            String username
    ) {

        Booking booking =
                bookingRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Reserva no encontrada"
                                ));

        if (!booking.getUser()
                .getUsername()
                .equals(username)) {

            throw new RuntimeException(
                    "No puedes cancelar esta reserva"
            );
        }

        booking.setStatus(
                BookingStatus.CANCELLED
        );

        return bookingRepository.save(
                booking
        );
    }
}