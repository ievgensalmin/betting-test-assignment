package ua.ievhensalmin.betting.messaging.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.ievhensalmin.betting.service.BetService;

@Service
@Slf4j
@RequiredArgsConstructor
public class SettlementConsumer {

    private final BetService betService;

    // Simulated consumption
    public void consume(String betId) {
        log.info("[MOCK ROCKETMQ CONSUMER] Settling bet {}", betId);
        betService.markSettled(betId);
    }
}