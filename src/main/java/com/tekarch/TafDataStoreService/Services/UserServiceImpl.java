package com.tekarch.TafDataStoreService.Services;

import com.tekarch.TafDataStoreService.Models.User;
import com.tekarch.TafDataStoreService.Repository.UserServiceRepository;
import com.tekarch.TafDataStoreService.ResourceNotFoundException;
import com.tekarch.TafDataStoreService.Services.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;



@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserServiceRepository userServiceRepository;
    @Override
    public User createUser(User user) {
        return userServiceRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userServiceRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userServiceRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUserById(Long id, User user) {
        //optional helps to avoid null pointer exception when user null
        Optional<User> existinguser=userServiceRepository.findById(id);//retrives user from database
        if(existinguser.isPresent()){  //checks existinguser contains a value
            User actualUser=existinguser.get();//if the user present retrives the actual user object
            //from the optional using get() method
            actualUser.setUsername(user.getUsername());
            System.out.println("Email"+user.getEmail());
            System.out.println("user"+user);
           // updates the username of actualuser with the new value passed in the user parameter
            actualUser.setEmail(user.getEmail());
            actualUser.setPhone(user.getPhone());
            //validate email if required
            if (actualUser.getEmail() == null || actualUser.getEmail().isEmpty()) {
throw new IllegalArgumentException("Email can not be null or empty");
            }
            return userServiceRepository.save(actualUser);
        }else{
            throw new ResourceNotFoundException("user not found with id"+id);
            //get method will throw exception when optional is empty
        }
    }

    @Override
    public void deleteUserById(Long id) {
userServiceRepository.deleteById(id);
    }
}
