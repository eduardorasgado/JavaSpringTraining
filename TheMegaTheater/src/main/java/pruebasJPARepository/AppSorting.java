package pruebasJPARepository;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;

import com.eduardocode.app.model.Noticia;
import com.eduardocode.app.repository.NoticiasRepository;

public class AppSorting {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repoNoticias = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		System.out.println("[NOTICIAS SIN ORDENAR]");
		
		// encontrar todas las noticias sin ordenar
		List<Noticia> allNoticias = repoNoticias.findAll();
		allNoticias.forEach((noticia) -> {
			System.out.println(noticia.getTitulo());
		});
		
		System.out.println("[NOTICIAS ORDENADAS POR TITULO]");
		// findAll que toma de parametro un tipo Sort: ordenando descendentemente
		Sort sort = Sort.by("titulo").descending();
		List<Noticia> allNoticiasSorted = repoNoticias.findAll(sort); // ordenar por titulo
		
		allNoticiasSorted.forEach( (noticia) -> {
			System.out.println(noticia.getTitulo());
		});
		
		System.out.println("Elements counted: " + allNoticiasSorted.size());
		
		context.close();
	}

}
