package br.com.dawal.controller;

import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.dawal.dto.DawalDTO;
import br.com.dawal.util.ResponseEntityUtil;
import br.com.dawal.util.RetornoDTO;

@Controller
@RequestMapping("/teste")
public class TestesController {

	@GetMapping("{msg}")
	public ResponseEntity<?> healthcheck(@PathVariable("msg") String msg) {
		System.out.println("Teste realizado: " + msg);
		return ResponseEntityUtil.defaultResponse("WORKING");
	}

	@GetMapping("")
	public ResponseEntity<?> healthcheck() {
		System.out.println("Teste realizad sem msg ");
		return ResponseEntityUtil.defaultResponse("WORKING");
	}

	@GetMapping("NULL")
	public ResponseEntity<?> testenull() {
		System.out.println("null ");
		return ResponseEntityUtil.defaultResponse("WORKING");
	}

	@PostMapping(value="")
	public @ResponseBody ResponseEntity<RetornoDTO> salvar(@RequestBody DawalDTO dawalDTO) {
		
		System.out.println("status luz navegacao: "+dawalDTO.getLuzNavegacao());
		System.out.println("status bateria: "+dawalDTO.getBateria01());
		
		return ResponseEntityUtil.defaultResponse("OK");
	}

}
