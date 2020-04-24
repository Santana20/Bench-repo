package pe.bench.relaciones.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.bench.relaciones.entidades.Producto;
import pe.bench.relaciones.repositorios.ProductoRepositorio;

//para decirle que la clase es singleton: El programa la instancia solo una vez
@Service 
public class ProductoServicio {
	@Autowired
	private ProductoRepositorio repoProducto;
	
	public Producto crearProducto( Producto prod )
	{
		return repoProducto.save(prod);
	}
	
	public Producto obtenerProducto( Long codigo ) throws Exception
	{
		return repoProducto.findById(codigo)
				.orElseThrow(() -> new Exception("La busqueda no tuvo resultado") );
	}
	
	public Producto actualizarProducto( Producto prod, Long codigo ) throws Exception
	{
		Producto p = repoProducto.findById(codigo)
				.orElseThrow(() -> new Exception("No se pudo actualizar") );
		
		if ( prod.getDescripcion() != null ) p.setDescripcion(prod.getDescripcion());
		
		if ( prod.getNombre() != null ) p.setNombre(prod.getNombre());
		if ( prod.getPrecio() != null ) p.setPrecio(prod.getPrecio());
		
		repoProducto.save(p);
		return p;
	}
	
	public Producto borrarProducto( Long codigo ) throws Exception
	{
		Producto p;
		p = repoProducto.findById(codigo)
				.orElseThrow(() -> new Exception("no se pudo eliminar") );
		
		repoProducto.delete(p);
		return null;
	}
	
}
