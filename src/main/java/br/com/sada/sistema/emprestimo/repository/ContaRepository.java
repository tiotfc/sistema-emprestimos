package br.com.sada.sistema.emprestimo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sada.sistema.emprestimo.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
