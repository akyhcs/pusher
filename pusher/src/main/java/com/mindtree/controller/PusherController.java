package com.mindtree.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.controller.service.PusherService;

@RestController
public class PusherController 
{
	@Autowired
	private PusherService pusherService;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/notification")
	public String hitPusher()
	{
		
		return pusherService.hitPusher();
	}
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/configure-Pusher")
	public Map configurePusher(@RequestBody Map<String, Object> map)
	{

		return pusherService.pusherConfiguration(map);
	}
}
