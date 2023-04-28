package com.projectdev.agenciabf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectdev.agenciabf.entities.Cliente;
import com.projectdev.agenciabf.repositories.ClienteRepository;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/buscartodos")
	public List<Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/buscarpornome/{nome}")
	public Cliente buscarTodos(@PathVariable(value="nome") String nome){
		List<Cliente> todosClientes = clienteRepository.findAll();
		for(Cliente cliente : todosClientes) {
			if(cliente.getNome().equalsIgnoreCase(nome)) {
				return cliente;
			}
		}
		return null;
	}
	
	@PostMapping("/adicionar")
	public String adicionar(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente.getNome();
	}
	
	@PutMapping("/editar")
	public String editar(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente.getNome();
	}
	
	@DeleteMapping("/excluir")
	public void excluir(@RequestBody Cliente cliente) {
		clienteRepository.delete(cliente);
	}
}
