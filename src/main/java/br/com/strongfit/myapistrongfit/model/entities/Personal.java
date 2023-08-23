package br.com.strongfit.myapistrongfit.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "personal", schema = "operation")
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personal_id;
    @Column(columnDefinition = "text")
    private String nome;
    @Column(columnDefinition = "text")
    private String especialidade;
    @OneToMany(mappedBy = "personal")
    @JsonIgnore
    private List<Aluno> alunos;

    public Personal() {
    }

    public Personal(String nome, String especialidade, List<Aluno> alunos) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.alunos = alunos;
    }

    public Long getPersonal_id() {
        return personal_id;
    }

    public void setPersonal_id(Long personal_id) {
        this.personal_id = personal_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
