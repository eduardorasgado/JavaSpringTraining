package pruebasQueryMethod;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eduardocode.app.model.Noticia;
import com.eduardocode.app.repository.NoticiasRepository;

public class AppKeywordFindBy {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repoNoticias = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		// Ejemplo Keyword findBy
		List<Noticia> noticias = repoNoticias.findByStatus("Inactiva");
		
		noticias.forEach( (noticia) -> {
			System.out.println(noticia.getTitulo());
			System.out.println(noticia.getFechaPublicacion());
		});
		
		System.out.println("[ENCONTRANDO POR FECHA DE PUBLICACION]");
		
		//var fechaPublicacion = noticias.get(0).getFechaPublicacion();
		
		// la busqueda con el campo date no puede realizarse
		// debido a algo con la hora global y la hora local
		// ya que posiblemente java maneje hora global con date
		// y la base de datos maneje hora local, asi entonces usamos hora local
		// hasta en el model
		LocalDate fechaPublicacion = LocalDate.of(2019, 3, 11);
		/*
		List<Noticia> noticiasFecha = repoNoticias.findByFechaPublicacion(fechaPublicacion);
		
		noticiasFecha.forEach( (noticia) -> {
			System.out.println(noticia.getTitulo());
		});
		*/
		context.close();
	}
	
	public static Date getDate(int year, int month, int day) {
		Calendar myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, year);
		myCal.set(Calendar.MONTH, month);
		myCal.set(Calendar.DAY_OF_MONTH, day);
		
		return myCal.getTime();
	}

}
