package pruebasJPARepository;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;

import com.eduardocode.app.repository.NoticiasRepository;

public class AppSorting2 {

	public static void main(String[] args) {
		var context = new ClassPathXmlApplicationContext("root-context.xml");
		var repoNoticias = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		// Obtener entidades de una tabla ordenadas por dos o mas atributos
		// ordenar por fecha ascendentemente
		var sort = Sort.by("fechaPublicacion")
						.descending()
				// por cada fecha que acumule noticias, estas van a ser ordenadas
				// por titulo de forma descendente
				.and(Sort.by("titulo")
						.ascending()
				);
		
		var listaNoticias = repoNoticias.findAll(sort);
		
		listaNoticias.forEach( (noticia) -> {
			System.out.println("titulo: "+noticia.getTitulo() +
								" | fecha: " + noticia.getFechaPublicacion());
		});
		
		context.close();
	}

}
