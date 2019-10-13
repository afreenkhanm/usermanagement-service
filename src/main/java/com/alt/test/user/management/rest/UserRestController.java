/**
 * 
 */
package com.alt.test.user.management.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/v1/users")
public class UserRestController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId) {
		User user = userService.getUserById(userId);
		return ResponseEntity.ok().body(user);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @RequestBody User userToUpdate) {
		final User updatedUser = userService.updateUser(userId, userToUpdate);
		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
		userService.deleteUser(userId);
	}

}
