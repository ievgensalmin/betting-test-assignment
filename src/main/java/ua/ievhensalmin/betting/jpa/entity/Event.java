package ua.ievhensalmin.betting.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "events")
@Data
public class Event {

    @Id
    @Column(name = "event_id")
    private String eventId;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "winner_id")
    private String winnerId;
}