Project goal:
Create and orchestrate a service for replacing a debitcard, using Spring Boot.


MoSCoW:
- Must: 
  - User gets verified before being able to request a new card.
  - The application waits for external authorisation.
  - If the user is eligible, the replacement request gets fulfilled by issuing a new debit card and setting a new end date for the current debit card.
  - Endpoints in place for the replacement flow.
  - Interaction possible with a database for data ‘persistence’.
  - Response to client based on outcome fail or success.

- Should:
  - AllowedActions is determined by the AuthorizationLevel.
  - Exception handling and server response code is based on where the process fails.

- Could:
  - Adjust for leap year(s) when setting an end date for a new card, using start date + 5 years.
  - Use enums for Card arrangement types.

- Won't:
  - External authorization mock with async.


Software stack:
- Java
- Spring Boot
- Hibernate
- JPA
- Maven
- Swagger
- H2
- JUnit


  Technical goals:
- Getting to know Spring (Boot) and using the tool to set up a service.
- Integrating a service with a database.


  Personal goals:
- Working the project according to a plan --> Planning through (weekly) sprints and daily tasks, all reasoned from the endgoals.
- Ask for help at the right time --> Try to tackle the problem myself for at least 15 minutes, before asking for help, but only for a maximum of 30 minutes. Or park the problem for another time.
- KISS: Keep It Simple, Stupid!

