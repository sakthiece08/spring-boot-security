/**
 * 
 */
package com.teqmonic.springsecurity.configuration;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


/**
 * 
 */
@Configuration
@EnableWebSecurity
public class CustomSecurityConfiguration {
	
	
	/**
	 * /api/admin --> should have ROLE ADMIN
	 * /api/user  -> should have ROLE USER
	 * /api/ -> no auth
	 * /api/ad -> authenticated
	 * 
	 */
	@SuppressWarnings("deprecation")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		//.securityMatcher("/api/**")
				.authorizeHttpRequests(requests -> requests.requestMatchers("/api/admin").hasRole("ADMIN"))
				.authorizeHttpRequests(requests -> requests.requestMatchers("/api/user").hasRole("USER"))
				.authorizeHttpRequests(
						requests -> requests.requestMatchers("login", "/api/").permitAll().anyRequest().authenticated())
				.formLogin(withDefaults());

		return http.build(); 	
	}
	
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService());
        return provider;
        
    }
	
	@Bean
	public UserDetailsService userDetailsService() {
		// below password details can be passed externally as well, so it cab be hided in the source code
		UserDetails user = User.builder().username("user").password("{noop}password").roles("USER").build();
		UserDetails admin = User.builder().username("admin").password("{noop}password").roles("USER", "ADMIN").build();
		return new InMemoryUserDetailsManager(user, admin);
	}
	

	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
		Map<String, PasswordEncoder> encoders = new HashMap<>();
		// encoders.put("bcrypt", new BCryptPasswordEncoder());
		encoders.put("noop", NoOpPasswordEncoder.getInstance()); // only for testing purpose
		return new DelegatingPasswordEncoder("noop", encoders);
	}

}
