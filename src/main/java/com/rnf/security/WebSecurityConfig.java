//package com.rnf.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.rnf.security.jwt.AuthEntryPointJwt;
//import com.rnf.security.jwt.AuthTokenFilter;
//import com.rnf.service.user.UserService;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(
//		// securedEnabled = true,
//		// jsr250Enabled = true,
//		prePostEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private UserService userDetailsService;
//	
//	@Autowired
//	private AuthEntryPointJwt unauthorizedHandler;
//	
//	@Bean
//	public AuthTokenFilter authenticationJwtTokenFilter() {
//		return new AuthTokenFilter();
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return PasswordEncoderProvider.getInstance().getPasswordEncoder();
//	}
//	
//	@Override
//	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//		authenticationManagerBuilder.userDetailsService(this.userDetailsService)
//			.passwordEncoder(this.passwordEncoder());
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.cors().and().csrf().disable()
//		.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//		.authorizeRequests()
//		//.antMatchers("/api/entretiens/init").permitAll()
//		.antMatchers("/api/auth/**").permitAll()
//		.antMatchers("/api/test/**").permitAll()
//		.antMatchers("/api/test/testsave").permitAll()
//		/*
//		.antMatchers("/api/demande/**").permitAll()
//		.antMatchers("/api/prestataire/**").permitAll()
//		.antMatchers("/api/piece/**").permitAll()
//		.antMatchers("/api/agent/**").permitAll()
//		.antMatchers("/api/organigramme/**").permitAll()
//		.antMatchers("/api/marque/**").permitAll()
//		.antMatchers("/api/modele/**").permitAll()
//		.antMatchers("/api/vehicule/**").permitAll()
//		*/
//		.anyRequest().authenticated();
//
//		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//	}
//	
//	/**
//	 * https://stackoverflow.com/questions/52243774/consider-defining-a-bean-of-type-org-springframework-security-authentication-au
//	 * Raha tsy izany tsy mety atao @autowired AuthenticationManager ilay ao amin'ny AuthRestController
//	 * Migration 1.5 -> 2.0
//	 */
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//	    return super.authenticationManagerBean();
//	}
//}
