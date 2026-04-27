# Betting Event Processing System

## 🚀 How to Run

1. Build app:
   mvn clean package

2. Start containers:
   docker-compose up --build

3. App will be available at:
   http://localhost:8080/swagger-ui/index.html

## 📌 API

### Publish Event Outcome

POST /events/outcome

Body:
{
"eventId": "event-1",
"eventName": "Team A vs Team B",
"winnerId": "teamA"
}

If event equals:

{
"eventId": "boxing-event-100",
"eventName": "Usyk vs Fury",
"winnerId": "Usyk"
}

- event will be matched against existing in H2 database and message will be logged (run 'docker compose logs app' ):
Bet Bet(betId=bet-1, userId=user-1, eventId=boxing-event-100, marketId=winner-market, predictedWinnerId=Usyk, amount=100.00, settled=false) matched event
- EventOutcome[eventId=boxing-event-100, eventName=Usyk vs Fury, winnerId=Usyk]. Settling.


---

## 🧠 Flow

1. API sends event to Kafka topic `event-outcomes`
2. Kafka consumer receives event
3. Matches bets in DB
4. Sends settlement messages to RocketMQ (mocked)
5. RocketMQ consumer logs settlement and marks bet as settled

---

## 📌 Notes

- RocketMQ is mocked (logs only)
- Easily replace with real producer later
- System is event-driven and scalable