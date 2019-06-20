package com.springboot.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	@GetMapping("/")
	public String index(){
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(name="texto", required=false) String texto,  Model model) {
		model.addAttribute("resultado","El texto es la siguiente:" + texto);
		return "params/ver";
	}
	
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer num,  Model model) {
		model.addAttribute("resultado","El texto es la siguiente:'" + saludo +"' el numero '" + num + "'");
		return "params/ver";
	}
	
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request , Model model) {
		String saludo = request.getParameter("saludo");
		Integer num = null;
		try {
			num = Integer.parseInt(request.getParameter("num"));
		} catch (Exception e) {
			num = 0;
		}
		model.addAttribute("resultado","El texto es la siguiente:'" + saludo +"' el numero '" + num + "'");
		return "params/ver";
	}

}
