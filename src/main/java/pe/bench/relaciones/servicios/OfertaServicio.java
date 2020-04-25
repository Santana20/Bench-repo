package pe.bench.relaciones.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.bench.relaciones.entidades.Oferta;
import pe.bench.relaciones.entidades.Oferta_Producto;
import pe.bench.relaciones.repositorios.OfertaProductoRepositorio;
import pe.bench.relaciones.repositorios.OfertaRepositorio;

@Service
public class OfertaServicio {
	@Autowired
	private OfertaRepositorio ofertaRepositorio;
	@Autowired
	private OfertaProductoRepositorio OPR;
	
	public Oferta registrarOferta(Oferta oferta)
	{
		for ( Oferta_Producto aux : oferta.getOferta_productos() )
		{
			aux.setOferta(oferta);
			
		}
		return ofertaRepositorio.save(oferta);
		
	}
	
	public void registrarListaOfertaProducto(List<Oferta_Producto> lista, Oferta oferta)
	{
		for ( Oferta_Producto aux : lista )
		{
			aux.setOferta(oferta);
			OPR.save(aux);
		}
	}
	
	public Oferta actualizarOferta(Oferta oferta, Long codigo) throws Exception
	{
		Oferta of=ofertaRepositorio.findById(codigo).orElseThrow(()->new Exception("ta fregado el lambda"));
		if (oferta.getDescripcion()!=null) {
			of.setDescripcion(oferta.getDescripcion());
		}
		if(oferta.getFecha_inicio()!=null) of.setFecha_inicio(oferta.getFecha_inicio());
		if(oferta.getFecha_final()!=null) of.setFecha_final(oferta.getFecha_final());
		if(oferta.getTitulo()!=null) of.setTitulo(oferta.getTitulo());
		return of;
	}
	
	public Oferta eliminarOferta(Long  codigo) throws Exception
	{
		Oferta of=ofertaRepositorio.findById(codigo).orElseThrow(()->new Exception("ta fregado el lambda x2"));
		ofertaRepositorio.delete(of);
		return of;
	}

}
