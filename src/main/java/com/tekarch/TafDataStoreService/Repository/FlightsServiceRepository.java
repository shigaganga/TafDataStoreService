package com.tekarch.TafDataStoreService.Repository;

import com.tekarch.TafDataStoreService.Models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightsServiceRepository extends JpaRepository<Flight,Long> {
}
