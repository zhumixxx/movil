package edu.ucacue.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "detalle_facturas")
public class DetalleFactura implements Serializable {
	
	private static final long serialVersionUID = 1607830177598686701L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalleFactura;
	
	private int cantidad;
	private double valorVenta;

	@ManyToOne
	@JoinColumn(name = "producto_fk")
	private Producto producto;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "factura_cabecera_fk")
	private FacturaCabecera facturaCabecera;

	public DetalleFactura() {
		
	}

	public DetalleFactura(int cantidad, double valorVenta, Producto producto,
			FacturaCabecera facturaCabecera) {
		super();
		this.cantidad = cantidad;
		this.valorVenta = this.cantidad * producto.getPrecio();
		this.producto = producto;
		this.facturaCabecera = facturaCabecera;
	}
	
	public int getIdDetalleFactura() {
		return idDetalleFactura;
	}

	public void setIdDetalleFactura(Integer idDetalleFactura) {
		this.idDetalleFactura = idDetalleFactura;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getValorVenta() {
		return valorVenta;
	}

	public void setValorVenta(double valorVenta) {
		this.valorVenta = valorVenta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public FacturaCabecera getFacturaCabecera() {
		return facturaCabecera;
	}

	public void setFacturaCabecera(FacturaCabecera facturaCabecera) {
		this.facturaCabecera = facturaCabecera;
	}


	}
