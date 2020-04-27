package pe.upc.bench.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.bench.entidades.Cliente;
import pe.upc.bench.entidades.Oferta;
import pe.upc.bench.entidades.Pedido;
import pe.upc.bench.entidades.Pedido_Producto;
import pe.upc.bench.entidades.Pizzeria;
import pe.upc.bench.entidades.Producto;
import pe.upc.bench.entidades.Producto_Oferta;
import pe.upc.bench.repositorios.RepositorioOferta;
import pe.upc.bench.repositorios.RepositorioPedido;
import pe.upc.bench.repositorios.RepositorioPedidoProducto;
import pe.upc.bench.repositorios.RepositorioPizzeria;
import pe.upc.bench.repositorios.RepositorioProducto;
import pe.upc.bench.repositorios.RepositorioProductoOferta;

@Service
public class ServicioProductoPedido {

	@Autowired
	private RepositorioPedido repositorioPedido;
	
	@Autowired
	private RepositorioProducto repositorioProducto;
	
	@Autowired
	private RepositorioPedidoProducto repositorioPedidoProducto;
	
	@Autowired
	private RepositorioPizzeria repositorioPizzeria;
	
	@Autowired
	private RepositorioOferta repositorioOferta;
	
	@Autowired
	private RepositorioProductoOferta repositorioProductoOferta;
	
	
	//OBTENER PEDIDO 
	public Pedido obtenerPedido(Long codigo) throws Exception {
		Pedido p;
		p=repositorioPedido.buscarPedido(codigo);
		if (p==null)throw new Exception("pedido no encontrado");
		return p;
	}
	
	//REGISTRAR PRODUCTO
	@Transactional(rollbackFor = Exception.class)
	public Producto registrarProducto(Long codigo,Producto producto) throws Exception {
		Pizzeria pizzeria=obtenerPizzeria(codigo);
		producto.setPizzeria(pizzeria);
		return repositorioProducto.save(producto);
	}
	
	
	//OBTENER PRODUCTO
	public Producto obtenerProducto(Long codigo) throws Exception {
		Producto p;
		p=repositorioProducto.buscarProducto(codigo);
		if(p==null)throw new Exception("pedido no encontrado");
		return p;
	}
	
	
	
	//REGISTRAR PEDIDO PRODUCTO
	@Transactional(rollbackFor = Exception.class)
	public Pedido_Producto registrarPedidoProducto(Long codigo,Long codigo2,Pedido_Producto pedido_Producto) throws Exception {
		Pedido pedido=obtenerPedido(codigo);
	    pedido_Producto.setPedido(pedido);
	    Producto producto=obtenerProducto(codigo2);
	    pedido_Producto.setProducto(producto);
	    return repositorioPedidoProducto.save(pedido_Producto);
	}
	
	
	//REGISTRAR PIZZERIA
		@Transactional(rollbackFor = Exception.class)
		public Pizzeria registrarPizzeria(Pizzeria pizzeria) throws Exception {
			if(pizzeria.getCodigo()==null) {
				return repositorioPizzeria.save(pizzeria);
			}else {
				throw new Exception();
			}
		}
		
		//ACTUALIZAR DATOS DE LA PIZZERIA 
		public Pizzeria actualizarPizzeria(Pizzeria pizzeria) throws Exception {
			if(pizzeria.getCodigo()!=null) {
				return repositorioPizzeria.saveAndFlush(pizzeria);
			}else {
				throw new Exception();
			}
		}
		
		
		
		//OBTENER DATOS DE LA PIZZERIA
		public Pizzeria obtenerPizzeria(Long codigo) throws Exception {
			Pizzeria p;
			p=repositorioPizzeria.obtenerPizzeria(codigo);
			if(p==null) throw new Exception("entidad no encontrada");
			return p;
		}
		
		
		//REGISTRAR UNA OFERTA 
		@Transactional(rollbackFor = Exception.class)
		public Oferta registrarOferta(Long codigo,Oferta oferta) throws Exception {
			Pizzeria pizzeria=obtenerPizzeria(codigo);
			oferta.setPizzeria(pizzeria);
			return repositorioOferta.save(oferta);
		}
		
		
		//ACTUALIZAR UNA OFERTA
		public Oferta actualizarOferta(Oferta oferta) throws Exception {

			if(oferta.getCodigo()!=null) {
				return repositorioOferta.saveAndFlush(oferta);
			}else {
				throw new Exception();
			}
			
		}
		
		//OBTENER OFERTA
		public Oferta obtenerOferta(Long codigo) throws Exception {
			Oferta o;
			o=repositorioOferta.buscarOferta(codigo);
			if(o==null) throw new Exception("entidad no encontrada");
			return o;
		}
		
		
		
		//ELIMINAR UNA OFERTA
		public Oferta eliminarOferta(Long  codigo) throws Exception {
			Oferta o;
			o=obtenerOferta(codigo);
			if(o.getCodigo()!=null) {
				repositorioOferta.delete(o);
			}else {
				throw new Exception();
			}
			return o;
		}
		
		
		//REGISTRAR PRODUCTO OFERTA
		@Transactional(rollbackFor = Exception.class)
		public Producto_Oferta registrarProductoOferta(Long codigo, Long codigo2, Producto_Oferta producto_Oferta) throws Exception {
			Producto producto=obtenerProducto(codigo);
			producto_Oferta.setProducto(producto);
			Oferta oferta=obtenerOferta(codigo2);
			producto_Oferta.setOferta(oferta);
			return repositorioProductoOferta.save(producto_Oferta);
		}
		
	
}
