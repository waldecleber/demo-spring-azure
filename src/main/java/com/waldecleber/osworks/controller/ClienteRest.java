package com.waldecleber.osworks.controller;

import com.waldecleber.osworks.dto.ClienteDTO;
import com.waldecleber.osworks.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

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

}
