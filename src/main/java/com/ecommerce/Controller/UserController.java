package com.ecommerce.Controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Service.UserserviceImpl;
import com.ecommerce.entity.Role;
import com.ecommerce.entity.User;
import com.ecommerce.entity.UserRoles;



@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserserviceImpl userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/")
 public ResponseEntity<?>  addUser(@RequestBody User user) throws Exception{
	 
		
		
		Role role = new Role();
		role.setRoleId(1L);
		role.setRoleName("normal");
		
		UserRoles userrole = new UserRoles();
		userrole.setRoles(role);
		userrole.setUser(user);
		
		
		
		Set<UserRoles> userroles = new HashSet<>();
		
		
		
		
		
	userroles.add(userrole);
	
	
	user.setPassword( passwordEncoder.encode(user.getPassword()));


		return ResponseEntity.ok(this.userService.addUser(user, userroles));
 }
  
	
}


