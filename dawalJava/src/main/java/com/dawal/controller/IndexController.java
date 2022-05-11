package com.dawal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	Double volume = 0D;
	Double volumeTotal =0D;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/fluxo1/{fluxo}")
	public ResponseEntity<Object> teste(@PathVariable("fluxo") String fluxo){
		System.out.println(fluxo + "L/min");
		volume = Double.parseDouble(fluxo)/ 60;
		volumeTotal += volume;
		System.out.println(volumeTotal + "L");
		return null;
	}

}
