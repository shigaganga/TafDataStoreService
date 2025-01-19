package com.tekarch.TafDataStoreService.Controller;

import com.tekarch.TafDataStoreService.Models.User;
import com.tekarch.TafDataStoreService.Services.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);
    @Autowired
    UserServiceImpl userServiceImpl;
    @PostMapping
    public User createUser(@RequestBody User user){
        return userServiceImpl.createUser(user);
    }
    @GetMapping
    public List<User> getAllUsers(){
      return userServiceImpl.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUsrById(@PathVariable Long id){
        return userServiceImpl.getUserById(id);
    }
    @PutMapping("/{id}")
    public User UpdateUser(@PathVariable Long id,@RequestBody User user){
        return userServiceImpl.updateUserById(id,user);
    }
   /* @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
         userServiceImpl.deleteUserById(id);

    }*/
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        if(!userServiceImpl.getUserById(id).getUserId().equals(0L)) {
            //0L might be used as a default value to represent a non-existent or invalid AccountId.
            userServiceImpl.deleteUserById(id);
            return ResponseEntity.ok("User deleted successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
    }
    // Exception Handling
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleExceptions(Exception e) {
        logger.error("Exception occurred: {}", e.getMessage());
        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
