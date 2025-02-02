package com.pedro.backend.mvc.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pedro.backend.mvc.model.entity.Empleados;
import com.pedro.backend.mvc.model.services.IEmpleadosService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class EmpleadosRestControllers {
	
	@Autowired
	private IEmpleadosService empleadosService;
	
	@GetMapping("/empleados")
	public List<Empleados> getAllEmpleados(){
		return empleadosService.findAll();
	}

}
