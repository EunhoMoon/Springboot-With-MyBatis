package com.janek.board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.janek.board.model.User;

@RestController
public class UserController {
	
	private Map<String, User> userMap;
	
	@PostConstruct
	public void init() {
		userMap = new HashMap<>();
		userMap.put("1", new User("1", "홍길동", "111-1111", "서울시 강남구 대치동"));
		userMap.put("2", new User("2", "홍길순", "111-1112", "서울시 강남구 수서동"));
		userMap.put("3", new User("3", "홍길자", "111-1113", "서울시 강남구 일원동"));
	}
	
	@GetMapping("/user/{id}")
	public User getUserInfo(@PathVariable String id) {
		return userMap.get(id);
	}
	
	@GetMapping("/user/all")
	public List<User> getUserList() {
		return new ArrayList<User>(userMap.values());
	}
	
	@PutMapping("/user/{id}")
	public void putUserInfo(@PathVariable String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
		User user = new User(id, name, phone, address);
		userMap.put(id, user);
	}
	
	@PostMapping("/user/{id}")
	public void postUserInfo(@PathVariable String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
		User user = userMap.get(id);
		user.setName(name);
		user.setPhone(phone);
		user.setAddress(address);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUserInfo(@PathVariable String id) {
		userMap.remove(id);
	}
}
