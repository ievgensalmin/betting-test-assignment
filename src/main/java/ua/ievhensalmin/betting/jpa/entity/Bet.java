package ua.ievhensalmin.betting.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Entity(name = "bets")
@Data
public class Bet {

    @Id
    @Column(name = "bet_id")
    private String betId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "event_id")
    private String eventId;

    @Column(name = "market_id")
    private String marketId;

    @Column(name = "predicted_winner_id")
    private String predictedWinnerId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "settled")
    private boolean settled;


}