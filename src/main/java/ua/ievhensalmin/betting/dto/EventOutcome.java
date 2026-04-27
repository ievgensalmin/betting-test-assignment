package ua.ievhensalmin.betting.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Sports event outcome")
public record EventOutcome(

        @Schema(example = "event-123")
        String eventId,

        @Schema(example = "Real Madrid vs Barcelona")
        String eventName,

        @Schema(example = "team-1")
        String winnerId
) {
}