package br.com.dawal.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.dawal.dto.ChamadaBEDTO;
import br.com.dawal.service.ChamadaBEService;

@CrossOrigin
@Controller
public class ChamadaBEController {

	@Autowired
	ChamadaBEService chamadaBEService;

	@PostMapping("/chamadaBE")
	public Object chamadaBE(@RequestBody ChamadaBEDTO chamadaBEDTO) {
		return chamadaBEService.processa(chamadaBEDTO);
	}

	@PostMapping("/chamadaBEDownload")
	public ResponseEntity<?> chamadaBEDownload(@RequestBody ChamadaBEDTO chamadaBEDTO) throws IOException {
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=" + chamadaBEDTO.getAcao());
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		
		ResponseEntity<?> resp = ResponseEntity.ok().headers(headers)
				.body(new InputStreamResource(chamadaBEService.chamadaBEDownload(chamadaBEDTO)));

		return resp;
	}

}
