package com.eduardocode.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eduardocode.app.model.Banner;

/*Notacion que permite la inyeccion de dependencia*/
@Service
public class BannersServiceImp implements IBannersService {

	private List<Banner> listaBanners = null;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	
	public BannersServiceImp() {
		System.out.println("INSTANCIA DE SERVICIO DE BANNERS CREADA(SINGLETON)");
		
		// constructor
		// formateo de fechas
		
		
		try {
			// definimos la lista
			listaBanners = new LinkedList<>();
			
			// creamos instancias de Banner con los banners con los que
			// ya se cuentan en resources/images
			Banner b1 = new Banner();
			Banner b2 = new Banner();
			Banner b3 = new Banner();
			Banner b4 = new Banner();
			Banner b5 = new Banner();
			Banner b6 = new Banner();
			Banner b7 = new Banner();
			
			b1 = setDataToBanner( b1, 1, "Kong/Logan", "slide1.jpg", "Activo", 
					formatter.parse("28-05-2017"));
			b2 = setDataToBanner(b2, 2, "La bella y la bestia", "slide2.jpg", "Activo",
					formatter.parse("02-04-2018"));
			b3 = setDataToBanner(b3, 3, "Spider Man Home Comming", "slide3.jpg", "Activo",
					formatter.parse("23-12-2018"));
			b4 = setDataToBanner(b4, 4, "cars 3", "slide4.jpg", "Activo",
					formatter.parse("01-02-2019"));
			b5 = setDataToBanner(b5, 5, "Un golpe con estilo", "slide5.jpg", "Activo",
					formatter.parse("01-03-2016"));
			b6 = setDataToBanner(b6, 6, "Alien Convenant", "slide6.jpg", "Activo",
					formatter.parse("16-09-2018"));
			b7 = setDataToBanner(b7, 7, "El rey arturo", "slide7.jpg", "Activo",
					formatter.parse("25-12-2018"));
			
			listaBanners.add(b1);
			listaBanners.add(b2);
			listaBanners.add(b3);
			listaBanners.add(b4);
			listaBanners.add(b5);
			listaBanners.add(b6);
			listaBanners.add(b7);
			
		} catch(ParseException e) {
			System.out.println("Error: "+ e.getMessage());
		}
		
	}
	@Override
	public List<Banner> getAll() {
		// TODO Auto-generated method stub
		return listaBanners;
	}
	
	@Override
	public void insert(Banner banner) {
		// TODO Auto-generated method stub
		listaBanners.add(banner);
	}
	
	private Banner setDataToBanner(Banner b, int id, String titulo, 
			String archivo, String estado, Date fechaPub) {
		// solamente inserta los datos pasados en el objeto banner
		b.setId(id);
		b.setTitulo(titulo);;
		b.setNombreArchivo(archivo);
		b.setStatus(estado);
		b.setFechaPub(fechaPub);
		
		return b;
	}

}
