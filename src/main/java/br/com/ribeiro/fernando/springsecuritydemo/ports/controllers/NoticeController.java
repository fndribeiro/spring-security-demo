package br.com.ribeiro.fernando.springsecuritydemo.ports.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ControllersURIs.NOTICE)
public class NoticeController {
	
	@GetMapping
	public String getNotices(String input) {
		return "OK";
	}
	
}
