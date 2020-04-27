package pe.upc.bench.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pe.upc.bench.entidades.Cliente;
import pe.upc.bench.entidades.Oferta;
import pe.upc.bench.entidades.Pedido;
import pe.upc.bench.entidades.Pedido_Producto;
import pe.upc.bench.entidades.Pizzeria;
import pe.upc.bench.entidades.Producto;
import pe.upc.bench.entidades.Producto_Oferta;
import pe.upc.bench.servicios.ServicioPedido;

import pe.upc.bench.servicios.ServicioProductoPedido;


@RestController
@RequestMapping("api")
public class Ventas {

	@Autowired
	private ServicioPedido servicioVentas;
	
	
	@Autowired
	private ServicioProductoPedido servicioProductoPedido;
	
	
	
	
	
	//REGISTRAR UN CLIENTE
		@PostMapping("/cliente")
		public Cliente registrarcliente(@RequestBody Cliente cliente) {
			Cliente c;
			try {
				c=servicioVentas.registrarCliente(cliente);
			}catch(Exception e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede resgistrar");
			}
			return c;
		}
	
	//OBTENER UN CLIENTE
	@GetMapping("/cliente/{dni}")
	public Cliente obtenerCliente(@PathVariable(value = "dni") String dni) {
		Cliente c=null;
		try {
			c=servicioVentas.obtenerCliente(dni);
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return c;
	}
	
	//OBTENER LISTA CLIENTES
	@GetMapping("/clientes")
	public List<Cliente> obtenerClientes(){
		return servicioVentas.obtenerClientes();
	}
	
	
	//ELIMINAR CLIENTE
	@GetMapping("/borrar/{dni}")
	public Cliente borrarCliente(@PathVariable(value = "dni") String dni) {
		Cliente c;
		try {
			c=servicioVentas.borrarCliente(dni);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede borrar");
		}
		return c;
	}
	
	
	//REGISTRAR PEDIDO
	@PostMapping("/pedido/{dni}")
	public Pedido registrarPedido(@PathVariable(value = "dni") String dni, @RequestBody Pedido pedido) {
		Pedido p;
		try {
			p=servicioVentas.realizarPedido(dni, pedido);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No es posible realizar el Pedido");
		}
		
		return p;
	}
	
	//OBTENER PEDIDO
	@GetMapping("/pedido/{codigo}")
	public Pedido obtenerPedido(@PathVariable(value = "codigo") Long codigo) {
		Pedido p=null;
		try {
			p=servicioProductoPedido.obtenerPedido(codigo);
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return p;
	}
	
	
	
	//REGISTRAR PRODUCTO
	@PostMapping("/producto/{codigo}")
	public Producto registrarProducto(@PathVariable(value = "codigo") Long codigo,@RequestBody Producto producto) {
		Producto p;
		try {
			p=servicioProductoPedido.registrarProducto(codigo, producto);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar producto");
		}
		return p;
	}
	
	
	//REGISTRAR PEDIDO PRODUCTO
	@PostMapping("/RegistrarPP/{codigo}/{codigo2}")
	public Pedido_Producto registrarPedidoProducto(@PathVariable(value = "codigo") Long codigo,@PathVariable(value = "codigo2") Long codigo2,@RequestBody Pedido_Producto pedido_Producto) {
		Pedido_Producto pp;
		try {
			pp=servicioProductoPedido.registrarPedidoProducto(codigo, codigo2, pedido_Producto);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no es posible realizar pedido producto");
		}
		return pp;
	}
	
	
	
	//REGISTRAR PIZZERIA 
	@PostMapping("/pizzeria")
	public Pizzeria registrarPizzeria(@RequestBody Pizzeria pizzeria) {
		Pizzeria p;
		try {
			p=servicioProductoPedido.registrarPizzeria(pizzeria);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar");
		}
		return p;
	}
	
	//ACTUALIZAR DATOS DE LA PIZZERIA
	@PostMapping("/actualizarPizzeria")
	public Pizzeria actualizarPizzeria(@RequestBody Pizzeria pizzeria) {
		Pizzeria p;
		try {
			p=servicioProductoPedido.actualizarPizzeria(pizzeria);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar");
		}
		return p;
	}
	
	
	//OBTENER DATOS DE LA PIZZERIA
	@GetMapping("/pizzeria/{codigo}")
	public Pizzeria obtenerPizzeria(@PathVariable(value = "codigo") Long codigo) {
		Pizzeria p=null;
		try {
			p=servicioProductoPedido.obtenerPizzeria(codigo);
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return p;
	}
	
	
	//REGISTRAR OFERTA
	@PostMapping("/oferta/{codigo}")
	public Oferta registrarOferta(@PathVariable(value = "codigo") Long codigo, @RequestBody Oferta oferta) {
		Oferta o;
		try {
			o=servicioProductoPedido.registrarOferta(codigo, oferta);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar oferta");
		}
		return o;
	}
	
	//ACTUALIZAR OFERTA
	@PostMapping("/actualizarOferta")
	public Oferta actualizarOferta(@RequestBody Oferta oferta) {
		Oferta o;
		try {
			o=servicioProductoPedido.actualizarOferta(oferta);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede actualizar");
		}
		return o;
	}
	
	//ELIMINAR OFERTA
	@GetMapping("/eliminarcliente/{dni}")
	public Oferta eliminarOferta(Long codigo) {
		Oferta o;
		try {
			o=servicioProductoPedido.eliminarOferta(codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede borrar");
		}
		return o;
	}
	
	//OBTENER OFERTA 
	@GetMapping("/oferta/{codigo}")
	public Oferta obtenerOferta(@PathVariable(value = "codigo")Long codigo) {
		Oferta o=null;
		try {
			o=servicioProductoPedido.obtenerOferta(codigo);
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return o;
	}
	
	
	//REGISTRAR PRODUCTO OFERTA
	@PostMapping("/RegistrarPO/{codigo}/{codigo2}")
	public Producto_Oferta registrarProductoOferta(@PathVariable(value = "codigo") Long codigo,@PathVariable(value = "codigo2") Long codigo2,@RequestBody Producto_Oferta producto_Oferta) {
		Producto_Oferta po;
		try {
			po=servicioProductoPedido.registrarProductoOferta(codigo, codigo2, producto_Oferta);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no es posible realizar pedido producto");
		}
		return po;
	}
	
	
	
}
