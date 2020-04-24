package pe.bench.relaciones.entidades;

import java.util.Date;
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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TP_OFERTA")
public class Oferta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_Oferta")
	private Long codigo;
	private String titulo;
	private String descripcion;
	private Date fecha_inicio;
	private Date fecha_final;
	@ManyToOne
	@JoinColumn(name="id_Pizzeria")
	@JsonIgnore
	private Pizzeria pizzeria;
	private Long prueba;
	@JoinTable(name="oferta_producto",joinColumns =@JoinColumn(name="fk_oferta"),inverseJoinColumns = @JoinColumn(name="fk_producto") )
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Producto> productos;
	
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_final() {
		return fecha_final;
	}
	public void setFecha_final(Date fecha_final) {
		this.fecha_final = fecha_final;
	}
	public Pizzeria getPizzeria() {
		return pizzeria;
	}
	public void setPizzeria(Pizzeria pizzeria) {
		this.pizzeria = pizzeria;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	

}
