package pe.bench.relaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pe.bench.relaciones.entidades.Review;
import pe.bench.relaciones.servicios.ReviewServicio;

@RestController
@RequestMapping("/api")
public class ReviewServRest {
	@Autowired
	private ReviewServicio reviewServicio;
	
	@PostMapping("/registrarReview/{codC}")
	public Review registrarReview(@RequestBody Review review, @PathVariable(value = "codC")Long codigoC) {
		Review r;
		try {
			r=reviewServicio.registrarReview(review, codigoC);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return r;
	}
	
	@PostMapping("/actualizarReview/{codC}/{codigo}")
	public Review actualizarReview(@RequestBody Review review,@PathVariable(value = "codC") Long codC ,@PathVariable(value = "codigo") Long codigo) {
		Review r;
		try {
			r=reviewServicio.actualizarReview(review,codC ,codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return r;
	}
	
	@DeleteMapping("/borrarReview/{codC}/{codigo}")
	public Review eliminarReview(@PathVariable(value = "codC")Long codC,@PathVariable(value = "codigo")Long codigo) {
		Review r = null;
		try {
			r=reviewServicio.eliminarReview(codC, codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return r;
	}
	
	@GetMapping("/reviews")
	public List<Review> obtenerReviews(){
		return reviewServicio.obtenerReview();
	}
}
