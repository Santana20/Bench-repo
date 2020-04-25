package pe.bench.relaciones.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.bench.relaciones.entidades.Cliente;
import pe.bench.relaciones.repositorios.ClienteRepositorio;

@Service
public class ClienteServicio {
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	public Cliente registrarCliente(Cliente cliente) {
		cliente.setPedidos(null);
		cliente.setReviews(null);
		return clienteRepositorio.save(cliente);
	}
}
