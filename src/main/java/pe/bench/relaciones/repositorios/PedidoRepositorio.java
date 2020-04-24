package pe.bench.relaciones.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.bench.relaciones.entidades.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long>{

}
