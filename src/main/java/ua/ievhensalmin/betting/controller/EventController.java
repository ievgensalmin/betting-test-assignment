package ua.ievhensalmin.betting.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.ievhensalmin.betting.dto.EventOutcome;
import ua.ievhensalmin.betting.service.EventService;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
@Tag(name = "Event API", description = "Publish sports event outcomes")
@Slf4j
public class EventController {

    private final EventService eventService;

    @Operation(summary = "Publish event outcome")
    @PostMapping("/outcome")
    public ResponseEntity<Void> publish(@RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Event outcome payload",
            required = true
    ) EventOutcome outcome) {
        log.info("Received outcome {}", outcome);
        eventService.processEvent(outcome);

        return ResponseEntity.ok().build();
    }
}