package com.pedro.backend.mvc.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pedro.backend.mvc.model.entity.Departamentos;
import com.pedro.backend.mvc.model.entity.Empleados;
import com.pedro.backend.mvc.model.services.IDepartamentosService;
import com.pedro.backend.mvc.model.services.IEmpleadosService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class EmpleadosRestControllers {
	
	@Autowired
	private IEmpleadosService empleadosService;
	
	@Autowired
	private IDepartamentosService departamentosService;
	
	// Obtiene todos los empleados
	@GetMapping("/empleados") // controla peticiones GET
	public ResponseEntity<?> getAllEmpleados(){
		
		List<Empleados> retorno = empleadosService.findAll();
		
		if (!retorno.isEmpty() ) {
			return new ResponseEntity<List<Empleados>>(retorno, HttpStatus.OK);
		} 
		return ResponseEntity.noContent().build();
	}
	
	// Crea un nuevo empleado
	@PostMapping("/empleados") // controla peticiones POST
	@ResponseStatus(HttpStatus.CREATED)
	public Empleados create(
			// Recupera el body y lo hace obj Empleado
			@RequestBody Empleados emp) {
		empleadosService.save(emp);
		return emp;
	}
	
	// Obtiene un empleado en concreto
	@GetMapping("/empleados/{id}") // controla peticiones GET
	public ResponseEntity<?> getEmpleadoById(@PathVariable int id) {
		
		Empleados empleado = empleadosService.findById(id);
		if (empleado == null) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<Empleados>(empleado, HttpStatus.OK);
	}
	
	// Elimina un empleado concreto
	@DeleteMapping("/empleados/{id}") // controla peticiones DEL
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		Empleados emp = empleadosService.findById(id);
		empleadosService.delete(emp);
	}
	
	// Indica en que departamento trabaja un empleado
	@GetMapping("/empleados/infoDep/{id}")
	public Departamentos info(
			@PathVariable int id) {
		Empleados empleado = empleadosService.findById(id);
		Departamentos departamento = empleado.getDepartamentos();
		return departamento;
	}
	
	// Actualiza el empleado id con la info del @RequestBody
	@PutMapping("/empleados/{id}") // controla peticiones PUT
	@ResponseStatus(HttpStatus.CREATED)
	public Empleados update(
			// Recupera el body y lo hace obj Empleado
			@RequestBody Empleados empleadoRecibido, 
			@PathVariable int id) {
		
		Empleados empleadoActualizado = empleadosService.findById(id);
		
		empleadoActualizado.setApellido(empleadoRecibido.getApellido() );
		empleadoActualizado.setComision(empleadoRecibido.getComision() );
		empleadoActualizado.setDir(empleadoRecibido.getDir() );
		empleadoActualizado.setFechaAlta(empleadoRecibido.getFechaAlta() );
		empleadoActualizado.setOficio(empleadoRecibido.getOficio() );
		empleadoActualizado.setSalario(empleadoRecibido.getSalario() );
		
		empleadosService.save(empleadoActualizado);
		return empleadoActualizado;
	}
	
	// Translada a un empleado a un departamento destino
	@PostMapping("/empleados/{idEmpleado}/{idDepartamento}")
	public Departamentos traslado (
			@PathVariable int idEmpleado,
			@PathVariable int idDepartamento) {
		
		Empleados empleado = empleadosService.findById(idEmpleado);
		Departamentos destino = departamentosService.findById(idDepartamento);
		
		empleado.setDepartamentos(destino);
		empleadosService.save(empleado);
		return destino;
	}
	
}
