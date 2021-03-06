package com.eduardocode.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eduardocode.app.model.Banner;
import com.eduardocode.app.model.Horario;
import com.eduardocode.app.model.Noticia;
import com.eduardocode.app.model.Pelicula;
import com.eduardocode.app.service.IBannersService;
import com.eduardocode.app.service.IHorariosService;
import com.eduardocode.app.service.INoticiasService;
import com.eduardocode.app.service.IPeliculasService;
import com.eduardocode.app.utils.Utility;

@Controller
public class HomeController {
	/* instanciando una clase del servicio peliculas usando autowire
	 * que permite la inyeccion de dependencias
	 *  Aqui vemos como en ningun momento usamos el operador new para instanciar
	 *  porque spring lo hace por si solo para optimizar procesos*/
	@Autowired
	private IPeliculasService servicePeliculas;
	
	@Autowired
	private IBannersService bannerService;
	
	@Autowired
	private IHorariosService horariosService;
	
	@Autowired
	private INoticiasService noticiasService;
	
	private SimpleDateFormat homeDateFormatter = new SimpleDateFormat("dd-MM-yyyy");
	
	
	//@RequestMapping(value="/home", method=RequestMethod.GET)
	@GetMapping("/home")
	public String index(Model model) {
		return this.showMain(model);
	}
	
	//@RequestMapping(value="/search", method=RequestMethod.POST)
	@PostMapping("/search")
	public String searchByDate(Model model,
			@RequestParam("fecha") String fecha) {
		// convirtiendo la fecha en string a una fecha en date
		Date userDate = new Date();
		try {
			userDate = homeDateFormatter.parse(fecha);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		model = this.getMoviesToday(model, userDate);
		model = this.getMoviesAboutDate(model, fecha);
		model = this.getBanners(model);
		model = this.getNoticias(model);
		
		return "home";
	}

	@GetMapping("/search")
	// Manejando la peticion get de /search
	public String searchByDate(Model model) {
		return this.showMain(model);
	}
	
	@GetMapping("/")
	public String showMain(Model model) {
		String fechaBusqueda = homeDateFormatter.format(new Date());
		
		// convertimos la fecha busqueda aprovechandola, para tener una fecha de
		// hoy formateada a como los registros se estan guardando en los campos de fecha
		// sin hora. Con esto al entrar a la vista principal, se renderean correctamente
		// las peliculasToday
		// no queremos una excepcion nula de java, por eso no ponemos null
		Date today = new Date();
		try {
			 today = homeDateFormatter.parse(fechaBusqueda);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		
		model = this.getMoviesToday(model, today);
		model = this.getMoviesAboutDate(model, fechaBusqueda);
		model = this.getBanners(model);
		model = this.getNoticias(model);
		
		return "home";		
	}
	
	@RequestMapping(value="/detail/{id}/{fecha}", method=RequestMethod.GET)
	public String showDetail(Model model,
			@PathVariable("id") int idPelicula,
			@PathVariable("fecha") Date fechaBusqueda,
			RedirectAttributes attributes) {
		
		// llamando a un metodo del servicio de peliculas
		Pelicula pelicula = servicePeliculas.searchById(idPelicula);
		
		if(pelicula == null) {
			// en caso de no existir el id
			//model.addAttribute("Error", true);
			// redireccionamos al inicio
			attributes.addFlashAttribute("error", "Lo que intentas buscar no existe, "
					+ "prueba con nuestro nuevo contenido, te va a gustar");
			return "redirect:/";
		} else {
			// buscamos el los horarios de la pelicula segun la fecha
			List<Horario> horarios = horariosService
					.searchByIdPeliculaAndFecha(idPelicula,
							fechaBusqueda);
			
			model.addAttribute("pelicula", pelicula);
			model.addAttribute("fechaBusqueda", homeDateFormatter.format(fechaBusqueda));
			model.addAttribute("horarios", horarios);
		}
		return "detail";
	}
	
	@GetMapping("/about")
	public String acerca() {
		return "about";
	}
	
	@ModelAttribute("today")
	public String addToday() {
		return homeDateFormatter.format(new Date());
	}
	
	// RUTAS PARA EL LOGIN ========================
	
	@GetMapping("/entrar")
	public String entrar() {
		// metodo para devolver el formulario personalizado del login
		// Se configura su llamado en security.xml dentro del tag html
		return "auth/formLogin";
	}
	
	/*
	 * Para el logueo de usuario se manda el form a traves del metodo entrar anterior
	 * En el caso de procesar los datos adquiridos, spring security lo hace automaticamente
	 * siempre en la ruta /login
	 * En caso de haber error en los datos del logueo spring devolvera un parametro de error en la url
	 * que puede ser manejado directamente en la vista custom del login
	 * */
	
	// utilidades ================================
	
	private Model getMoviesAboutDate(Model model, 
			String fechaBusqueda) {
		// llenando la lista con el modelo, con peliculas activas
		List<Pelicula> peliculas = servicePeliculas.getAllActive();
		
		// creando la lista de 5 dias a partir de ahorita
		List<String> siguientesDias = Utility.generateNextDays(4);
		
		// mandando la lista al frontend
		model.addAttribute("peliculas", peliculas);
		// mandando la fecha actual al frontend y los sig 4 dias
		model.addAttribute("fechaBusqueda", fechaBusqueda);
		model.addAttribute("listaFechas", siguientesDias);
		
		return model;
	}
	
	private Model getMoviesToday(Model model, Date userDate) {
		
		// conseguir las peliculas con horarios disponibles para la fecha actual
		List<Pelicula> peliculas = servicePeliculas.getAllActive();
		
		// donde almancenar las peliculas disponibles hoy
		List<Pelicula> peliculasToday = new LinkedList<>();
		
		for(int i = 0; i < peliculas.size(); i++) {
			// buscando las peliculas con horarios de hoy
			List<Horario> horariosPelicula = peliculas.get(i).getHorarios();
			// bandera para prevenir agregar una pelicula que ya existe en la lista today
			boolean nonExistFlag = false;
			for(int j = 0; j < horariosPelicula.size(); j++) {
				
				if((horariosPelicula.get(j).getFecha().compareTo(userDate) == 0) && !nonExistFlag) {
					// si la pelicula en cuestion tiene un horario marcado para la fecha general
					// entonces se agrega a la lista que se va a agregar al modelo
					peliculasToday.add(peliculas.get(i));
					nonExistFlag = true;
				}
			}
		}
		
		model.addAttribute("peliculasToday", peliculasToday);
		return model;
	}
	
	private Model getBanners(Model model) {
		// agregando banners al modelo
		List<Banner> listaBanners = bannerService.getAllActive();
						
		model.addAttribute("listaBanners", listaBanners);
		
		// tomar el id del primer elemento como punto de inicio o cero
		if(listaBanners.size() > 0) {
			int initPoint = listaBanners.get(0).getId();
			
			// counter para el slider
			int[] sliderCount = new int[listaBanners.size()];
			for(int i = 0; i < listaBanners.size();i++) {
				sliderCount[i] = i;
			}
			model.addAttribute("sliderCounter", sliderCount);
			// para mostrar los sliders en orden aun cuando no inicien con un id de
			// cero, crear las condiciones para que se considere cero
			model.addAttribute("bannerinit", initPoint);
		}
		return model;
	}
	
	private Model getNoticias(Model model) {
		
		// buscando las ultimas tres noticias agregadas
		
		List<Noticia> noticias = noticiasService.getAll();
		Collections.reverse(noticias);
		
		// las ultimas 3 noticias agregadas
		model.addAttribute("noticias", noticias.subList(0, 3));
		return model; 
	}
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		// ultimo false no permitira fechas vacias
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(dateFormatter, false));
	}
}
