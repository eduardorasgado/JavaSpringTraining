package pruebasJPA;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class appCreate2 {

	public static void main(String[] args) {
		var context = new ClassPathXmlApplicationContext("context.xml");
		
		// Contar los numeros de regustros en la tabla
		
		
		context.close();
	}

}
