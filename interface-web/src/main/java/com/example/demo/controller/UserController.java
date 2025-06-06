package com.example.demo.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.request.UpdateDTO;
import com.example.demo.model.request.UserDTO;
import com.example.demo.model.response.UserResponse;
import com.example.demo.services.UserService;



@RestController
@RequestMapping("/api/v1")
public class UserController {
	

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	 private final UserService userService;
	 @Autowired
		public UserController(UserService userService) {
			this.userService=userService;
		}

	 
	    @GetMapping("")
	    public List<UserResponse> getOperacion() {
	    	LOGGER.info("-------entro getOperacion----");
	        return userService.getOperacion();
	    } 
	 
	    @PostMapping("")
	    public UserResponse addOperacion(
	    		@RequestBody UserDTO request) {
	    	LOGGER.info("-------entro addOperacion----");
	        return userService.addOperacion(request);
	    } 
	    
	    @PatchMapping("")
	    public UserResponse updateOperacion(
	    		@RequestBody UpdateDTO request) {
	    	LOGGER.info("-------entro updateOperacion----");
	        return userService.updateOperacion(request);
	    }
    
}
