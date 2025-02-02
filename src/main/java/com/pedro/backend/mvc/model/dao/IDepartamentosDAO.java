package com.pedro.backend.mvc.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.pedro.backend.mvc.model.entity.Departamentos;

public interface IDepartamentosDAO extends CrudRepository<Departamentos, Integer> {

}
