package com.hospital.hms.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.hospital.hms.service.CustomSuccessHandler;
import com.hospital.hms.service.CustomUserDetailsService;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	@Autowired
	CustomSuccessHandler customSuccessHandler;
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(c -> c.disable())

				// Define authorization requests using requestMatchers
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/adminpage", "/doctors", "/doctor/new", "/doctor/update", "/doctor/delete","/patients","/patient/delete","/feedbacks").hasAuthority("admin")
						.requestMatchers("/userpage","/feedback/new").hasAuthority("user")
						.requestMatchers("/patient/new","patients/update","patients/update").hasAnyAuthority("user","admin")
						.requestMatchers("/registration", "/reset", "/css/**").permitAll()
						.anyRequest().authenticated())
						.exceptionHandling(e -> e
			            .accessDeniedPage("/errors"))
				// Configure form login
				.formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login")
						.successHandler(customSuccessHandler).permitAll()
						.failureUrl("/login?error=true"))

				// Configure logout
				.logout(logout -> logout.invalidateHttpSession(true).clearAuthentication(true)
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
						.permitAll());
			
		return http.build();
	}
    	
	@Autowired
	public void configure (AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}
	

}

