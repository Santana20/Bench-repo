package pe.bench.relaciones.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.bench.relaciones.entidades.Pizzeria;

public interface PizzeriaRepositorio extends JpaRepository<Pizzeria, Long>{

}
