package pe.bench.relaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pe.bench.relaciones.entidades.Producto;
import pe.bench.relaciones.servicios.ProductoServicio;

@RestController
@RequestMapping("/api")
public class ProductoServRest {
	
	@Autowired
	private ProductoServicio PS;
	
	@PostMapping("/registrarProducto")
	public Producto crearProducto(@RequestBody Producto prod)
	{
		Producto p = null;
		try
		{
			p = PS.crearProducto(prod);
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo registrar el producto");
		}
		return p;
	}
	
	@GetMapping("/producto/{codigo}")
	public Producto obtenerProducto(@PathVariable(value="codigo") Long codigo )
	{
		Producto p = null;
		try
		{
			p = PS.obtenerProducto(codigo);
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
		return p;
	}
	
	@PutMapping("/actualizarProducto/{codigo}")
	public Producto actualizarProducto(@RequestBody Producto prod, @PathVariable(value="codigo") Long codigo )
	{
		Producto p=null;
		try
		{
			p = PS.actualizarProducto(prod, codigo);
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
		return p;
	}
	
	@DeleteMapping("/deleteProducto/{codigo}")
	public Producto borrarProducto(@PathVariable(value="codigo") Long codigo )
	{
		Producto p = null;
		try
		{
			p = PS.borrarProducto(codigo);
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
		return p;
	}
	
	
}
