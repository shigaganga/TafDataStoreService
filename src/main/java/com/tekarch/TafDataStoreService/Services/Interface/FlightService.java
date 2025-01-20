package com.tekarch.TafDataStoreService.Services.Interface;

import com.tekarch.TafDataStoreService.Models.Flight;

import java.util.List;

public interface FlightService {
    Flight addFlight(Flight flight);
    List<Flight> getAllFlights();
    Flight getFlightById(Long id);
    Flight updateFlightById(Long id,Flight flight);
    boolean deleteFlight(Long id);
}
