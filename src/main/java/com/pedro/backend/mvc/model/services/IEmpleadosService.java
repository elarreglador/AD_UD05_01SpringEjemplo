package com.pedro.backend.mvc.model.services;

import java.util.List;
import com.pedro.backend.mvc.model.entity.Empleados;

public interface IEmpleadosService {
	
	public List<Empleados> findAll();

	Empleados findById(int id);

	void save(Empleados e);
	
	public void delete(Empleados e);

}
