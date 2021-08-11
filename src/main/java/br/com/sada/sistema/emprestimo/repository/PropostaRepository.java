package br.com.sada.sistema.emprestimo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sada.sistema.emprestimo.model.Proposta;

public interface PropostaRepository extends JpaRepository<Proposta, Integer> {

}
