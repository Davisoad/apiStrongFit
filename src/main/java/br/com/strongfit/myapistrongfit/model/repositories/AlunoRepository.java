package br.com.strongfit.myapistrongfit.model.repositories;

import br.com.strongfit.myapistrongfit.model.entities.Aluno;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AlunoRepository extends PagingAndSortingRepository<Aluno, Long> {
}
