package com.tekarch.TafDataStoreService.Repository;

import com.tekarch.TafDataStoreService.Models.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingsServiceRepository extends JpaRepository< Bookings,Long> {
}
