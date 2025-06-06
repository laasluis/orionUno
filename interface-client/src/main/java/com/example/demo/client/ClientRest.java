package com.example.demo.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.request.UpdateDTO;
import com.example.demo.model.request.UserDTO;
import com.example.demo.model.response.UserResponse;



@FeignClient(name = "examn-web", url = "http://localhost:8090/api/db")
public interface ClientRest {

	@RequestMapping(method = RequestMethod.POST,  produces = "application/json")
	UserResponse saveOperacion(@RequestBody UserDTO request);

	@RequestMapping(method = RequestMethod.POST, value = "/update",  produces = "application/json")
	UserResponse updateOperacion(@RequestBody UpdateDTO request);

	@RequestMapping(method = RequestMethod.GET,  produces = "application/json")
	List<UserResponse> getOperacion();
	
}