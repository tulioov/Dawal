package br.com.dawal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dawal.service.InfosAppService;
import br.com.dawal.util.ResponseEntityUtil;

@CrossOrigin
@Controller
@RequestMapping("/infosApp")
public class InfosAppController {

	@Autowired
	InfosAppService infosAppService;
	
	@GetMapping()
	public ResponseEntity<?> healthcheck(){
		return ResponseEntityUtil.defaultResponse("WORKING");
	}

	@GetMapping("/ambiente")
    public ResponseEntity<?> getAmbiente() {
    	return ResponseEntityUtil.defaultResponse(infosAppService.getAmbiente());
	}
	
	@GetMapping("/version")
    public ResponseEntity<?> gatVersion() {
    	return ResponseEntityUtil.defaultResponse(infosAppService.getVersion());
	}

}
