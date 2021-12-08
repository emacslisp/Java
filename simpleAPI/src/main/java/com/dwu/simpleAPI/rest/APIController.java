package com.dwu.simpleAPI.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {
	
	@Value("${server.port}")
	private String serverPort;
	
	@GetMapping("/")
	public String GetDate() {
		return "" + LocalDateTime.now() + " " + serverPort;
	}
}
