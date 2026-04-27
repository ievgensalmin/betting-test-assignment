package ua.ievhensalmin.betting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ievhensalmin.betting.jpa.entity.Bet;
import ua.ievhensalmin.betting.jpa.repository.BetRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BetService {

    private final BetRepository betRepository;

    public List<Bet> findByEventId(String eventId) {
        return betRepository.findByEventIdAndSettledFalse(eventId);
    }

    public void markSettled(String betId) {
        betRepository.findById(betId).ifPresent(bet -> {
            bet.setSettled(true);
            betRepository.save(bet);
        });
    }
}