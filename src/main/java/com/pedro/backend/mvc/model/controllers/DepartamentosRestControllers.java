package com.pedro.backend.mvc.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pedro.backend.mvc.model.entity.Departamentos;
import com.pedro.backend.mvc.model.services.IDepartamentosService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class DepartamentosRestControllers {
	
	@Autowired
	private IDepartamentosService departamentosService;
	
	@GetMapping("/departamentos")
	public List<Departamentos> getAllEmpleados(){
		return departamentosService.findAll();
	}
	
	@GetMapping("departamentos/about")
	public String about() {
		return " David Moreno<br>"
				+ " CFS2 - Acceso a Datos<br>"
				+ " febrero de 2025";
	}

}
