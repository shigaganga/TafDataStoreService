package com.tekarch.TafDataStoreService.Models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Bookings {
   private Long bookingId;
   private Long userId;
   private Long flightId;
   private String status;
   private LocalDateTime created_at;
   private  LocalDateTime updated_at;


}
