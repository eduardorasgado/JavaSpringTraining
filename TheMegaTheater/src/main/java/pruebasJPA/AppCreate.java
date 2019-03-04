package pruebasJPA;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eduardocode.app.model.Noticia;
import com.eduardocode.app.repository.NoticiasRepository;

public class AppCreate {

	public static void main(String[] args) {
		var noticia = new Noticia();
		noticia.setTitulo("Se estrena Toy Story 4! Quieres saber la fecha?");
		noticia.setDetalle("lorem ipsum dolor sit amet");
		
		var context = new ClassPathXmlApplicationContext("root-context.xml");
		
		// Agregando una instancia del bean de noticias.
		// buscamos el bean en el context, si no se especifica el nombre del bean
		// en la anotacion @Repository entonces esta sera el nombre de la interfaz
		// pero en camel case, en este caso la n minuscula
		NoticiasRepository r1 = context.getBean("noticiasRepository", NoticiasRepository.class);
		// persistir el objeto de tipo noticia
		r1.save(noticia);
		
		context.close();
	}

}
