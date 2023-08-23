package br.com.strongfit.myapistrongfit.controllers;

import br.com.strongfit.myapistrongfit.model.entities.Treino;
import br.com.strongfit.myapistrongfit.model.repositories.TreinoRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/treino")
public class TreinoController {

    @Autowired
    private TreinoRepository treinoRepository;

    @GetMapping
    public Iterable<Treino> getTreino() {
        return treinoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Treino> postTreino(@Valid @RequestBody Treino treino) {
        return ResponseEntity.ok(treinoRepository.save(treino));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Treino> putTreino(@PathVariable(name = "id") Long id,
                                            @Valid @RequestBody Treino treinoPut) {

        Treino treino = treinoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Treino não encontrado!"));

        treino.setDataHora(treinoPut.getDataHora());

        return ResponseEntity.ok(treinoRepository.save(treino));
    }

    @GetMapping(path = "/{id}")
    public Optional<Treino> getTreinoId(@PathVariable(name = "id") Long id) {
        return treinoRepository.findById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTreino(@PathVariable(name = "id") Long id) {
        treinoRepository.deleteById(id);
    }
}
