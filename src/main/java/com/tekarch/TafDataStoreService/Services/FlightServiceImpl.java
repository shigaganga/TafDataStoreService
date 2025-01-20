package com.tekarch.TafDataStoreService.Services;

import com.tekarch.TafDataStoreService.Models.Flight;
import com.tekarch.TafDataStoreService.Repository.FlightsServiceRepository;
import com.tekarch.TafDataStoreService.ResourceNotFoundException;
import com.tekarch.TafDataStoreService.Services.Interface.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    private static final Logger logger = LoggerFactory.getLogger(FlightServiceImpl.class);
    @Autowired
    private FlightsServiceRepository flightServiceRepository;
    @Override
    public Flight addFlight(Flight flight) {
        return flightServiceRepository.save(flight);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightServiceRepository.findAll();
    }

    @Override
    public Flight getFlightById(Long id) {
        return flightServiceRepository.findById(id).orElse(null);
    }

    @Override
    public Flight updateFlightById(Long id, Flight flight) {

        Optional<Flight> existingflight=flightServiceRepository.findById(id);
        if(existingflight.isPresent()){
            Flight actualFlight=existingflight.get();
            actualFlight.setFlight_number(flight.getFlight_number());
            actualFlight.setDeparture(flight.getDeparture());
            actualFlight.setArrival(flight.getArrival());
            actualFlight.setArrival_time(flight.getArrival_time());
            actualFlight.setDeparture_time(flight.getDeparture_time());
            actualFlight.setPrice(flight.getPrice());
            actualFlight.setAvailable_seats(flight.getAvailable_seats());
            //validation for important fields
            if(actualFlight.getFlight_number()==null || actualFlight.getFlight_number().isEmpty()){
                throw new IllegalArgumentException("Flight number cannot be null or empty");
            }
            if(actualFlight.getDeparture()==null || actualFlight.getDeparture().isEmpty()){
                throw new IllegalArgumentException("Departure location cannot be null or empty");
            }
            if (actualFlight.getArrival() == null || actualFlight.getArrival().isEmpty()) {
                throw new IllegalArgumentException("Arrival location cannot be null or empty");
            }
            if (actualFlight.getDeparture_time()== null) {
                throw new IllegalArgumentException("Departure time cannot be null");
            }
            if (actualFlight.getArrival_time() == null) {
                throw new IllegalArgumentException("Arrival time cannot be null");
            }
            if (actualFlight.getPrice() == null || actualFlight.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Price must be greater than zero");
            }
            if (actualFlight.getAvailable_seats() < 0) {
                throw new IllegalArgumentException("Available seats cannot be negative");
            }
 return flightServiceRepository.save(actualFlight);//save and return updated flight
        }else{
            throw new ResourceNotFoundException("Flight not found with id"+ id);
        }
    }

    @Override
    public boolean deleteFlight(Long id) {
        logger.info("Deleting flight with ID: {}", id);
        Flight flight= flightServiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flight with ID " + id + " not found."));
        flightServiceRepository.delete(flight);
        return true;
    }
}
