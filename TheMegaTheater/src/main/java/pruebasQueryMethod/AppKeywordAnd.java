package pruebasQueryMethod;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eduardocode.app.model.Noticia;
import com.eduardocode.app.repository.NoticiasRepository;

public class AppKeywordAnd {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repoNoticias = context.getBean("noticiasRepository",
				NoticiasRepository.class);
		
		// query builder usando and
		
		LocalDate fechaPublicacion = LocalDate.of(2017, 9, 1); 
		/*List<Noticia> noticias = repoNoticias.findByStatusAndFechaPublicacion("Activa", fechaPublicacion);
		
		noticias.forEach( (noticia) -> {
			System.out.println(noticia.getTitulo());
		});
		*/
		context.close();
	}

}
