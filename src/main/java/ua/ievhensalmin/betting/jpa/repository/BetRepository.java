package ua.ievhensalmin.betting.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ievhensalmin.betting.jpa.entity.Bet;

import java.util.List;

public interface BetRepository extends JpaRepository<Bet, String> {

    List<Bet> findByEventIdAndSettledFalse(String eventId);
}