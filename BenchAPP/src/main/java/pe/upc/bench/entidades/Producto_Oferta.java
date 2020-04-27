package pe.upc.bench.entidades;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="PRODUCTO_OFERTA")
public class Producto_Oferta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_PRODUCTO_OFERTA")
	private Long codigo;
	private String fecha_inicio;
	private String fecha_fin;
	private double descuento;
	private double total;
	
	@ManyToOne
	@JoinColumn(name="ID_PRODUCTO")
	@JsonIgnore
	private Producto producto;
	
	
	@ManyToOne
	@JoinColumn(name="ID_OFERTA")
	@JsonIgnore
	private Oferta oferta;


	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public String getFecha_inicio() {
		return fecha_inicio;
	}


	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}


	public String getFecha_fin() {
		return fecha_fin;
	}


	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}


	public double getDescuento() {
		return descuento;
	}


	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
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


	
	

	
	

}
