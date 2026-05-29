package sv.udb.eventbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD

=======
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
import org.springframework.stereotype.Service;

import sv.udb.eventbooking.entity.Booking;
import sv.udb.eventbooking.entity.Event;
import sv.udb.eventbooking.entity.User;

import sv.udb.eventbooking.enums.BookingStatus;

import sv.udb.eventbooking.repository.BookingRepository;
import sv.udb.eventbooking.repository.EventRepository;
import sv.udb.eventbooking.repository.UserRepository;

import java.math.BigDecimal;
<<<<<<< HEAD

import java.time.LocalDateTime;

=======
import java.time.LocalDateTime;
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
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

<<<<<<< HEAD
        Event event =
                eventRepository.findById(eventId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Evento no encontrado"
                                ));

        User user =
                userRepository.findByUsername(username)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Usuario no encontrado"
                                ));
=======
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
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c

        Integer reserved =
                bookingRepository.totalReservedTickets(
                        eventId,
                        BookingStatus.CONFIRMED
                );

<<<<<<< HEAD
        if (reserved == null) {

            reserved = 0;
        }

=======
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
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

<<<<<<< HEAD
        Booking booking =
                new Booking();
=======
        Booking booking = new Booking();
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c

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

<<<<<<< HEAD
    // TODAS
=======
    // LISTAR TODAS
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
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

<<<<<<< HEAD
        return bookingRepository.findByUser(user);
    }

    // CANCELAR
    public Booking cancelBooking(
            Integer id
=======
        return bookingRepository
                .findByUser(user);
    }

    // CANCELAR SOLO SI ES EL DUEÑO
    public Booking cancelBooking(
            Integer id,
            String username
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
    ) {

        Booking booking =
                bookingRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Reserva no encontrada"
                                ));

<<<<<<< HEAD
=======
        if (!booking.getUser()
                .getUsername()
                .equals(username)) {

            throw new RuntimeException(
                    "No puedes cancelar esta reserva"
            );
        }

>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
        booking.setStatus(
                BookingStatus.CANCELLED
        );

        return bookingRepository.save(
                booking
        );
    }
}