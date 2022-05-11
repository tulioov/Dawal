package com.dawal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dawal.service.SensorNivelService;

@Controller
public class SesonsoresNivelController {
	@Autowired
	SensorNivelService sensorNivelService;

	@RequestMapping({ "/cxCasa/{nivel}" })
	public ResponseEntity<Object> setNivelCxCasa(@PathVariable("nivel") int nivel) {
		this.sensorNivelService.setNivelCxCasa(nivel);
		return null;
	}

	@RequestMapping({ "/getNivelCxCasa" })
	public ResponseEntity<Object> getNivelCxCasa() {
		return this.sensorNivelService.getNivelCxCasa();
	}

	@RequestMapping({ "/cxCisterna/{nivel}" })
	public ResponseEntity<Object> setNivelCxCisterna(@PathVariable("nivel") int nivel) {
		this.sensorNivelService.setNivelCxCisterna(nivel);
		return null;
	}

	@RequestMapping({ "/getNivelCxCisterna" })
	public ResponseEntity<Object> getNivelCxCisterna() {
		return this.sensorNivelService.getNivelCxCisterna();
	}
}
