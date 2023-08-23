package br.com.strongfit.myapistrongfit.model.repositories;

import br.com.strongfit.myapistrongfit.model.entities.Personal;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonalRepository extends PagingAndSortingRepository<Personal, Long> {
}
