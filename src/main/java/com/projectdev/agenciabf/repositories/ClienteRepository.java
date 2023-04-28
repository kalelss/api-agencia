package com.projectdev.agenciabf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectdev.agenciabf.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
