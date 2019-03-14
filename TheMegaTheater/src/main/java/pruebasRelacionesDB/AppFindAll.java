package pruebasRelacionesDB;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eduardocode.app.model.Pelicula;
import com.eduardocode.app.repository.PeliculasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("root-context.xml");
		
		PeliculasRepository repoPeliculas = 
				context.getBean("peliculasRepository", PeliculasRepository.class);
		
		// relacion entre las entidades detalle y peliculas
		List<Pelicula> peliculas = repoPeliculas.findAll();
		peliculas.forEach( (pelicula) -> {
			System.out.println(pelicula.getTitulo());
		});
		context.close();
	}

}
