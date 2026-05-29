package sv.udb.eventbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;

import org.springframework.transaction.annotation.Transactional;

import sv.udb.eventbooking.entity.Booking;

import sv.udb.eventbooking.entity.User;

import sv.udb.eventbooking.enums.BookingStatus;

import java.util.List;

public interface BookingRepository
        extends JpaRepository<Booking, Integer> {

    //
    // TOTAL RESERVADO
    //
    @Query("""
        SELECT COALESCE(SUM(b.quantity),0)
        FROM Booking b
        WHERE b.event.id_event = :eventId
        AND b.status = :status
    """)
    Integer totalReservedTickets(
            Integer eventId,
            BookingStatus status
    );

    //
    // BUSCAR POR USUARIO
    //
    List<Booking> findByUser(
            User user
    );

    //
    // ELIMINAR BOOKINGS DE EVENTO
    //
    @Modifying
    @Transactional
    @Query(
            value = """
            DELETE FROM bookings
            WHERE event_id = :eventId
        """,
            nativeQuery = true
    )
    void deleteByEventId(
            Integer eventId
    );
}