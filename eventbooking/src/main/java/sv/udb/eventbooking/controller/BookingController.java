package sv.udb.eventbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD

import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

import sv.udb.eventbooking.entity.Booking;

=======
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import sv.udb.eventbooking.entity.Booking;
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
import sv.udb.eventbooking.service.BookingService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;
<<<<<<< HEAD

=======
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
import java.util.Map;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // CREAR RESERVA
    @PostMapping
    public Booking createBooking(
            @RequestBody Map<String, Integer> body,
            Authentication authentication
    ) {

<<<<<<< HEAD
        Integer eventId =
                body.get("eventId");

        Integer quantity =
                body.get("quantity");
=======
        Integer eventId = body.get("eventId");

        Integer quantity = body.get("quantity");
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c

        String username =
                authentication.getName();

        return bookingService.createBooking(
                eventId,
                username,
                quantity
        );
    }

<<<<<<< HEAD
    // TODAS
=======
    // LISTAR TODAS
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
    @GetMapping
    public List<Booking> getAllBookings() {

        return bookingService.getAllBookings();
    }

    // MIS RESERVAS
    @GetMapping("/my")
    public List<Booking> myBookings(
            Authentication authentication
    ) {

        String username =
                authentication.getName();

        return bookingService
                .getBookingsByUsername(
                        username
                );
    }

<<<<<<< HEAD
    // CANCELAR
    @DeleteMapping("/{id}")
    public Booking cancelBooking(
            @PathVariable Integer id
    ) {

        return bookingService.cancelBooking(id);
=======
    // CANCELAR SOLO MIS RESERVAS
    @DeleteMapping("/{id}")
    public Booking cancelBooking(
            @PathVariable Integer id,
            Authentication authentication
    ) {

        String username =
                authentication.getName();

        return bookingService.cancelBooking(
                id,
                username
        );
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
    }
}