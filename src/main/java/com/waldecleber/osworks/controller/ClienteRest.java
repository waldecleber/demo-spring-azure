package com.waldecleber.osworks.controller;

import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.waldecleber.osworks.dto.ClienteDTO;
import com.waldecleber.osworks.model.Cliente;
import com.waldecleber.osworks.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteRest {

	@Autowired
	private ClienteService clienteService;

	@ApiOperation(value = "Retorna uma lista de clientes")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de clientes"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping
	public List<ClienteDTO> listarClientes() {			
		return clienteService.listarClientes();
	}
	
	@GetMapping(value = "/{cpf}")	
	public ResponseEntity<ClienteDTO> buscarClientePorCpf(@PathVariable String cpf) {			
		ClienteDTO cliente = clienteService.buscarClientePorCpf(cpf);
		if (Objects.nonNull(cliente)) {
			return ResponseEntity.ok().body(cliente);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteDTO salvar(@RequestBody ClienteDTO dto) {
		return clienteService.salvar(dto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> atualizar(@PathVariable Long id, @RequestBody ClienteDTO cliente) {
		return ResponseEntity.ok(clienteService.atualizar(id, cliente));
	}
	
}
