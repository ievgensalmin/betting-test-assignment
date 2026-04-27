package ua.ievhensalmin.betting.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ievhensalmin.betting.jpa.entity.Event;

public interface EventRepository extends JpaRepository<Event, String> {
}