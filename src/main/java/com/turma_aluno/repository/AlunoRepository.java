package com.turma_aluno.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.turma_aluno.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	List<Aluno> findByRenda(Double renda);
	List<Aluno> findByRa(String ra);
	List<Aluno> findByCidadeAndRenda(String cidade, Double renda);
	
	@Query("SELECT a FROM Aluno a WHERE a.nome = :nome")
	List<Aluno> findByNome(@Param("nome")String nome);
	
	@Query("SELECT a FROM Aluno a WHERE a.nomeCompleto = :nomeCompleto")
	List<Aluno> findByNomeLike(@Param("nome completo")String nomeCompleto);
	
	@Query("SELECT a FROM Aluno a JOIN a.turma t WHERE t.id = :turmaId")
	List<Aluno> findyByTurmaId(@Param("turmaId")Long turmaId);
}