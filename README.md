# garage-ticket REST API
Automated Ticketing System For A Garage

### Developed With 
Java-8, SpringBoot, H2 DB

#Description
In this application, we have a garage that can be parked up to 10 slots (consider each slot is 1 unit range) at any given point in time. It is developed an automated ticketing system that allows customers to use a garage without human intervention. When a car enters a garage, garage-ticket give a unique ticket issued to the driver. The ticket issuing process includes documenting the plate and the colour of the car and allocating an available slots to the car before actually handing over a ticket to the driver. When a vehicle holds number of slots with its own width, you have to leave 1 unit slot to next one. The customer should be allocated slot(s) which is nearest to the entry. At the exit the customer returns the ticket which then marks slot(s) they were using as being available.

##Vehicle Types
Car holds 1 slot

Jeep holds 2 slots

Truck holds 4 slots

### Postman Collection Link
https://www.getpostman.com/collections/a29236a082991e5a275a

## Get Status

### Request

`GET /status/`

    curl -L -X GET 'http://localhost:8080/status'

### Response

    34-SO-1988 Black Car

## Park a car

### Request

`POST /park/`

    curl -L -X POST 'http://localhost:8080/park' -H 'Content-Type: application/json' --data-raw '{"plateNumber":"34-SO-1988","colour":"Black","vehicleType":"CAR"}'

### Response

    Allocated 1 slot

## Leave garage

### Request

`DELETE /leave/{id}`

    curl -L -X DELETE 'http://localhost:8080/leave/10'

