package edu.ucacue.infraestructura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.ucacue.modelo.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
	
	@Query("select prod from Producto prod where prod.nombre like %:nombre%")
	List<Producto> findAllByNombre(String nombre);

}
