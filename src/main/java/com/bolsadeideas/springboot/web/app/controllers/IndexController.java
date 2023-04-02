package com.bolsadeideas.springboot.web.app.controllers;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;


@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;	
	
	@GetMapping({"/index", "/", "/home" })
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Jorge");
		usuario.setApellido("Mayora");
		usuario.setEmail("jorge@correo.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {	
	
		model.addAttribute("titulo", textoListar);
		// Cuando los datos esten solo en la vista listar
		/*model.addAttribute("usuarios", usuarios);
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Jorge","Mayora","jorge@correo.com"));
		usuarios.add(new Usuario("Susana","Hernandez","susana@correo.com"));
		usuarios.add(new Usuario("Gregorio","Garcia","gregorio@correo.com"));
		usuarios.add(new Usuario("Jean","Colmenares","jean@correo.com")); */
		
		return "listar";
	}
	
	// Cuando los datos queremos que esten multiples vista
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Jorge","Mayora","jorge@correo.com"));
		usuarios.add(new Usuario("Susana","Hernandez","susana@correo.com"));
		usuarios.add(new Usuario("Gregorio","Garcia","gregorio@correo.com"));
		usuarios.add(new Usuario("Jean","Colmenares","jean@correo.com"));
		return usuarios;
	}
	
}
