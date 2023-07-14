Doel project:
Middels Spring Boot en ING Baker een service opzetten voor het replacen van een debitcard
Endpoints aanmaken en organiseren voor de replace flow van een debitcard, middels ING Baker.

MoSCoW:
- Must: 
  - User gets verified before being able to request a new card.
  - The application waits for external authorisation.
  - If the user is eligible, the replacement request gets fulfilled by issuing a new debit card and setting a new end date for the current debit card.
  - Endpoints in place for the replacement flow.
  - Interaction possible with a database for data ‘persistence’.

- Should:
  - AllowedActions is determined by the AuthorizationLevel.
  - Error handling and server response code is based on where the process fails.

- Won't:
  - Adjust for leap years when setting an end date for a new card, using start date + 5 years.

Software stack:
- Java
- Spring Boot
- Hibernate
- JPA
- Swagger
- H2
- Maven
- JUnit

Persoonlijk leerdoel:
- Planmatig werken aan een project. --> planning per sprint (week) en planning per dag. Alles geredeneerd vanuit een/het einddoel.
- Op het juiste moment hulp vragen. --> min. 15 minuten, max. 30 minuten. of parkeren voor een later moment.


Technisch leerdoel:
- Bekend raken met Spring Boot en het opzetten van een service middels deze tool.
- ~~Bekend raken met ING Baker (https://github.com/ing-bank/baker)~~
- Integratie met een database.