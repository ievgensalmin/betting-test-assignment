package ua.ievhensalmin.betting.messaging.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ua.ievhensalmin.betting.dto.EventOutcome;

@Service
@RequiredArgsConstructor
public class EventProducer {

    private final KafkaTemplate<String, EventOutcome> kafkaTemplate;

    public void send(EventOutcome event) {
        kafkaTemplate.send("event-outcomes", event.eventId(), event);
    }
}