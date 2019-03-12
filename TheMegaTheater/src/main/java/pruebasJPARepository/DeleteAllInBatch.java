package pruebasJPARepository;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eduardocode.app.repository.NoticiasRepository;

public class DeleteAllInBatch {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repoNoticias = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		repoNoticias.deleteAllInBatch();
		
		System.out.println("Elementos en tabla noticias: "+ repoNoticias.count());
		
		context.close();
	}

}
