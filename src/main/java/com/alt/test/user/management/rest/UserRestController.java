/**
 * 
 */
package com.alt.test.user.management.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alt.test.user.management.model.User;
import com.alt.test.user.management.service.UserService;

/**
 * @author Afreen
 *
 */

@RestController
@RequestMapping("/api/v1")
public class UserRestController {

	 @Autowired
	 private UserService userService;
	 

	  @GetMapping("/users")
	  public List<User> getAllUsers() {
	    return userService.getAllUsers();
	  }
	  
	  @PostMapping("/users")
	  public User addUser(@RequestBody User user) {
	    return userService.addUser(user);
	  }

	  @GetMapping("/users/{id}")
	  public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId) {
	    User user = userService.getUserById(userId).get();
	    return ResponseEntity.ok().body(user);
	  }
	  	  
	 
	  @DeleteMapping("/user/{id}")
	  public void deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
	    userService.deleteUser(userId);
	  }
  
}
