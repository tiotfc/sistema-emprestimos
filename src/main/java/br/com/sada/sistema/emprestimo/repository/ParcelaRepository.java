package br.com.sada.sistema.emprestimo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sada.sistema.emprestimo.model.Parcela;

public interface ParcelaRepository extends JpaRepository<Parcela, Integer> {

}
