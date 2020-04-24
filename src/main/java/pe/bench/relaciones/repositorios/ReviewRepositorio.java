package pe.bench.relaciones.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.bench.relaciones.entidades.Review;

public interface ReviewRepositorio extends JpaRepository<Review, Long>{

}
