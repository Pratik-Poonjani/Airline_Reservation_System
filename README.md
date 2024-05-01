# Airline_Reservation_System

##   Overview
The Airline Reservation System is a web-based application that allows users to search for flights, make reservations, and manage their bookings. It provides an intuitive interface for users to browse available flights, select seats, and complete their booking process.

## Features

__Flight Search and Booking:__
 - User-friendly interface for searching flights based on various parameters like destination, departure date, number of passengers, class preference, etc.
 - Real-time availability of flights with updated pricing and seat availability.
 - Integration with global distribution systems (GDS) to access a wide range of flight options.
Ability to book one-way, round-trip, or multi-city flights.

__Seat Selection:__
 - Interactive seat map displaying available seats and their corresponding prices.
 - Option for passengers to select their preferred seats, taking into account factors like window/aisle preference, legroom, etc.

__Fare Management:__
 - Dynamic pricing capabilities to adjust fares based on factors like demand, seasonality, and competitor pricing.
 - Support for different fare classes (e.g., economy, business, first class) with varying privileges and pricing structures.
  
__Passenger Management:__
 - Secure passenger profile management for storing personal information, frequent flyer details, and travel preferences.
 - Ability to manage bookings, including making changes to flight itineraries, adding special requests, and requesting upgrades.

__Payment Integration:__
 - Seamless integration with payment gateways to facilitate secure online transactions.
 - Support for multiple payment methods including credit/debit cards, digital wallets, and alternative payment options.

__Reservation Confirmation and Ticketing:__
 - Instant confirmation of bookings with e-ticket issuance.
 - Automated email/SMS notifications for booking confirmation, itinerary updates, and flight reminders.

__Check-In Management:__
 - Online check-in functionality allowing passengers to check in before arriving at the airport.
 - Integration with airport systems for automated check-in kiosks and mobile check-in.

__Baggage Handling:__
 - Information on baggage allowance and fees.
 - Option to purchase additional baggage allowance during the booking process.

__Flight Status and Updates:__
 - Real-time flight status updates including departure/arrival times, delays, cancellations, and gate changes.
 - Automated notifications for flight status changes sent to passengers via email, SMS, or mobile app.

__Loyalty Programs:__
 - Integration with frequent flyer programs to accumulate and redeem miles/points.
 - Personalized offers and promotions for loyalty program members.

__Reporting and Analytics:__
 - Comprehensive reporting capabilities for analyzing booking trends, revenue performance, and customer behavior.
 - Business intelligence tools to generate insights for strategic decision-making.

__Accessibility and Multilingual Support:__
 - Accessibility features for passengers with disabilities, such as screen reader compatibility and wheelchair assistance requests.
 - Multilingual support to cater to a diverse customer base with language preferences.

__Security and Compliance:__
 - Compliance with industry regulations and data protection standards such as GDPR, PCI DSS, and IATA regulations.
 - Robust security measures to safeguard sensitive passenger information and payment data.

__Integration Capabilities:__
 - APIs and web services for seamless integration with third-party systems such as hotel booking platforms, car rental services, and travel insurance providers.


## Technologies Used
 - __Java:__ Core programming language for backend development.
 - __Servlet:__ Handles HTTP requests and responses, providing dynamic web content.
 - __JSP (JavaServer Pages):__ Used for generating dynamic web pages, embedding Java code within HTML.
 - __JDBC (Java Database Connectivity):__ Java API for connecting and executing SQL queries against a database.
 - __HTML/CSS:__ Frontend design and styling.
 - __JavaScript:__ Client-side scripting for interactive features and form validation.
 - __MySQL:__ Relational database management system for storing flight details, user information, and bookings.


## Installation and Setup

#### Clone the Repository:

 - Setup
```
git clone https://github.com/Pratik-Poonjani/Airline_Reservation_System.git
```

#### Database Setup:
 - Install MySQL and create a new database named airline_db.
 - Import the provided SQL schema (airline_db.sql) to create tables and populate initial data.

#### Configure Database Connection:
 - Open src/main/resources/db.properties file.
 - Update the database URL, username, and password to match your MySQL configuration.

#### Build and Run:
- Open the project in your preferred Java IDE (IntelliJ).
 - Build and run the project.


## Usage

#### 1. User Registration:
 - New users can register by providing their details such as name, email, and password.

#### 2. Flight Search:
 - Users can search for flights by entering origin, destination, departure date, and number of passengers.

#### 3. Flight Booking:
 - Select a flight from the search results and proceed to book seats for the desired number of passengers.
 - Enter passenger details and complete the booking process by making payment.

#### 4. Admin Dashboard:
 - Admins can log in to the admin panel to manage flights, view bookings, and perform administrative tasks.



## DATABASE
~~~
CREATE database airline_table;

use airline_table;

CREATE TABLE login(username varchar(20), password varchar(20));
select * from login;

insert into login values ('keyur','098765');
insert into login values ('nilesh','opqrst');
select * from login;

CREATE TABLE `manageflight` (
  `flightcode` varchar(30) NOT NULL,
  `source` varchar(30) NOT NULL,
  `destination` varchar(30) NOT NULL,
  `takeoff` varchar(30) NOT NULL,
  `noofseat` varchar(30) NOT NULL);

insert into manageflight values ('Fl-101', 'akjsjdh', 'andka', 'kjdn', '22');
select * from manageflight;

CREATE TABLE `managepassenger` (
  `name` varchar(20) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `nationality` varchar(20) NOT NULL,
  `passportnumber` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL);

insert into managepassenger values('Keyur', 'MALE', 'INDIAN', 'IND92861', '9831234031');
select * from managepassenger;

CREATE TABLE `ticketbooking` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `flightcode` varchar(20) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `passportnumber` varchar(20) NOT NULL,
  `amount` varchar(20) NOT NULL,
  `nationality` varchar(20) NOT NULL); 
select * from ticketbooking;
~~~
