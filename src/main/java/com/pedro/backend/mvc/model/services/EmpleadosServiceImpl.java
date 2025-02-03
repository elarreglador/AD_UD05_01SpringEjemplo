package com.pedro.backend.mvc.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.backend.mvc.model.dao.IEmpleadosDAO;
import com.pedro.backend.mvc.model.entity.Empleados;

@Service
public class EmpleadosServiceImpl implements IEmpleadosService {

	@Autowired
	private IEmpleadosDAO empleadosDAO;
	
	@Override
	public List<Empleados> findAll(){
		return (List<Empleados>)empleadosDAO.findAll();
	}
	
	@Override
	public Empleados findById(int id) {
		return empleadosDAO.findById(id).orElse(null);
	}
	
	@Override
	public void save(Empleados e) {
		empleadosDAO.save(e);
	}
	
	@Override
	public void delete(Empleados e) {
		empleadosDAO.delete(e);
	}

}
