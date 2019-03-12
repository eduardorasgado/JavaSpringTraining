package pruebasJPARepository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eduardocode.app.model.Noticia;
import com.eduardocode.app.repository.NoticiasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repoNoticias = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		
		List<String> titulos = new LinkedList<String>() 
		{{
			add("ATitulo1"); add("CTitulo2"); add("cTitulo3"); add("BTitulo4"); add("GTitulo5"); add("ETitulo6"); add("DTitulo7"); add("hTitulo8");
		}};
		
		List<String> detalles = new LinkedList<String>() 
		{{
			add("RDetalle1: lorem ipsum dolor sit amet"); add("aDetalle2: lorem ipsum dolor sit amet"); 
			add("Detalle3: lorem ipsum dolor sit amet"); add("bDetalle4: lorem ipsum dolor sit amet"); 
			add("ADetalle5: lorem ipsum dolor sit amet"); add("cDetalle6: lorem ipsum dolor sit amet"); 
			add("XDetalle7: lorem ipsum dolor sit amet"); add("dDetalle8: lorem ipsum dolor sit amet");}};
		
		for(int i = 0; i < 8; i++) {
			Noticia not = new Noticia();
			not.setTitulo(titulos.get(i));
			not.setDetalle(detalles.get(i));
			repoNoticias.save(not);
		}
		
		
		// obtener todas las entidades
		// con NoticiasRepository extendiendo de CrudRepository
		//repoNoticias.findAll(); // regresa un iterable que envuelve objetos Noticia
		
		// con NoticiasRepository extendiendo de JpaRepository
		List<Noticia> noticias = repoNoticias.findAll(); // devuelve una lista de Noticias List<Noticia>
		noticias.forEach((noticia) ->
					{ System.out.println(noticia.getTitulo()); });
		
		context.close();
	}

}
