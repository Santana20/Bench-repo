package pe.bench.relaciones.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.bench.relaciones.entidades.Oferta;
import pe.bench.relaciones.entidades.Oferta_Producto;
import pe.bench.relaciones.entidades.Producto;
import pe.bench.relaciones.repositorios.OfertaProductoRepositorio;
import pe.bench.relaciones.repositorios.OfertaRepositorio;
import pe.bench.relaciones.repositorios.ProductoRepositorio;

@Service

public class OfertaProductoServicio {
	@Autowired
	
	private OfertaRepositorio ofertaRepositorio;
	@Autowired
	
	private ProductoRepositorio productoRepositorio;
	@Autowired
	private OfertaProductoRepositorio ofertaProductoRepositorio;
	
	public Oferta_Producto registraroferta_producto( Oferta_Producto oferprod) throws Exception
	{ 
		Oferta of=null;
		Producto pro=null;
		if(oferprod.getOferta()!=null)
		of= ofertaRepositorio.findById(oferprod.getOferta().getCodigo()).orElseThrow(()-> new Exception ("no encontrado"));
		if(oferprod.getProducto()!=null)
		pro= productoRepositorio.findById(oferprod.getProducto().getCodigo()).orElseThrow(()-> new Exception ("no encontrado"));
		
		oferprod.setSubtotal(oferprod.getDescuento()*pro.getPrecio());
		oferprod.setProducto(pro);
		oferprod.setOferta(of);
		return ofertaProductoRepositorio.save(oferprod);
		
	}
	
}
