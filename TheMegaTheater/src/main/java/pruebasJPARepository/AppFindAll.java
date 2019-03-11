package pruebasJPARepository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eduardocode.app.model.Noticia;
import com.eduardocode.app.repository.NoticiasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		
		var context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repoNoticias = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		/*
		List<String> titulos = new LinkedList<String>() 
		{{
			add("Titulo1"); add("Titulo2"); add("Titulo3"); add("Titulo4"); add("Titulo5"); add("Titulo6"); add("Titulo7"); add("Titulo8");
		}};
		
		List<String> detalles = new LinkedList<String>() 
		{{
			add("Detalle1: lorem ipsum dolor sit amet"); add("Detalle2: lorem ipsum dolor sit amet"); 
			add("Detalle3: lorem ipsum dolor sit amet"); add("Detalle4: lorem ipsum dolor sit amet"); 
			add("Detalle5: lorem ipsum dolor sit amet"); add("Detalle6: lorem ipsum dolor sit amet"); 
			add("Detalle7: lorem ipsum dolor sit amet"); add("Detalle8: lorem ipsum dolor sit amet");}};
		
		for(int i = 0; i < 8; i++) {
			var not = new Noticia();
			not.setTitulo(titulos.get(i));
			not.setDetalle(detalles.get(i));
			repoNoticias.save(not);
		}
		*/
		
		// obtener todas las entidades
		// con NoticiasRepository extendiendo de CrudRepository
		//repoNoticias.findAll(); // regresa un iterable que envuelve objetos Noticia
		
		// con NoticiasRepository extendiendo de JpaRepository
		var noticias = repoNoticias.findAll(); // devuelve una lista de Noticias List<Noticia>
		noticias.forEach((noticia) ->
					{ System.out.println(noticia.getTitulo()); });
		
		context.close();
	}

}
