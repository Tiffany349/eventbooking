package sv.udb.eventbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.udb.eventbooking.entity.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {
}