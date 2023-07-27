package br.com.dawal.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dawal.util.PropertyManager;

@Service
public class InfosAppService {

	@Autowired
	PropertyManager props;

	public String getAmbiente() {

		String ambiente = "local";
		if (props.getEnviromentPropertyManager("DATABASE_URL").contains("sv_suporte")) {
			ambiente = "Homologa\u00e7\u00e3o";
		}

		if (props.getEnviromentPropertyManager("DATABASE_URL").contains("oraclecloudatcustomer")) {
			ambiente = "Produ\u00e7\u00e3o";
		}
		return ambiente;
	}

	public String getVersion() {

		MavenXpp3Reader reader = new MavenXpp3Reader();
		org.apache.maven.model.Model model = null;

		try {

			if ((new File("pom.xml")).exists()) {
				model = reader.read(new FileReader("pom.xml"));
			} else {

				model = reader.read(new InputStreamReader(new FileInputStream("../pom.xml"), StandardCharsets.UTF_8));
			}

		} catch (Exception e) {

		}

		return model.getVersion();
	}

}
