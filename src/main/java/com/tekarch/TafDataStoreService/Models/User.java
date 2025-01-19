package com.tekarch.TafDataStoreService.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name="username",unique = true,nullable = false)
    private String username;
    @Column(name="email",nullable = false)
    private String email;
    @Column(name="phone")
    private String phone;
   @CreationTimestamp
   @Column(name="created_at")
    private LocalDateTime createdAt;
   @UpdateTimestamp
    @Column(name="updated_at")
    private LocalDateTime updatedAt;
}
