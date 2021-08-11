package br.com.sada.sistema.emprestimo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sada.sistema.emprestimo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
