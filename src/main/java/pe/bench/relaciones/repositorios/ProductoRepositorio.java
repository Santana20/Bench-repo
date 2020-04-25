package pe.bench.relaciones.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.bench.relaciones.entidades.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Long>{
	@Query("SELECT u FROM Producto u WHERE u.codigo = ?1")
	Producto findProductoById(Long codigo);
}
