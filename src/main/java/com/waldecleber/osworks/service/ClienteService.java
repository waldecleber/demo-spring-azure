package com.waldecleber.osworks.service;


import com.waldecleber.osworks.dto.ClienteDTO;
import com.waldecleber.osworks.exception.ClienteNaoEncontrado;
import com.waldecleber.osworks.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        return clienteRepository.findAll().stream()
                .map(cliente -> mapper.map(cliente, ClienteDTO.class))
                .collect(Collectors.toList());
    }

    public ClienteDTO buscarClientePorNome(String nome) {
        return clienteRepository.findByNome(nome)
                .map(cliente -> mapper.map(cliente, ClienteDTO.class))
                .orElseThrow(() -> new ClienteNaoEncontrado("Cliente não encontrado"));
    }

    public ClienteDTO buscarClientePorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf)
                .map(cliente -> mapper.map(cliente, ClienteDTO.class))
                .orElseThrow(() -> new ClienteNaoEncontrado("Cliente não encontrado"));
    }

}
