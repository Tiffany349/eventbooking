package sv.udb.eventbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sv.udb.eventbooking.entity.Booking;
import sv.udb.eventbooking.entity.User;
import sv.udb.eventbooking.enums.BookingStatus;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    // LISTAR RESERVAS DE UN USUARIO
    List<Booking> findByUser(User user);

    // SUMAR ENTRADAS CONFIRMADAS
    @Query("""
            SELECT COALESCE(SUM(b.quantity),0)
            FROM Booking b
            WHERE b.event.id_event = :eventId
            AND b.status = :status
            """)
    Integer totalReservedTickets(Integer eventId, BookingStatus status);
}