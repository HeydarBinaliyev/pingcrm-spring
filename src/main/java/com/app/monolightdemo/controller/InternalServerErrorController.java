package com.app.monolightdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/500")
public class InternalServerErrorController {

	@GetMapping
	public ResponseEntity<HttpStatus> error(){
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
