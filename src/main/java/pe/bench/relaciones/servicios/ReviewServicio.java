package pe.bench.relaciones.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.bench.relaciones.entidades.Cliente;
import pe.bench.relaciones.entidades.Review;
import pe.bench.relaciones.repositorios.ClienteRepositorio;
import pe.bench.relaciones.repositorios.ReviewRepositorio;

@Service
public class ReviewServicio {
	@Autowired
	private ReviewRepositorio reviewRepositorio;
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	public Review registrarReview(Review review, Long codigoC) throws Exception{
		Cliente c = clienteRepositorio.findById(codigoC).orElseThrow(()->new Exception("No existe este cliente."));
		review.setCliente(c);
		return reviewRepositorio.save(review);
	}
	
	public Review actualizarReview(Review review, Long codC,Long codigo)throws Exception {
		Cliente c;
		c = clienteRepositorio.findById(codC).orElseThrow(()->new Exception("No existe este cliente."));
		Review r = reviewRepositorio.findById(codigo).orElseThrow(()->new Exception("No se puede actualizar"));
		r.setDescripcion(review.getDescripcion());
		r.setTitulo(review.getTitulo());
		return reviewRepositorio.save(r);
	}
	
	public Review eliminarReview(Long codC,Long codigo) throws Exception {
		Review r;
		Cliente c;
		c = clienteRepositorio.findById(codC).orElseThrow(()->new Exception("No existe este cliente."));
		r = reviewRepositorio.findById(codigo).orElseThrow(()->new Exception("No existe la review"));
		reviewRepositorio.delete(r);
		return r;
	}
	
	public List<Review> obtenerReview(){
		return reviewRepositorio.findAll();
	}
}
