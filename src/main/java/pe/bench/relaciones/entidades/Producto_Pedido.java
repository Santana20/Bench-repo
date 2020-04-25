package pe.bench.relaciones.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TP_PRODUCTO_PEDIDO")
public class Producto_Pedido implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_PedidoProducto")
	private Long codigo;
	@ManyToOne
	@JoinColumn(name="id_Producto")
	@JsonIgnore
	private Producto producto;
	@ManyToOne
	@JoinColumn(name="id_Pedido")
	@JsonIgnore
	private Pedido pedido;
	private Long cantidad_pedida;
	private Double precio;
	
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Long getCantidad_pedida() {
		return cantidad_pedida;
	}
	public void setCantidad_pedida(Long cantidad_pedida) {
		this.cantidad_pedida = cantidad_pedida;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
