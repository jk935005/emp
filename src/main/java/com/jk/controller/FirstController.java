package com.jk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
	
	@RequestMapping("/index")
	public String getiIdex() {
		return "String from AWS james";
	}
	
	@GetMapping("/first")
	public String first() {
		return "first";
	}

}
