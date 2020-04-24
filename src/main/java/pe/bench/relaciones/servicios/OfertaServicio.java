package pe.bench.relaciones.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.bench.relaciones.entidades.Oferta;
import pe.bench.relaciones.repositorios.OfertaRepositorio;

@Service

public class OfertaServicio {
	@Autowired
	private OfertaRepositorio ofertaRepositorio;
	
	public Oferta registrarOferta(Oferta oferta)
	{
		return ofertaRepositorio.save(oferta);
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
