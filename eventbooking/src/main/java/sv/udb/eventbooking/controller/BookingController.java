package sv.udb.eventbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import sv.udb.eventbooking.entity.Booking;
import sv.udb.eventbooking.service.BookingService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;
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

        Integer eventId = body.get("eventId");

        Integer quantity = body.get("quantity");

        String username =
                authentication.getName();

        return bookingService.createBooking(
                eventId,
                username,
                quantity
        );
    }

    // LISTAR TODAS
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
    }
}