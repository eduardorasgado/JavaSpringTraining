package pruebasCrudRepository;

import java.util.Optional;

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
		NoticiasRepository repository1 = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		// Aplicando el concepto CRUD a nuestra aplicacion
		
		// Crear-> persistir el objeto de tipo noticia
		if(!repository1.existsById(1)) {
			// si el regstro no se encuentra dentro de la db
			repository1.save(noticia);
		}
		
		// Leer (Read) -> leer objeto
		// finbyid va a devolver un objeto optional con una noticia o vacia si esta no existe
		var noticiaReq = repository1.findById(1); // Optional<Noticia>
		
		System.out.println(noticiaReq.get());
		
		// Actualizar
		// buscamos el objeto a actualizar
		Optional<Noticia> queryNoticia = repository1.findById(2);
		
		if(queryNoticia.isPresent()) {
			var noticiaToUpdate = queryNoticia.get();
			noticiaToUpdate.setStatus("Inactiva");
			
			repository1.save(noticiaToUpdate);
		}
		
		// buscando el objeto actualizado y mostrandolo en pantalla
		var founded = repository1.findById(1);
		System.out.println(founded.get().getStatus());
		
		// Metodo para verificar si una entidad existe en la base de datos
		// metodo existsById
		int idNoticia = 1;
		if(repository1.existsById(idNoticia)) {
			System.out.println("El registro de Noticia con id: " + idNoticia +
					" ya existe en la tabla");
		}
		
		
		// creamos una nueva noticia
		var newNotice = new Noticia();
		newNotice.setDetalle("Se acerca nueva premisa del juego macabro, una nueva experiencia para los amantes de esta"
				+ "perturbadora saga");
		newNotice.setTitulo("Vuelve el juego macabro");
		
		if(!repository1.existsById(4)) {
			// si el registro no existe entonces se guarda
			repository1.save(newNotice);
		}
		
		
		// Eliminar (Delete)
		int idNot2 = 4;
		if(repository1.existsById(idNot2)) {
			// si el id se encuentra en el registro entonces se elimina
			System.out.println("Eliminamos objeto de la tabla");
			//repository1.deleteById(idNot2);
		}
		
		
		
		context.close();
	}

}
