package com.waldecleber.osworks;

import com.waldecleber.osworks.dto.ClienteDTO;
import com.waldecleber.osworks.exception.ClienteDuplicadoException;
import com.waldecleber.osworks.model.Cliente;
import com.waldecleber.osworks.repository.ClienteRepository;
import com.waldecleber.osworks.service.ClienteService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientesServiceTest {
	
	private ClienteService clienteService;
	private ClienteRepository clienteRepository;
	private ModelMapper mapper;
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Before
	public void setup() {		
		clienteRepository = mock(ClienteRepository.class);
		mapper = mock(ModelMapper.class);
		clienteService = new ClienteService(clienteRepository, mapper);
	}

	@Test
	public void listarTodosClientes() {
		//given (cenario)
		ClienteDTO cliente = ClienteDTO.builder()
				.nome("Cliente 01")
				.telefone("9999-0000")
				.email("cliente@teste.com")
				.cpf("17482812164")
				.build();

		ClienteDTO dto =
				ClienteDTO.builder()
						.nome("Cliente 01")
						.telefone("9999-0000")
						.email("cliente@teste.com")
						.cpf("17482812164")
						.build();

		//action
		List<ClienteDTO> clientes = clienteService.listarClientes();

		//assert
		error.checkThat(clientes.size(), is(1));
	}

}
