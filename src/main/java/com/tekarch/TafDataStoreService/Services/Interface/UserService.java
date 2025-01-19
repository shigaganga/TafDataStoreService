package com.tekarch.TafDataStoreService.Services.Interface;

import com.tekarch.TafDataStoreService.Models.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUserById(Long id,User user);
    void deleteUserById(Long id);

}
