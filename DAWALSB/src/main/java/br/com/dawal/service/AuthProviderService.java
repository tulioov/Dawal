//package br.com.globo.atlas.service;
//
//import java.util.Collections;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.AuthenticationServiceException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import br.com.globo.atlas.dto.UsuarioDTO;
//
//@Component
//public class AuthProviderService implements AuthenticationProvider {
//
//	@Autowired
//	LoginService loginService;
//
//	public Authentication authenticate(Authentication auth) throws AuthenticationException {
//		
//		validLogin(auth);
//
//		String login = auth.getName();
//		String senha = auth.getCredentials().toString();
//		UsuarioDTO usuarioDTO = new UsuarioDTO(login, senha);
//
//		String response = null;
//
//		try {
//			response = loginService.login(usuarioDTO);
//			
//		} catch (Exception e) {
//			throw new AuthenticationServiceException("Erro no serviço de login", e);
//		}
//
//		if (response == null) {
//			throw new AuthenticationServiceException("Erro no retorno do serviço de login");
//		}
//
//		if (!"Ok".equals(response)) {
//			throw new UsernameNotFoundException(response);
//		}
//		return new UsernamePasswordAuthenticationToken(login, senha, Collections.emptyList());
//	}
//	
//	private void validLogin(Authentication auth) {
//		
//		if(auth.getName().isEmpty()) {
//			throw new AuthenticationServiceException("Campo login inválido ou vazio");
//		}
//		if(auth.getCredentials().toString().isEmpty()){
//			throw new AuthenticationServiceException("Campo senha inválido ou vazio");
//		}
//		
//	}
//
//
//	@Override
//	public boolean supports(Class<?> auth) {
//		return auth.equals(UsernamePasswordAuthenticationToken.class);
//	}
//}


