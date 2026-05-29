package sv.udb.eventbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;

import org.springframework.transaction.annotation.Transactional;

import sv.udb.eventbooking.entity.Booking;

import sv.udb.eventbooking.entity.User;

=======
<<<<<<< HEAD

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import sv.udb.eventbooking.entity.Booking;
import sv.udb.eventbooking.entity.User;

=======
import org.springframework.data.jpa.repository.Query;
import sv.udb.eventbooking.entity.Booking;
import sv.udb.eventbooking.entity.User;
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
import sv.udb.eventbooking.enums.BookingStatus;

import java.util.List;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
public interface BookingRepository
        extends JpaRepository<Booking, Integer> {

    //
<<<<<<< HEAD
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
=======
    // RESERVAS POR USUARIO
    //
    List<Booking> findByUser(User user);

    //
    // TOTAL RESERVADO
    //
=======
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    // LISTAR RESERVAS DE UN USUARIO
    List<Booking> findByUser(User user);

    // SUMAR ENTRADAS CONFIRMADAS
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
    @Query("""
            SELECT COALESCE(SUM(b.quantity),0)
            FROM Booking b
            WHERE b.event.id_event = :eventId
            AND b.status = :status
            """)
<<<<<<< HEAD
    Integer totalReservedTickets(
            @Param("eventId") Integer eventId,
            @Param("status") BookingStatus status
    );
=======
    Integer totalReservedTickets(Integer eventId, BookingStatus status);
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
}