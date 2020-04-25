package pe.bench.relaciones.controller;
//Oferta producto Rest

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pe.bench.relaciones.entidades.Oferta;
import pe.bench.relaciones.entidades.Oferta_Producto;
import pe.bench.relaciones.entidades.Producto;
import pe.bench.relaciones.servicios.OfertaProductoServicio;

@RestController
@RequestMapping("/api")
public class OfertaProdServRest {
	
	@Autowired
	private OfertaProductoServicio ofertaProductoServicio;
	
	@PostMapping("/detallarOferta")
	public Oferta_Producto registraroferta_producto(Oferta_Producto oferprod) 
	{ 
		Oferta_Producto ofpro= null;
		try {
			ofpro = ofertaProductoServicio.registraroferta_producto(oferprod);
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return ofpro;		
	}

}
