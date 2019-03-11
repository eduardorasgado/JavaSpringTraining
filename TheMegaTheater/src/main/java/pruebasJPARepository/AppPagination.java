package pruebasJPARepository;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.eduardocode.app.model.Noticia;
import com.eduardocode.app.repository.NoticiasRepository;

public class AppPagination {

	public static void main(String[] args) {
		var context = new ClassPathXmlApplicationContext("root-context.xml");
		var repoNoticias = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		// Obtener todas las entidades por paginacion
		// recuperando las paginas de la 1 a la 7
		showPage(repoNoticias, 0, 5);
		showPage(repoNoticias, 1, 5);
		showPage(repoNoticias, 2, 5);
		showPage(repoNoticias, 3, 5);
		showPage(repoNoticias, 4, 5);
		showPage(repoNoticias, 5, 5);
		showPage(repoNoticias, 6, 5);
		
		context.close();
	}
	
	public static void showPage(NoticiasRepository repoNoticias, int page, int items) {
		
		var pageable = PageRequest.of(page, items); // num de pagina, num de registros
		Page<Noticia> pagina = repoNoticias.findAll(pageable);
		
		// imprimiendo los elementos contenidos en la primera pagina
		System.out.println("[PAGINA "+ (page+1)+ "]");
		
		pagina.forEach( (noticia) -> {
			System.out.println(noticia);
		});
	}

}
