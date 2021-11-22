package com.almacenamiento.demo.models.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.almacenamiento.demo.models.entity.Asignar;

@Transactional
@Repository
public interface AsignarRepository extends CrudRepository<Asignar, Long> {
	@Query("select a from Asignar a inner join Almacen  alm on a.almacen.idalmacenes = alm.idalmacenes  inner join Producto p on a.producto.idproductos=p.idproductos where a.almacen.idalmacenes=?1 and a.producto.idproductos=?2")
	public List<Asignar> findByAlmacenAndProducto(Long idalmacenes, Long idproductos);
	@Query("select a from Asignar a inner join Almacen  alm on a.almacen.idalmacenes = alm.idalmacenes  where a.almacen.idalmacenes=?1")
	public List<Asignar> findByAlmacen(Long idalmacenes);
	
	@Modifying
	@Query("UPDATE Asignar a SET a.cantidad_asignada=a.cantidad_asignada+?1 WHERE a.almacen.idalmacenes=?2 and a.producto.idproductos=?3")
	public void update(int cantidad,Long idalmacenes, Long idproductos);
	
	@Modifying
	@Query("UPDATE Asignar a SET a.cantidad_asignada=a.cantidad_asignada-?1 WHERE a.almacen.idalmacenes=?2 and a.producto.idproductos=?3")
	public void updatesalida(int cantidad,Long idalmacenes, Long idproductos);
	
	
}	
