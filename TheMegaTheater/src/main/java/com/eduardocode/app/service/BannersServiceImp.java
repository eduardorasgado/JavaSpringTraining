package com.eduardocode.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eduardocode.app.model.Banner;

/*Notacion que permite la inyeccion de dependencia*/
@Service
public class BannersServiceImp implements IBannersService {

	private List<Banner> listaBanners = null;
	
	public BannersServiceImp() {
		// constructor
		// formateo de fechas
		var formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			// creamos instancias de Banner con los banners con los que
			// ya se cuentan en resources/images
			var b1 = new Banner();
			var b2 = new Banner();
			var b3 = new Banner();
			var b4 = new Banner();
			var b5 = new Banner();
			var b6 = new Banner();
			var b7 = new Banner();
			
			b1 = setDataToBanner( b1, 1, "Kong/Logan", "slide1.jpg", "Activo", 
					formatter.parse("28-05-2017"));
			b2 = setDataToBanner(b2, 1, "La bella y la bestia", "slide2.jpg", "Activo",
					formatter.parse("02-04-2018"));
			b3 = setDataToBanner(b3, 1, "Spider Man Home Comming", "slide3.jpg", "Activo",
					formatter.parse("23-12-2018"));
			b4 = setDataToBanner(b4, 1, "cars 3", "slide4.jpg", "Activo",
					formatter.parse("01-02-2019"));
			b5 = setDataToBanner(b5, 1, "Un golpe con estilo", "slide5.jpg", "Activo",
					formatter.parse("01-03-2016"));
			b6 = setDataToBanner(b6, 1, "Alien Convenant", "slide6.jpg", "Activo",
					formatter.parse("16-09-2018"));
			b7 = setDataToBanner(b7, 1, "El rey arturo", "slide7.jpg", "Activo",
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
