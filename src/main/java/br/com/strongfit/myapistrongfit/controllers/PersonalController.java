package br.com.strongfit.myapistrongfit.controllers;

import br.com.strongfit.myapistrongfit.model.entities.Personal;
import br.com.strongfit.myapistrongfit.model.repositories.PersonalRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/personal")
public class PersonalController {

    @Autowired
    private PersonalRepository personalRepository;

    @GetMapping
    public Iterable<Personal> getPersonal() {
        return personalRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Personal> postPersonal(@Valid @RequestBody Personal personal) {
        return ResponseEntity.ok(personalRepository.save(personal));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Personal> putPersonal(@PathVariable("id") Long id,
                                                @Valid @RequestBody Personal personalAtualizar) {
        Personal personal = personalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Personal não encontrado!"));

        personal.setNome(personalAtualizar.getNome());
        personal.setEspecialidade(personalAtualizar.getEspecialidade());

        return ResponseEntity.ok(personalRepository.save(personal));
    }

    @GetMapping(path = "/{id}")
    public Optional<Personal> getPersonalId(@PathVariable Long id) {
        return personalRepository.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePersonal(@PathVariable Long id) {
        personalRepository.deleteById(id);
    }
}
