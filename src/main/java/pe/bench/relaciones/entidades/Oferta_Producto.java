package pe.bench.relaciones.entidades;

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
@Table(name="TP_OFERTA_PRODUCTO")


public class Oferta_Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_OferProducto")
	private Long codigo;
	@ManyToOne
	@JoinColumn(name="id_Producto")
	@JsonIgnore
	private Producto producto;
	@ManyToOne
	@JoinColumn(name="id_Oferta")
	@JsonIgnore
	private Oferta oferta;
	private Long cantidad_pedida;
	private Double precio;
	private Double subtotal;
	
	
	
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
	public Oferta getOferta() {
		return oferta;
	}
	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
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
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	
	
}
