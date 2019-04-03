package pruebasQueryMethod;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eduardocode.app.model.Noticia;
import com.eduardocode.app.repository.NoticiasRepository;

public class AppKeywordOr {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("root-context.xml");
		
		NoticiasRepository repoNoticias = context.getBean("noticiasRepository",
				NoticiasRepository.class);
		
		LocalDate date = LocalDate.of(2017, 9, 1);
		/*
		List<Noticia> noticias = repoNoticias.findByStatusOrFechaPublicacion("Activa", date);
		
		noticias.forEach( (noticia) -> {
			System.out.println(noticia.getTitulo());
		});
		*/
		
		context.close();
	}

}
