# garage-ticket REST API
Automated Ticketing System For A Garage

### Written With 
Java-8, SpringBoot, H2 DB

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

