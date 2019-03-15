package pruebasRelacionesDB;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eduardocode.app.model.Pelicula;
import com.eduardocode.app.repository.PeliculasRepository;

public class AppGetHorariosPelicula {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("root-context.xml");
		
		PeliculasRepository repoPeliculas = context.getBean("peliculasRepository",
								PeliculasRepository.class);
		
		Optional<Pelicula> pelicula = repoPeliculas.findById(7);
		
		if(pelicula.isPresent()) {
			System.out.println(pelicula.get().getHorarios().size());
			
			// imprimiendo cada horario relacionado con la pelicula actual
			pelicula.get().getHorarios().forEach( (horario) -> {
				System.out.println(horario);
			});
			
			System.out.println(pelicula.get());
		}
		
		
		context.close();
	}

}
