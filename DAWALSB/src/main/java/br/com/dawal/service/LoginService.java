package br.com.dawal.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.dawal.dto.UsuarioDTO;
import br.com.dawal.exception.CustomErrorException;
import br.com.dawal.util.PropertyManager;
import br.com.dawal.util.RetornoDTO;

@Service
public class LoginService {
	
	@Autowired
	PropertyManager props;
	
	public String logando(Model tela, String error){
		
		if (error != null) {
			tela.addAttribute("error", error);
        }
		
		tela.addAttribute("ambiente", getAmbiente());
		tela.addAttribute("versao", getVersion());

		return "loginPage";
	}
	
	private String getAmbiente() {
		
		String url = props.getEnviromentPropertyManager("URL_BACKEND")+"ambiente/";
		
		URI uri = null;
		try {
			uri = new URI(url);
		
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
			
			Gson gson = new Gson();
			RetornoDTO retorno = gson.fromJson(response.getBody(), RetornoDTO.class);
			
			return retorno.getResponse().toString();
		
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro no retorno do serviço do infoAtlas";
		}
	}
	
	private String getVersion() {
		
		Package mainPackage = LoginService.class.getPackage();
		String version = mainPackage.getImplementationVersion();
		if(version != null) {
			return version;
		}
		
		MavenXpp3Reader reader = new MavenXpp3Reader();
		org.apache.maven.model.Model model = null;
		
		try {
			if ((new File("pom.xml")).exists()) {
				 model = reader.read(new FileReader("pom.xml"));
				 return model.getVersion();
			}else {
				model = reader.read(new InputStreamReader(new FileInputStream("../pom.xml"), StandardCharsets.UTF_8));
				return model.getVersion();
			}
		} catch (Exception e) {
			return "Erro ao encontrar versão do infoAtlas";
		}
	}
	
	
	public String login(UsuarioDTO dto) throws Exception {

		return postAD(dto);
	}
	
	private String postAD(UsuarioDTO dto) throws Exception {

		String urlAD = props.getEnviromentPropertyManager("urlAD");
		
		URL url = new URL(urlAD);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();

		try {

			String authorization = calculateAuthentication(dto.getLogin(),
					dto.getPassword().getBytes(StandardCharsets.UTF_8));

			http.setRequestMethod("POST");
			http.setDoOutput(true);
			http.setRequestProperty("Authorization", authorization);
			http.setRequestProperty("Content-Type", "application/json");
			http.setRequestProperty("Content-Length", "0");

			BufferedReader br = null;
			
			if (http.getResponseCode() == 200) {
				br = new BufferedReader(new InputStreamReader(http.getInputStream(), "UTF-8"));
				String strCurrentLine;
				while ((strCurrentLine = br.readLine()) != null) {
					return strCurrentLine;
				}
			}

			throw new CustomErrorException(HttpStatus.BAD_REQUEST, "Erro no serviço de login");

		} catch (Exception e) {
			throw new CustomErrorException(HttpStatus.BAD_REQUEST, "Erro no sistema AD para login");
		} finally {
			http.disconnect();
		}
	}

	private String calculateAuthentication(final String username, final byte[] password) {
		final byte[] prefix = (username + ":").getBytes(StandardCharsets.UTF_8);
		final byte[] usernamePassword = new byte[prefix.length + password.length];
		System.arraycopy(prefix, 0, usernamePassword, 0, prefix.length);
		System.arraycopy(password, 0, usernamePassword, prefix.length, password.length);
		return "Basic " + Base64.getEncoder().encodeToString(usernamePassword);
	}

}
