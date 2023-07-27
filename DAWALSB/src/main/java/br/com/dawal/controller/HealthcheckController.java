package br.com.dawal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dawal.util.ResponseEntityUtil;

@Controller
@RequestMapping("/healthcheck")
public class HealthcheckController {

	@GetMapping()
	public ResponseEntity<?> healthcheck(){
		return ResponseEntityUtil.defaultResponse("WORKING");
	}

}
