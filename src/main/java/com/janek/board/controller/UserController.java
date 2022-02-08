package com.janek.board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.janek.board.mapper.UserProfileMapper;
import com.janek.board.model.UserProfile;

@RestController
public class UserController {
	
	private UserProfileMapper mapper;
	
	public UserController(UserProfileMapper mapper) {
		this.mapper = mapper;
	}
	
	@GetMapping("/user/{id}")
	public UserProfile getUserInfo(@PathVariable String id) {
		return mapper.getUserInfo(id);
	}
	
	@GetMapping("/user/all")
	public List<UserProfile> getUserList() {
		return mapper.getUserList();
	}
	
	@PutMapping("/user/{id}")
	public void putUserInfo(@PathVariable String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
		mapper.putUserInfo(id, name, phone, address);
	}
	
	@PostMapping("/user/{id}")
	public void postUserInfo(@PathVariable String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
		mapper.postUserInfo(id, name, phone, address);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUserInfo(@PathVariable String id) {
		mapper.deleteUserInfo(id);
	}
}
