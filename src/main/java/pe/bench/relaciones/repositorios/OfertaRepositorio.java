package pe.bench.relaciones.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.bench.relaciones.entidades.Oferta;
import pe.bench.relaciones.entidades.Producto;

public interface OfertaRepositorio extends JpaRepository<Oferta, Long>{
	@Query("SELECT u FROM Oferta u WHERE u.codigo = ?1")
	Oferta findProductoById(Long codigo);
}
