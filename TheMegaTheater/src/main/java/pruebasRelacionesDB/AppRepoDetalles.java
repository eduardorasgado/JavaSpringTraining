package pruebasRelacionesDB;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eduardocode.app.model.Detalle;
import com.eduardocode.app.repository.DetallesRepository;

public class AppRepoDetalles {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("root-context.xml");
		
		DetallesRepository repoDetalles = context
				.getBean("detallesRepository", DetallesRepository.class);
		
		List<Detalle> detalles = repoDetalles.findAll();
		detalles.forEach( (detalle) -> {
			System.out.println(detalle.getId() + " | " + detalle.getSinopsis());
		});

	}

}
