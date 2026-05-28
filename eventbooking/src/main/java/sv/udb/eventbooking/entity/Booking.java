package sv.udb.eventbooking.entity;

import jakarta.persistence.*;
import lombok.Data;
import sv.udb.eventbooking.enums.BookingStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_booking;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private Integer quantity;

    private BigDecimal total_amount;

    private LocalDateTime booking_date;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;
}