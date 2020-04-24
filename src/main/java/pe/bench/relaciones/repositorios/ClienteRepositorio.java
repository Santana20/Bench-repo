package pe.bench.relaciones.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.bench.relaciones.entidades.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{

}
