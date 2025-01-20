package com.tekarch.TafDataStoreService.Controller;

import com.tekarch.TafDataStoreService.Models.Flight;
import com.tekarch.TafDataStoreService.Services.FlightServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("flights")
public class FlightController {
    private static final Logger logger = LogManager.getLogger(FlightController.class);
@Autowired
    FlightServiceImpl flightServiceImpl;
@PostMapping
    public Flight createFlight(@RequestBody Flight flight){
    return flightServiceImpl.addFlight(flight);
}
@GetMapping
    public List<Flight> getAllFlight(){
    return flightServiceImpl.getAllFlights();
}
@GetMapping("/{id}")
    public Flight getFlightWithId(@PathVariable Long id){
    return flightServiceImpl.getFlightById(id);
}
@PutMapping("/{id}")
    public Flight updateFlight(@PathVariable Long id,@RequestBody Flight flight){
    return flightServiceImpl.updateFlightById(id,flight);
}
@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id){
    boolean isDeleted=flightServiceImpl.deleteFlight(id);
    return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
}
