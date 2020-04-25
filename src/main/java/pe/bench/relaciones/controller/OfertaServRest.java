package pe.bench.relaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pe.bench.relaciones.entidades.Oferta;
import pe.bench.relaciones.servicios.OfertaServicio;



@RestController
@RequestMapping("/api")

public class OfertaServRest {
	@Autowired
	private OfertaServicio ofs;
	
	@PostMapping("/registrarOferta")
	public Oferta registrarOferta(@RequestBody Oferta oferta)
	{
		Oferta of=null;
		try {
			of=ofs.registrarOferta(oferta);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return of;
	}
	
	@PutMapping("/actualizarOferta/{codigo}")
	public Oferta actualizarOferta(@RequestBody Oferta oferta, @PathVariable(value = "codigo")Long codigo) 
	{
		Oferta of=null;
		try {
			of=ofs.actualizarOferta(oferta, codigo);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return of;

	}
	@DeleteMapping("/eliminarOferta/{codigo}")
	public Oferta eliminarOferta(@PathVariable(value = "codigo") Long  codigo) 
	{
		
		Oferta of=null;
		try {
			of=ofs.eliminarOferta(codigo);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return of;

	}

}
