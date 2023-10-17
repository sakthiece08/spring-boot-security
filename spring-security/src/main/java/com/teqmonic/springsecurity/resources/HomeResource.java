package com.teqmonic.springsecurity.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeResource {
	
	@GetMapping("/")
	public String publicPage() {
		return "<h1>Welcome home!</h1>";
	}
	
	@GetMapping("/ad")
	public String ad() {
		return "<h1>Welcome Ad page!</h1>";
	}
	
	@GetMapping("/user")
	public String user() {
		return "<h1>Welcome User!</h1>";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "<h1>Welcome Admin!</h1>";
	}

}
