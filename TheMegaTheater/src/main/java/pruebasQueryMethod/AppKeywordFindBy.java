package pruebasQueryMethod;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eduardocode.app.repository.NoticiasRepository;

public class AppKeywordFindBy {

	public static void main(String[] args) {
		var context = new ClassPathXmlApplicationContext("root-context.xml");
		var repoNoticias = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		// Ejemplo Keyword findBy
		var noticias = repoNoticias.findByStatus("Inactiva");
		
		noticias.forEach( (noticia) -> {
			System.out.println(noticia.getTitulo());
		});
		
		context.close();
	}

}
