package com.pedro.backend.mvc.model.services;

import java.util.List;

import com.pedro.backend.mvc.model.entity.Departamentos;
import com.pedro.backend.mvc.model.entity.Empleados;

public interface IDepartamentosService {
	public List<Departamentos> findAll();

	public Departamentos findById(int id);
	
	void save(Departamentos e);
	
	public void delete(Departamentos e);

}
