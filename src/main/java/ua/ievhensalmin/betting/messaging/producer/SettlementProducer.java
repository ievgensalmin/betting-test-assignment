package ua.ievhensalmin.betting.messaging.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class SettlementProducer {

    public void sendSettlement(String betId, String userId, boolean win, BigDecimal amount) {
        log.info("[MOCK ROCKETMQ PRODUCER] Sending settlement: betId={}, userId={}, win={}, amount={}",
                betId, userId, win, amount);
    }
}