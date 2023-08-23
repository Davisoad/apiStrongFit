package br.com.strongfit.myapistrongfit.model.repositories;

import br.com.strongfit.myapistrongfit.model.entities.Treino;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TreinoRepository extends PagingAndSortingRepository<Treino, Long> {
}
