package pruebasQueryMethod;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eduardocode.app.model.Noticia;
import com.eduardocode.app.repository.NoticiasRepository;

public class AppKeywordBetween {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("root-context.xml");
		
		NoticiasRepository repoNoticias = context.getBean("noticiasRepository",
				NoticiasRepository.class);
		
		
		LocalDate startDate = LocalDate.of(2017, 9, 3);
		LocalDate finishDate = LocalDate.of(2017, 9, 6);
		
		List<Noticia> noticias = repoNoticias.findByFechaPublicacionBetween(
				startDate, finishDate);
		
		noticias.forEach( (noticia) -> {
			System.out.println(noticia.getTitulo());
		});
		
		List<Noticia> noticiasById = repoNoticias.findByIdBetween(10, 15);
		
		System.out.println("BUSCANDO POR ID BETWEEN");
		noticiasById.forEach( (noticia) -> {
			System.out.println(noticia.getId() + " | " + noticia.getTitulo());
		});
	}

}
