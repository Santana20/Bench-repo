package pe.bench.relaciones.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.bench.relaciones.entidades.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Long>{

}
