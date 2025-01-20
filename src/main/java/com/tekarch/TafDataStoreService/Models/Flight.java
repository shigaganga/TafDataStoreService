package com.tekarch.TafDataStoreService.Models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@Table(name="flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flight_id;
    @Column(name="flight_number",unique = true)
    private String flight_number;
    @Column(name="departure")
    private String departure;
    @Column(name="arrival")
    private String arrival;
    @Column(name="departure_time")
    private LocalDateTime departure_time;
    @Column(name="arrival_time")
    private LocalDateTime arrival_time;
    @Column(name="price")
    private BigDecimal price;
    @Column(name="available_seats")
    private int available_seats;
    @Column(name="created_at",updatable = false)
    private LocalDateTime created_at;
    @Column(name="updated_at")
    private LocalDateTime updated_at;
    @PrePersist
    protected void onCreate() {
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updated_at = LocalDateTime.now();
    }
}
