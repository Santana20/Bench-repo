package pe.bench.relaciones.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
	
	@Transactional
	public Oferta_Producto registraroferta_producto(Oferta_Producto oferprod) throws Exception
	{ 
		/*Oferta of=null;
		Producto pro=null;
		Oferta_Producto aux = oferprod;
		
		if(oferprod.getProducto()!=null)
		{
			Long cod = oferprod.getProducto().getCodigo();
			pro= productoRepositorio.findProductoById(cod);
		}
		
		if(oferprod.getOferta()!=null)
		{
			Long cod = oferprod.getOferta().getCodigo();
			of= ofertaRepositorio.findProductoById(cod);
		}
		
		aux.setSubtotal(oferprod.getDescuento()*pro.getPrecio());
		aux.setProducto(pro);
		aux.setOferta(of);
		*/
		return ofertaProductoRepositorio.save(oferprod);
		
	}
	
}
