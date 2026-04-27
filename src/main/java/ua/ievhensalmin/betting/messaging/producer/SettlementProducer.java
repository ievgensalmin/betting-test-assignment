package ua.ievhensalmin.betting.messaging.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.ievhensalmin.betting.messaging.consumer.SettlementConsumer;

import java.math.BigDecimal;

@Service
@Slf4j
@RequiredArgsConstructor
public class SettlementProducer {

    private final SettlementConsumer settlementConsumer;

    public void sendSettlement(String betId, String userId, boolean win, BigDecimal amount) {
        log.info("[MOCK ROCKETMQ PRODUCER] Sending settlement: betId={}, userId={}, win={}, amount={}",
                betId, userId, win, amount);

        // Simulate RocketMQ delivery/consumption so the bet gets settled end-to-end.
        settlementConsumer.consume(betId);
    }
}