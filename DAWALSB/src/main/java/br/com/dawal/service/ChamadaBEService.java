package br.com.dawal.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.dawal.dto.ChamadaBEDTO;

@Service
public class ChamadaBEService {

	public Object processa(ChamadaBEDTO chamadaBEDTO) {
		
		RestTemplate restTemplate = new RestTemplate();

		if (chamadaBEDTO.getAcao().equals("POST")) {
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<String> entity = new HttpEntity<String>(chamadaBEDTO.getObjetoPOST().toString(), headers);
			
			ResponseEntity<Object> response = restTemplate.exchange(chamadaBEDTO.getUrl(), HttpMethod.POST, entity,
					Object.class);
			return response;
		}

		else if (chamadaBEDTO.getAcao().equals("GET")) {
			ResponseEntity<Object> response = restTemplate.getForEntity(chamadaBEDTO.getUrl(), Object.class);
			return response;
		}

		else if (chamadaBEDTO.getAcao().equals("DOWNLOAD")) {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
			HttpEntity<String> entity = new HttpEntity<>(headers);
			ResponseEntity<byte[]> response = restTemplate.exchange(chamadaBEDTO.getUrl(), HttpMethod.GET, entity,
					byte[].class);
			ResponseEntity.ok().headers(headers).body(response);
			return response;
		}

		else {
			new Exception("Erro na chamada do ao serviço.");
			return null;
		}
	}

	public InputStream chamadaBEDownload(ChamadaBEDTO chamadaBEDTO) throws IOException {
		
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		int timeout = 300000000;
        factory.setConnectTimeout(timeout);
        factory.setReadTimeout(timeout);
		
		RestTemplate restTemplate = new RestTemplate(factory);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		ResponseEntity<Resource> response = restTemplate.exchange(chamadaBEDTO.getUrl(), HttpMethod.GET, entity,
				Resource.class);
		
		return response.getBody().getInputStream();
	}
}
