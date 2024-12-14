package com.challenge.crud_exceptions_and_validations.repositories;

import com.challenge.crud_exceptions_and_validations.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
