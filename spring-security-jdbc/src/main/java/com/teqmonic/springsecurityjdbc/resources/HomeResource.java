package com.teqmonic.springsecurityjdbc.resources;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
	
	
	@GetMapping("/user")
	public String user() {
		return "<h1>Welcome User!</h1>";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/admin")
	public String admin() {
		return "<h1>Welcome Admin!</h1>";
	}

}
