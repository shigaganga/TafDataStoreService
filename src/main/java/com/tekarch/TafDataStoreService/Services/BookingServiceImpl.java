package com.tekarch.TafDataStoreService.Services;

import com.tekarch.TafDataStoreService.Models.Bookings;
import com.tekarch.TafDataStoreService.Models.Flight;
import com.tekarch.TafDataStoreService.Models.User;
import com.tekarch.TafDataStoreService.Repository.BookingsServiceRepository;
import com.tekarch.TafDataStoreService.Repository.FlightsServiceRepository;
import com.tekarch.TafDataStoreService.Repository.UserServiceRepository;
import com.tekarch.TafDataStoreService.Services.Interface.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);
    @Autowired
private BookingsServiceRepository bookingsServiceRepository;
    @Autowired
    private UserServiceRepository userServiceRepository;
    @Autowired
    private FlightsServiceRepository flightsServiceRepository;
    @Override
    public Bookings createBooking(Bookings bookings) {
        System.out.println("from original booking"+bookings);
        User user = userServiceRepository.findById(bookings.getUser().getUser_id()).orElseThrow(() -> new RuntimeException("User not found"));

        // Ensure that the flight exists
        Flight flight = flightsServiceRepository.findById(bookings.getFlight().getFlight_id()).orElseThrow(() -> new RuntimeException("Flight not found"));

        // Create a new booking object
        Bookings booking = new Bookings();
        booking.setUser(user);  // Set the existing user object
        booking.setFlight(flight);  // Set the existing flight object
        booking.setStatus(bookings.getStatus());
        return bookingsServiceRepository.save(booking);
    }

    @Override
    public List<Bookings> getAllBookings() {
        return bookingsServiceRepository.findAll();
    }

    @Override
    public Bookings getBookingByBookingId(Long bookingId) {
        System.out.print("bookingid"+bookingId);
        return bookingsServiceRepository.findById(bookingId).orElse(null);
    }

    @Override
    public Bookings getBookingByUserId(Long userId) {
        return bookingsServiceRepository.findById(userId).orElse(null);
    }

    @Override
    public void deleteBookingByBookingId(Long bookingId) {
bookingsServiceRepository.deleteById(bookingId);
    }
}
