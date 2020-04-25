package pe.bench.relaciones.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.bench.relaciones.entidades.Cliente;


public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{
	@Query("SELECT u FROM Cliente u WHERE u.codigo = ?1")
	Cliente findClienteById(Long codigo);
}
