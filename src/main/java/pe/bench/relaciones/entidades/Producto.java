package pe.bench.relaciones.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TP_PRODUCTO")
public class Producto implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_Producto")
	private Long codigo;
	private String nombre;
	private String descripcion;
	private Double precio;
	@ManyToOne
	@JoinColumn(name="id_Pizzeria")
	@JsonIgnore
	private Pizzeria pizzeria; 
	@OneToMany(mappedBy = "producto", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Oferta_Producto> oferta_productos;
	
	@OneToMany(mappedBy = "producto", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Producto_Pedido> productos_pedido;
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Pizzeria getPizzeria() {
		return pizzeria;
	}
	public void setPizzeria(Pizzeria pizzeria) {
		this.pizzeria = pizzeria;
	}
	public List<Oferta_Producto> getOferta_productos() {
		return oferta_productos;
	}
	public void setOferta_productos(List<Oferta_Producto> oferta_productos) {
		this.oferta_productos = oferta_productos;
	}
	public List<Producto_Pedido> getProductos_pedido() {
		return productos_pedido;
	}
	public void setProductos_pedido(List<Producto_Pedido> productos_pedido) {
		this.productos_pedido = productos_pedido;
	}


}
