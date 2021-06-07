package com.sistema.venda.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.venda.model.Cliente;
import com.sistema.venda.services.ClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("http://localhost:4200")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente clientes) throws Exception{
	Cliente cliente = this.clienteService.create(clientes);
		return ResponseEntity.ok().body(cliente);
	}
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> cliente = this.clienteService.findAll();
		return ResponseEntity.ok(cliente);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable(name="id") Integer id) throws Exception{
		Cliente cliente = clienteService.findbyId(id);
		
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id){
		this.clienteService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<Cliente> update(@Valid @PathVariable(name = "id") Integer id, @RequestBody Cliente cliente) throws Exception{
		
		Cliente cli = this.clienteService.update(id, cliente);
		return ResponseEntity.ok(cli);
	}
}
