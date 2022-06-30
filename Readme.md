# Hotel Reservation Application
This is a java application that enables record keeping of a day-to-day hotel operations, such as making a reservation, storing customer info, etc.

### Main Components of the App
* CLI for the User Interface
* Java API (Business Logic)
* Java Collections (In-Memory Storage)

These components are well separated. So, anyone who wish
to use this as a framework can make modifications in the 
appropriate components.

### Application Architecture
UI Components -->> Resources -->> Services -->> Data Models

This architecture support modularization and decoupling.
For loose coupling, I recommend you to use Dependency Injection.
