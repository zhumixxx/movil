package edu.ucacue.modelo;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "facturas_cabecera")
public class FacturaCabecera implements Serializable{

	private static final long serialVersionUID = 1607830177598686701L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Generated(GenerationTime.INSERT)
	@Column(columnDefinition = "serial ", unique = true)
	private Integer numeroFactura;

    private Double total;
	private Date fechaCompra;
	
    @ManyToOne
	@JoinColumn(name = "cliente_fk")
	private Persona cliente;
    
    @JsonBackReference
	@OneToMany(mappedBy = "facturaCabecera", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<DetalleFactura> detallesFacturas;

	public FacturaCabecera() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public List<DetalleFactura> getDetallesFacturas() {
		return detallesFacturas;
	}

	public void setDetallesFacturas(List<DetalleFactura> detallesFacturas) {
		this.detallesFacturas = detallesFacturas;
		double total = 0;
		for (DetalleFactura detalleFactura : detallesFacturas) {
			total = total + detalleFactura.getValorVenta();
		}
		this.total = total;
	}
	
	
	}
