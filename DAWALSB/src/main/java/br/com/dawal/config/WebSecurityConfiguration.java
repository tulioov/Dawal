//package br.com.globo.atlas.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import br.com.globo.atlas.service.AuthProviderService;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
//	@Autowired
//	AuthProviderService authProviderService;
//	
//	
//	@Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.authenticationProvider(authProviderService);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    
//    @Bean
//    public AuthenticationFailureHandler authenticationFailureHandler() {
//        return new CustomAuthenticationFailureHandler();
//    }
//    
//    @Override
//	public void configure(WebSecurity web) throws Exception {
//    	
//    	web.ignoring().mvcMatchers("/resources/**", "/static/**", "/css/**", "/externo/**",  "/js/**", "/img/**", "/icon/**", "/favicon.ico/", "/error/");
//		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/externo/**",  "/js/**", "/img/**", "/icon/**", "/favicon.ico/", "/error/");
//		web.ignoring().antMatchers(HttpMethod.POST, "/chamadaBE", "/chamadaBEDownload");
//	}
//    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/loginPage").permitAll()
//                .antMatchers("/infoatlas/loginPage").permitAll()
//                .antMatchers("/healthcheck").permitAll()
//                .antMatchers("/usuario").hasRole("USUARIO")
//                .anyRequest().authenticated()
//                .and()
//            .exceptionHandling()
//                .accessDeniedPage("/negado")
//                .and()
//            .formLogin()
//                .loginPage("/loginPage")
//                .usernameParameter("login")
//                .passwordParameter("password")
//                .failureHandler(authenticationFailureHandler())
//                .permitAll()
//                .and()
//            .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/loginPage")
//                .deleteCookies("JSESSIONID")
//                .invalidateHttpSession(true);
//    }
//    
//}
package br.com.dawal.config;

