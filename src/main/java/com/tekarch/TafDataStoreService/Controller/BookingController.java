package com.tekarch.TafDataStoreService.Controller;

import com.tekarch.TafDataStoreService.Models.Bookings;
import com.tekarch.TafDataStoreService.Services.BookingServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private static final Logger logger = LogManager.getLogger(BookingController.class);
    @Autowired
    BookingServiceImpl bookingServiceImpl;
    @PostMapping
    public Bookings createBooking(@RequestBody Bookings bookings){
        return bookingServiceImpl.createBooking(bookings);
    }
    @GetMapping
    public List<Bookings> getAllBookings(){
        return bookingServiceImpl.getAllBookings();
    }
    @GetMapping("/{bookingId}")
    public Bookings getBookingBybookingId(@PathVariable Long bookingId){
        return bookingServiceImpl.getBookingByBookingId(bookingId);
    }
    @GetMapping("users/{userId}")
    public Bookings getBookingByuserId(@PathVariable Long userId){
        return bookingServiceImpl.getBookingByUserId(userId);
    }
    @DeleteMapping("/{bookingId}")
    public ResponseEntity<String> deleteBookingBybookingId(@PathVariable Long bookingId){
        if(bookingServiceImpl.getBookingByBookingId(bookingId).getBooking_id().equals(0L)){
            bookingServiceImpl.deleteBookingByBookingId(bookingId);
            return ResponseEntity.ok("Booking deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
}
