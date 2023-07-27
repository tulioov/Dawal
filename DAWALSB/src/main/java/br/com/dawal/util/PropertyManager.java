package br.com.dawal.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class PropertyManager {
	
	@Autowired
    private Environment environment;
	
	public String getEnviromentPropertyManager(String chave) {
		
		String value = System.getenv("chave");
		
		if(value == null) {
			return environment.getProperty(chave);
		}
		
		return value;
			
	}
	
}


