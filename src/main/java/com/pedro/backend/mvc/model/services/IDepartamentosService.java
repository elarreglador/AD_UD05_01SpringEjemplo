package com.pedro.backend.mvc.model.services;

import java.util.List;

import com.pedro.backend.mvc.model.entity.Departamentos;
import com.pedro.backend.mvc.model.entity.Empleados;

public interface IDepartamentosService {
	
	public List<Departamentos> findAll();

	public Departamentos findById(
			int id);
	
	public void save(
			Departamentos d);
	
	public void delete(
			Departamentos d);

	public void delEmpleado(
			Departamentos dep, 
			Empleados e);

	public void addEmpleado(
			Departamentos dep, 
			Empleados e);

}
