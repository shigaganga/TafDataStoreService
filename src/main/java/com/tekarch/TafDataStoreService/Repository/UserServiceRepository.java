package com.tekarch.TafDataStoreService.Repository;

import com.tekarch.TafDataStoreService.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserServiceRepository extends JpaRepository<User,Long> {
}
