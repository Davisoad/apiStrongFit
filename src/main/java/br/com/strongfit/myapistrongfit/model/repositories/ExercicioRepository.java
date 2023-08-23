package br.com.strongfit.myapistrongfit.model.repositories;

import br.com.strongfit.myapistrongfit.model.entities.Exercicio;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExercicioRepository extends PagingAndSortingRepository<Exercicio, Long> {
}
