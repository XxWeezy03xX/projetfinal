package org.formation.restController;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class AuthController 
{
	@GetMapping("/login")
	public String login(Model model)
	{
		return "/login";
	}

}
