package com.eduardocode.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String index(Model model, Pageable page) {
		Page<Usuario> usuarios = usuariosService.getAll(page);
		
		// los roles se pasan debido a la relacion one to one entre
		// usuario y perfil
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("pageSize", usuarios.getTotalPages());
		
		return "usuarios/listUsuarios";
	}
	
	@GetMapping("/create")
	public String create(@ModelAttribute Usuario usuario) {
		return "auth/formRegister";
	}
	
	@PostMapping("/create")
	public String save(@ModelAttribute Usuario usuario, 
			//@RequestParam("perfil") String perfil,
			@RequestParam("passwordProve") String passwordProve,
			RedirectAttributes attributes, 
			BindingResult results,
			Model model) {
		
		if(results.hasErrors()) {
			
			return "auth/formRegister";
		}
		
		// PASSWORD -------------
		// guardar los objetos en la base de datos
		String tempPass = usuario.getPassword(); // pass en texto plano
		
		if(!passwordProve.equals(tempPass)) {
			// en caso de que las pass no coincidan
			//attributes.addFlashAttribute("error", "Las contrasenas no coinciden");
			//return "redirect:/usuarios/create";
			// no hacemos un redirect porque con ello no se renderizan los valores pasados
			// de la instancia usuario
			model.addAttribute("error", "Las contrasenas no coinciden");
			return "auth/formRegister";
		}
		String cryptPass = encoder.encode(tempPass); // encriptando la pass
		usuario.setPassword(cryptPass);
		
		// PERFIL ------------------
		// definimos el rol de acuerdo a la relacion usuario-perfil	
		//System.out.println(usuario);
		//System.out.println(tempPerfil);
		Perfil tempPerfil = usuario.getPerfil();
		tempPerfil.setUsername(usuario.getUsername());
		usuario.setPerfil(tempPerfil);
		
		perfilesService.insert(usuario.getPerfil());
		usuariosService.insert(usuario);
		
		
		attributes.addFlashAttribute("message", "Se ha guardado el usuario exitosamente");
		return "redirect:/usuarios/index";
	}
	
	@GetMapping("/edit/{id}")
	public String update(@PathVariable("id") int idUsuario,
			Model model) {
		//Usuario usuario = 
		return "auth/formRegister"; 
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int idUsuario) {
		// eliminar un usuario
		return "redirect:/usuarios/index";
	}
	
	@ModelAttribute("perfiles")
	public List<String> includeProfiles() {
		List<String> perfiles = new LinkedList<>();
		 perfiles.add("EDITOR");
		 perfiles.add("GERENTE");
		 
		return perfiles;
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
