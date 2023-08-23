package br.com.strongfit.myapistrongfit.controllers;

import br.com.strongfit.myapistrongfit.model.entities.Exercicio;
import br.com.strongfit.myapistrongfit.model.repositories.ExercicioRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/exercicio")
public class ExercicioController {

    @Autowired
    private ExercicioRepository exercicioRepository;

    @GetMapping
    public Iterable<Exercicio> getExercicio() {
        return exercicioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Exercicio> postExercicio(@Valid @RequestBody Exercicio exercicio) {
        return ResponseEntity.ok(exercicioRepository.save(exercicio));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Exercicio> putExercicio(@PathVariable(name = "id") Long id,
                                                  @Valid @RequestBody Exercicio exercicioPut) {

        Exercicio exercicio = exercicioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Exercicio não encontrado!"));

        exercicio.setNome(exercicioPut.getNome());
        exercicio.setCategoria(exercicioPut.getCategoria());
        exercicio.setDescricao(exercicioPut.getDescricao());

        return ResponseEntity.ok(exercicioRepository.save(exercicio));
    }

    @GetMapping(path = "{id}")
    public Optional<Exercicio> getExercicioId(@PathVariable(name = "id") Long id) {
        return exercicioRepository.findById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteExercicio(@PathVariable(name = "id") Long id) {
        exercicioRepository.deleteById(id);
    }

}
