package pruebasRelacionesDB;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eduardocode.app.model.Horario;
import com.eduardocode.app.repository.HorariosRepository;

public class AppRepoHorarios {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("root-context.xml");
		
		HorariosRepository repoHorarios = 
				context.getBean("horariosRepository", HorariosRepository.class);
		
		List<Horario> horarios = repoHorarios.findAll();
		horarios.forEach( (horario) -> {
			System.out.println(horario);
		});
		
		context.close();
	}

}
