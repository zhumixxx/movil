package edu.ucacue.infraestructura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.ucacue.modelo.DetalleFactura;

public interface DetallesFactura extends JpaRepository<DetalleFactura, Integer>{
	
	@Query("select dF from DetalleFactura dF where dF.facturaCabecera.id = :id")
	List<DetalleFactura> findAllByIDCabeceraFactura(@Param("id") int id);
}