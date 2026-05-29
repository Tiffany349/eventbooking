package sv.udb.eventbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
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
<<<<<<< HEAD

import java.time.LocalDateTime;

=======
<<<<<<< HEAD

import java.time.LocalDateTime;

=======
import java.time.LocalDateTime;
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
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
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
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
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
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
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be

        Integer reserved =
                bookingRepository.totalReservedTickets(
                        eventId,
                        BookingStatus.CONFIRMED
                );

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
        if (reserved == null) {

            reserved = 0;
        }

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
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
<<<<<<< HEAD
        Booking booking =
                new Booking();
=======
<<<<<<< HEAD
        Booking booking =
                new Booking();
=======
        Booking booking = new Booking();
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be

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
<<<<<<< HEAD
    // TODAS
=======
<<<<<<< HEAD
    // TODAS
=======
    // LISTAR TODAS
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
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
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
        return bookingRepository.findByUser(user);
    }

    // CANCELAR
    public Booking cancelBooking(
            Integer id
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
        return bookingRepository
                .findByUser(user);
    }

    // CANCELAR SOLO SI ES EL DUEÑO
    public Booking cancelBooking(
            Integer id,
            String username
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
    ) {

        Booking booking =
                bookingRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Reserva no encontrada"
                                ));

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
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
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
        booking.setStatus(
                BookingStatus.CANCELLED
        );

        return bookingRepository.save(
                booking
        );
    }
}