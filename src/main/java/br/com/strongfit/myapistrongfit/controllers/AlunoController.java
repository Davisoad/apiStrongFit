package br.com.strongfit.myapistrongfit.controllers;

import br.com.strongfit.myapistrongfit.model.entities.Aluno;
import br.com.strongfit.myapistrongfit.model.repositories.AlunoRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public Iterable<Aluno> getAluno() {
        return alunoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Aluno> postAluno(@Valid @RequestBody Aluno aluno) {
        return ResponseEntity.ok(alunoRepository.save(aluno));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Aluno> putAluno(@PathVariable(name = "id") Long id,
                                          @Valid @RequestBody Aluno alunoAtualizar) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado!"));

        aluno.setDataNascimento(alunoAtualizar.getDataNascimento());
        aluno.setEmail(alunoAtualizar.getEmail());
        aluno.setInstagram(alunoAtualizar.getInstagram());
        aluno.setNome(alunoAtualizar.getNome());
        aluno.setObservacoes(alunoAtualizar.getObservacoes());
        aluno.setTelefone(alunoAtualizar.getTelefone());
        aluno.setPersonal(alunoAtualizar.getPersonal());
        return ResponseEntity.ok(alunoRepository.save(aluno));
    }

    @GetMapping(path = "/{id}")
    public Optional<Aluno> getAlunoId(@PathVariable(name = "id") Long id) {
        return alunoRepository.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAluno(@PathVariable(name = "id") Long id) {
        alunoRepository.deleteById(id);
    }
}
