package com.pedro.backend.mvc.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public List<Departamentos> getAllDepartamentos(){
		return departamentosService.findAll();
	}
	
	@GetMapping("departamentos/about")
	public String about() {
		return " David Moreno<br>"
				+ " CFS2 - Acceso a Datos<br>"
				+ " febrero de 2025";
	}
	
	// Crea un nuevo departamento
	@PostMapping("/departamentos") // controla peticiones POST
	@ResponseStatus(HttpStatus.CREATED)
	public Departamentos create(
			// Recupera el body y lo hace obj departamento
			@RequestBody Departamentos dep) {
		departamentosService.save(dep);
		return dep;
	}
	
	// Obtiene un departamento en concreto
	@GetMapping("/departamentos/{id}") // controla peticiones GET
	public Departamentos getDepartamentosById(@PathVariable int id) {
		return departamentosService.findById(id);
	}
	
	// Elimina un departamento concreto
	@DeleteMapping("/departamentos/{id}") // controla peticiones DEL
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		Departamentos dep = departamentosService.findById(id);
		departamentosService.delete(dep);
	}
	
	// Actualiza el departamento id con la info del @RequestBody
	@PutMapping("/departamentos/{id}") // controla peticiones PUT
	@ResponseStatus(HttpStatus.CREATED)
	public Departamentos update(
			// Recupera el body y lo hace obj Departamentos
			@RequestBody Departamentos departamentoRecibido, 
			@PathVariable int id) {
		
		Departamentos departamentoActualizado = 
				departamentosService.findById(id);
		
		departamentoActualizado.setDnombre(departamentoRecibido.getDnombre() );
		departamentoActualizado.setEmpleadoses(
				departamentoRecibido.getEmpleadoses() );
		departamentoActualizado.setLoc(departamentoRecibido.getLoc() );
		
		departamentosService.save(departamentoActualizado);
		return departamentoActualizado;
	}
	

}
