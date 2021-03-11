package com.waldecleber.osworks.repository;

import com.waldecleber.osworks.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository {

	public Optional<Cliente> findByNome(String nome) {
		return findAll().stream()
				.filter(c -> c.getNome().equalsIgnoreCase(nome))
				.findAny();
	}

	public Optional<Cliente> findByCpf(String cpf) {
		return findAll().stream()
				.filter(c -> c.getCpf().equals(cpf))
				.findAny();
	}

	public boolean existsById(Long id) {
		return findAll().stream()
				.filter(c -> c.getId().equals(id))
				.findAny().isPresent();
	}

	public List<Cliente> findAll() {
		return Arrays.asList(
			Cliente.builder().id(1L).cpf("46647287787").nome("João da Silva").email("joao@email.com").telefone("519999-0000").build(),
			Cliente.builder().id(2L).cpf("84815845174").nome("Maria de Souza").email("maria@email.com").telefone("519999-0001").build(),
			Cliente.builder().id(3L).cpf("27545549805").nome("Antonio Maria").email("antonio@email.com").telefone("519999-0002").build()
		);
	}


}
