package pruebasJPA;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppConnection {

	public static void main(String[] args) {
		// creamos una instancia del application context de spring
		// con todos los beans del root-context
		// para que aqui funcione tenemos que mover el root context a la carpeta
		// src/main/resources
		var context = new ClassPathXmlApplicationContext("root-context.xml");
		context.close();
	}

}
