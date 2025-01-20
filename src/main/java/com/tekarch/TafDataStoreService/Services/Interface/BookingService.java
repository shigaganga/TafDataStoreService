package com.tekarch.TafDataStoreService.Services.Interface;

import com.tekarch.TafDataStoreService.Models.Bookings;
import com.tekarch.TafDataStoreService.Models.Flight;

import java.util.List;

public interface BookingService {
    Bookings createBooking(Bookings bookings);
    List<Bookings> getAllBookings();
    Bookings getBookingByBookingId(Long bookingId);
    Bookings getBookingByUserId(Long userId);
    void deleteBookingByBookingId(Long BookingId);
}
