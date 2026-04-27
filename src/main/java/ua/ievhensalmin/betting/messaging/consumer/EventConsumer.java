package ua.ievhensalmin.betting.messaging.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ua.ievhensalmin.betting.dto.EventOutcome;
import ua.ievhensalmin.betting.messaging.producer.SettlementProducer;
import ua.ievhensalmin.betting.service.BetService;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventConsumer {

    private final BetService betService;
    private final SettlementProducer settlementProducer;

    @KafkaListener(topics = "event-outcomes", groupId = "betting-group")
    public void consume(EventOutcome event) {
        log.info("Received event outcome: {}", event);

        var bets = betService.findByEventId(event.eventId());

        bets.forEach(bet -> {
            boolean win = bet.getPredictedWinnerId().equals(event.winnerId());

            settlementProducer.sendSettlement(
                bet.getBetId(),
                bet.getUserId(),
                win,
                bet.getAmount()
            );
        });
    }
}