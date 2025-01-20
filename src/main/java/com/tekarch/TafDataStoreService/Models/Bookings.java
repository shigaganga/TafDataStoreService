package com.tekarch.TafDataStoreService.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Entity
@NoArgsConstructor
@Table(name="bookings")
@Data
public class Bookings {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long booking_id;
@ManyToOne(fetch = FetchType.EAGER,optional = false)

//This means that many Booking records can be linked to one User.
//The User object is not fetched immediately when the Booking is loaded from the database.
@JoinColumn(name="user_id",nullable = false)
//Specifies that the user_id column in the Booking table
// is the foreign key linking to the id column in the User table.
   private User user;
   @ManyToOne(fetch = FetchType.EAGER,optional = false)

   @JoinColumn(name="flight_id",nullable = false)
   private Flight flight;
   @Column(name="status")
   private String status;
   @UpdateTimestamp
   @Column(name="created_at")
   private LocalDateTime created_at;
   @UpdateTimestamp
   @Column(name="updated_at")
   private  LocalDateTime updated_at;



}
