package pe.bench.relaciones.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TP_PEDIDO")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_Pedido")
	private Long codigo;
	private Long costo_total;
	private String direccion;
	@ManyToOne
	@JoinColumn(name="id_cliente")
	@JsonIgnore
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Producto_Pedido> productos_pedido;
	
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Long getCosto_total() {
		return costo_total;
	}
	public void setCosto_total(Long costo_total) {
		this.costo_total = costo_total;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Producto_Pedido> getProductos_pedido() {
		return productos_pedido;
	}
	public void setProductos_pedido(List<Producto_Pedido> productos_pedido) {
		this.productos_pedido = productos_pedido;
	}
	



}
