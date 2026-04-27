package ua.ievhensalmin.betting.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import ua.ievhensalmin.betting.dto.EventOutcome;
import ua.ievhensalmin.betting.jpa.entity.Event;
import ua.ievhensalmin.betting.jpa.repository.EventRepository;
import ua.ievhensalmin.betting.messaging.producer.EventProducer;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {

    private final EventProducer producer;
    private final EventRepository eventRepository;

    public void processEvent(EventOutcome outcome) {
        Event event = getEvent(outcome);

        eventRepository.save(event);

        producer.send(outcome);
        log.info("{} sent to Kafka", outcome);
    }

    private static @NonNull Event getEvent(EventOutcome outcome) {
        Event event = new Event();
        event.setEventId(outcome.eventId());
        event.setEventName(outcome.eventName());
        event.setWinnerId(outcome.winnerId());
        return event;
    }
}