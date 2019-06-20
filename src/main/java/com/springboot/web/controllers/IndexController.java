package com.springboot.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.web.models.Usuario;


@Controller
@RequestMapping("/app")
public class IndexController {
	
	@GetMapping({"/index", "/","", "home"})
	//Model, ModelMap, Map <String,Object>, ModelAndView
	public String index(Model model){
		model.addAttribute("titulo", "Hola Spring Framework! con ModelAndView");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Bernardino");
		usuario.setApellido("Games");
		usuario.setEmail("bernardino@hotmail.com");
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo", "Bienvenido al portal ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model){
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Bernardino","Games","berni@hotmail.com"));
		usuarios.add(new Usuario("Juan","Games","juan@hotmail.com"));
		usuarios.add(new Usuario("Andres","Games","andres@hotmail.com"));
		model.addAttribute("titulo","Listado de usuarios");
		model.addAttribute("usuarios", usuarios);
		
		return "listar";
	}
}	
