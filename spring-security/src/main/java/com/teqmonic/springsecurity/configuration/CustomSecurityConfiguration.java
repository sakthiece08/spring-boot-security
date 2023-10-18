/**
 * 
 */
package com.teqmonic.springsecurity.configuration;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


/**
 * 
 */
@Configuration
@EnableWebSecurity
public class CustomSecurityConfiguration {

	
	@Bean
	InMemoryUserDetailsManager users() {
		// below password details can be passed from externally as well, so clear text credentials can be hided in the source code
		UserDetails user = User.builder().username("user").password("{noop}password").roles("USER").build();
		UserDetails admin = User.builder().username("admin").password("{noop}password").roles("USER", "ADMIN").build();
		return new InMemoryUserDetailsManager(user, admin);
	}

    /**
     * /api/admin --> should have ROLE ADMIN
     * /api/user  -> should have ROLE USER
     * /api/ -> no auth
     * /api/ad -> authenticated
     * 
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		//.securityMatcher("/api/**")
			.authorizeHttpRequests(requests -> requests.requestMatchers("/api/admin").hasRole("ADMIN"))
			.authorizeHttpRequests(requests -> requests.requestMatchers("/api/user").hasRole("USER"))
			.authorizeHttpRequests(
				 requests -> requests.requestMatchers("login", "/api/").permitAll().anyRequest().authenticated())
			.formLogin(withDefaults());

		return http.build(); 	
	}

}
