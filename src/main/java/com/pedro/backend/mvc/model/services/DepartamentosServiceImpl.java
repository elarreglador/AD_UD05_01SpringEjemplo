package com.pedro.backend.mvc.model.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.backend.mvc.model.dao.IDepartamentosDAO;
import com.pedro.backend.mvc.model.entity.Departamentos;
import com.pedro.backend.mvc.model.entity.Empleados;

@Service
public class DepartamentosServiceImpl implements IDepartamentosService {
	@Autowired
	private IDepartamentosDAO departamentosDAO;
	
	@Override
	public List<Departamentos> findAll(){
		return (List<Departamentos>)departamentosDAO.findAll();
	}

	@Override
	public Departamentos findById(int id) {
		return departamentosDAO.findById(id).orElse(null);
	}

	@Override
	public void save(Departamentos dep) {
		departamentosDAO.save(dep);
		
	}

	@Override
	public void delete(Departamentos dep) {
		departamentosDAO.delete(dep);
	}

	@Override
	public void delEmpleado(Departamentos dep, Empleados e) {
		 Set<Empleados> empleados = dep.getEmpleadoses();
		 empleados.remove(e);
		 dep.setEmpleadoses(empleados);
	}
	
	@Override
	public void addEmpleado(Departamentos dep, Empleados e) {
		Set<Empleados> empleados = dep.getEmpleadoses();
		empleados.add(e);
		dep.setEmpleadoses(empleados);
	}

}
