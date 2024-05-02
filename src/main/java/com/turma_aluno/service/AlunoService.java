package com.turma_aluno.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.turma_aluno.entities.Aluno;
import com.turma_aluno.repository.AlunoRepository;


@Service
public class AlunoService {
	
	private final AlunoRepository AlunoRepository;
	
	@Autowired
	public AlunoService (AlunoRepository AlunoRepository) {
		this.AlunoRepository = AlunoRepository;
	}
		//Query Method
		public List<Aluno> buscarAlunosPorRenda(Double renda){
			return AlunoRepository.findByRenda(renda);
		}
		//Query Method
		public List<Aluno> buscarAlunosPorRa(String ra){
			return AlunoRepository.findByRa(ra);
		}
		//Query Method
		public List<Aluno> buscarCidadeERenda(String cidade, Double renda){
			return AlunoRepository.findByCidadeAndRenda(cidade, renda);
		}
		
		@Query
		public List<Aluno> findByNome (String nome){
			return AlunoRepository.findByNome(nome);
		}
		@Query
		public List<Aluno> findByNomeCompleto (String nomeCompleto){
			return AlunoRepository.findByNomeLike(nomeCompleto);
		}
	
	    public List<Aluno> getAllAluno() {
	        return AlunoRepository.findAll();
	    }

	    public Aluno getAlunoById(Long id) {
	        Optional<Aluno> Aluno = AlunoRepository.findById(id);
	        return Aluno.orElse(null);
	    }

	    public Aluno salvarAluno(Aluno Aluno) {
	        return AlunoRepository.save(Aluno);
	    }

	    public Aluno updateAluno(Long id, Aluno updatedAluno) {
	        Optional<Aluno> existingAluno = AlunoRepository.findById(id);
	        if (existingAluno.isPresent()) {
	            updatedAluno.setId(id);
	            return AlunoRepository.save(updatedAluno);
	        }
	        return null;
	    }
	    public boolean deleteAluno(Long id) {
	        Optional<Aluno> existingAluno = AlunoRepository.findById(id);
	        if (existingAluno.isPresent()) {
	        	AlunoRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }

	}