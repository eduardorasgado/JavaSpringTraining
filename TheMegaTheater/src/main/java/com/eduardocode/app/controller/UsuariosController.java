package com.eduardocode.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eduardocode.app.model.Perfil;
import com.eduardocode.app.model.Usuario;
import com.eduardocode.app.service.IPerfilesService;
import com.eduardocode.app.service.IUsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	// instancia inyectada para poder hacer encriptaciones
	// con spring security
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private IUsuariosService usuariosService;
	
	@Autowired
	private IPerfilesService perfilesService;
	
	@GetMapping("/index")
	public String index(Model model) {
		List<Usuario> usuarios = new LinkedList<Usuario>();
		
		model.addAttribute("usuarios", usuarios);
		return "usuarios/listUsuarios";
	}
	
	@GetMapping("/create")
	public String create(@ModelAttribute Usuario usuario, Model model) {
		//
		 List<String> perfiles = new LinkedList<>();
		 perfiles.add("EDITOR");
		 perfiles.add("GERENTE");
		 
		model.addAttribute("perfiles", perfiles);
		return "auth/formRegister";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Usuario usuario, 
			@RequestParam("perfil") String perfil,
			RedirectAttributes attributes) {
		
		System.out.println(usuario);
		System.out.println(perfil);
		
		// guardar los objetos en la base de datos
		String tempPass = usuario.getPassword(); // pass en texto plano
		String cryptPass = encoder.encode(tempPass); // encriptando la pass
		
		usuario.setPassword(cryptPass);
		
		usuariosService.insert(usuario);
		
		// definimos el rol
		Perfil tempPerfil = new Perfil();
		tempPerfil.setUsername(usuario.getUsername());
		tempPerfil.setPerfil(perfil);
		
		perfilesService.insert(tempPerfil);
		
		attributes.addFlashAttribute("message", "Se ha guardado el usuario exitosamente");
		return "redirect:/usuarios/index";
	}
	
	@GetMapping("/demo-bcript")
	public String encriptar() {
		//
		String password = "mari123";
		String password2 = "gabagabahey";
		
		String encriptacion = encoder.encode(password);
		String encriptacion2 = encoder.encode(password2);
		
		System.out.println("password: " + password);
		System.out.println("encriptacion: " + encriptacion);
		System.out.println("password 2: " + password2);
		System.out.println("encriptacion 2: " + encriptacion2);
		
		return "home";
	}
}
