package com.pedro.backend.mvc.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.backend.mvc.model.dao.IDepartamentosDAO;
import com.pedro.backend.mvc.model.entity.Departamentos;

@Service
public class DepartamentosServiceImpl implements IDepartamentosService {
	@Autowired
	private IDepartamentosDAO departamentosDAO;
	
	@Override
	public List<Departamentos> findAll(){
		return (List<Departamentos>)departamentosDAO.findAll();
	}

}
