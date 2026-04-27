CREATE TABLE bets (
                      bet_id VARCHAR(50) PRIMARY KEY,
                      user_id VARCHAR(50),
                      event_id VARCHAR(50),
                      market_id VARCHAR(50),
                      predicted_winner_id VARCHAR(50),
                      amount DECIMAL(10,2),
                      settled BOOLEAN
);

INSERT INTO bets (
    bet_id,
    user_id,
    event_id,
    market_id,
    predicted_winner_id,
    amount,
    settled
) VALUES (
             'bet-1',
             'user-1',
             'boxing-event-100',
             'winner-market',
             'Usyk',
             100.00,
             false
         );


CREATE TABLE events (
                        event_id VARCHAR(50) PRIMARY KEY,
                        event_name VARCHAR(255),
                        winner_id VARCHAR(50)
);