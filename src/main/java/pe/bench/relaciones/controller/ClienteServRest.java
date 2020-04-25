package pe.bench.relaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.bench.relaciones.entidades.Cliente;
import pe.bench.relaciones.servicios.ClienteServicio;

@RestController
@RequestMapping("/api")
public class ClienteServRest {
	@Autowired
	private ClienteServicio clienteServicio;
	
	@PostMapping("/registrarCliente")
	public Cliente registrarCliente(@RequestBody Cliente cliente) {
		return clienteServicio.registrarCliente(cliente);
	}
}
