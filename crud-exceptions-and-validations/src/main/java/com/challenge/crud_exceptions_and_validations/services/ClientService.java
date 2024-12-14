package com.challenge.crud_exceptions_and_validations.services;

import com.challenge.crud_exceptions_and_validations.dto.ClientDTO;
import com.challenge.crud_exceptions_and_validations.entities.Client;
import com.challenge.crud_exceptions_and_validations.repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado.")
        );

        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(client -> new ClientDTO(client));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client client = new Client();
        copyDtoToClient(dto, client);
        client =repository.save(client);

        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        try {
            Client client = repository.getReferenceById(id);
            copyDtoToClient(dto, client);

            client = repository.save(client);

            return new ClientDTO(client);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não foi encontrado");
        }
    }

    @Transactional
    public void delete(Long id) {
        if(!repository.existsById(id)) throw new ResourceNotFoundException("Recurso não encontrado");

        repository.deleteById(id);
    }

    private void copyDtoToClient(ClientDTO dto, Client client) {
        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setIncome(dto.getIncome());
        client.setBirthDate(dto.getBirthDate());
        client.setChildren(dto.getChildren());
    }

}
