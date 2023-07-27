package br.com.dawal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.dawal.service.LoginService;
import br.com.dawal.util.PropertyManager;


@CrossOrigin
@Controller
@RequestMapping("/")
public class PaginasController {

	@Autowired
	PropertyManager props;
	
	@Autowired
	LoginService loginService;

	@RequestMapping("/")
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("message", "Seja bem vindo ");
		model.setViewName("home");
		return model;
	}

	@GetMapping("/loginPage")
	public String homePrincipal(Model tela){
		return loginService.logando(tela, null);
	}
	
	@PostMapping("/loginPage")
	public String homePrincipal2(Model tela, @RequestAttribute(value = "error", required = false) String error,
	        @RequestParam(value = "logout", required = false) String logout,
	        @RequestParam(value = "sessionTimeout", required = false) String sessionTimeout){

		return loginService.logando(tela, error);
	}
	
	@PostMapping("/infoatlas/loginPage")
	public String homePrincipalWebogic(Model tela, @RequestAttribute(value = "error", required = false) String error,
	        @RequestParam(value = "logout", required = false) String logout,
	        @RequestParam(value = "sessionTimeout", required = false) String sessionTimeout){

		return loginService.logando(tela, error);
	}
	
	@GetMapping("/cadastroMunicipio")
	public String cadastroMunicipio(Model tela) {
		tela.addAttribute("urlBackEnd", props.getEnviromentPropertyManager("URL_BACKEND"));
		return "cadastroMunicipio";
	}
	
	@GetMapping("/responsabilidadeSinal")
	public String responsabilidadeSinal(Model tela) {
		tela.addAttribute("urlBackEnd", props.getEnviromentPropertyManager("URL_BACKEND"));
		return "responsabilidadeSinal";
	}
}