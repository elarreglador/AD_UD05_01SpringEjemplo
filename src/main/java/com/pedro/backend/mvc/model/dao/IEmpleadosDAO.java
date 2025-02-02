package com.pedro.backend.mvc.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.pedro.backend.mvc.model.entity.Empleados;

public interface IEmpleadosDAO extends CrudRepository<Empleados, Integer> {

	
}
