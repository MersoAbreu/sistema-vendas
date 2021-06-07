package com.sistema.venda.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.venda.model.Cliente;
import com.sistema.venda.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	//Metodo de criação de clientes
	public Cliente create(Cliente cliente) throws Exception {
		List<Cliente> clientes = findAll();
		
		if(clientes.equals(cliente.getCpf()))
		{
			throw new Exception("Cliente já cadastrado");
			
		}
		Cliente cli = clienteRepository.save(cliente);
		return cli;
		
	}
	
	public List<Cliente> findAll(){
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes;
	}
	
	public Cliente findbyId(Integer id) throws Exception{
		Optional<Cliente> cliente = this.clienteRepository.findById(id);
		if(!cliente.isPresent()) {
			throw new Exception("Cliente não encontrado");
		}
		return cliente.get();

	}
	
	public void delete(Integer id){
	Optional<Cliente> cliente = clienteRepository.findById(id);
	if(cliente != null) {
		clienteRepository.deleteById(id);
	}else {
		try {
			
		} catch (Exception e) {
			throw e;
		}
	}
}

	public Cliente update(Integer id, Cliente cliente) throws Exception {

		try {
			Cliente cli = this.findbyId(id);
			cli.setNome(cliente.getNome());
			cli.setCpf(cliente.getCpf());

			if (cliente.getDataCadastro()==null) {
				cli.setDataCadastro(cli.getDataCadastro());
			}else {
				cli.setDataCadastro(cliente.getDataCadastro());
			}
			cliente = this.clienteRepository.saveAndFlush(cli);

		} catch (Exception e) {
			throw e;
		}
		return cliente;
	}
}
