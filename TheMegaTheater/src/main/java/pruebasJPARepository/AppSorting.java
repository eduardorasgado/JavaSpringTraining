package pruebasJPARepository;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;

import com.eduardocode.app.repository.NoticiasRepository;

public class AppSorting {

	public static void main(String[] args) {
		var context = new ClassPathXmlApplicationContext("root-context.xml");
		var repoNoticias = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		System.out.println("[NOTICIAS SIN ORDENAR]");
		
		// encontrar todas las noticias sin ordenar
		var allNoticias = repoNoticias.findAll();
		allNoticias.forEach((noticia) -> {
			System.out.println(noticia.getTitulo());
		});
		
		System.out.println("[NOTICIAS ORDENADAS POR TITULO]");
		// findAll que toma de parametro un tipo Sort
		var sort = Sort.by("titulo");
		var allNoticiasSorted = repoNoticias.findAll(sort); // ordenar por titulo
		
		allNoticiasSorted.forEach( (noticia) -> {
			System.out.println(noticia.getTitulo());
		});
		
		context.close();
	}

}
