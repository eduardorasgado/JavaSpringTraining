package pruebasCrudRepository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eduardocode.app.model.Noticia;
import com.eduardocode.app.repository.NoticiasRepository;

public class appCreate2 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		// METODOS CUANDO NOTICIASREPOSITORY EXTIENDE DE CRUDREPOSITORY
		
		// Contar los numeros de regustros en la tabla
		long num = repo.count();
		System.out.println("Existen "+ num + " registros en la tabla Noticias");
		
		// Encontrando todos los elementos de una tabla
		Iterable<Noticia> noticias = repo.findAll();
		// podemos iterar entre los objetos ahora
		// uso de funciones lambda en java 11
		noticias.forEach((noticia) -> 
			{ System.out.println(noticia.getTitulo()); 
		});
		
		System.out.println("Borrando todos los elementos de la tabla noticia");
		// Metodo DeleteAll -> Eliminar todos los registros de una tabla
		repo.deleteAll();
		
		long start = System.currentTimeMillis();
		// esperamos 6 segundos antes de volver a recuperar todos los elementos de nuevo
		try {
			Thread.sleep(6000);
		} catch(InterruptedException e) {
			System.out.println("La operacion ha sido interrumpida");
		}
		// imprimimos en pantalla el total de tiempo real que se tomo el sleep
		System.out.println("Sleep time in ms is:" + (System.currentTimeMillis() - start));
		
		// volvemos a incluir todos los elementos de nuevo en la tabla
		noticias.forEach((noticia) ->
					{ repo.save(noticia); } );
		
		// Buscando varias entidades pasando por parametros un listado de varios ids
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(11);
		ids.add(12);
		
		// debemos de meter el objeto de tipo lista como argumento para este metodo
		List<Noticia> allNotices = repo.findAllById(ids);
		allNotices.forEach((noticia) ->
					{ System.out.println(noticia.getTitulo()); });
		
		context.close();
	}

}
