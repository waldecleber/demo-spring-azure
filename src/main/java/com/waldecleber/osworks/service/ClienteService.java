package com.waldecleber.osworks.service;

import com.waldecleber.osworks.dto.ClienteDTO;
import com.waldecleber.osworks.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ClienteService {
	
	private final ClienteRepository clienteRepository;
	private final ModelMapper mapper;
	
	@Autowired
	public ClienteService(ClienteRepository clienteRepository, ModelMapper mapper) {
		this.clienteRepository = clienteRepository;
		this.mapper = mapper;
	}
	
	public List<ClienteDTO> listarClientes() {
		ClienteDTO cliente = ClienteDTO.builder()
				.nome("Cliente 01")
				.telefone("9999-0000")
				.email("cliente@teste.com")
				.cpf("17482812164")
				.build();

		return Collections.singletonList(cliente);
	}
}
