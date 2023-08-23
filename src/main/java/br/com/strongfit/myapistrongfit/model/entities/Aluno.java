package br.com.strongfit.myapistrongfit.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "aluno", schema = "operation")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alunoId;
    @Column(columnDefinition = "text")
    private String nome;
    private LocalDateTime dataNascimento;
    @Column(columnDefinition = "text")
    private String email;
    @Column(columnDefinition = "text")
    private String instagram;
    @Column(columnDefinition = "text")
    private String telefone;
    @Column(name = "personalId")
    private Long personal_Id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "personalId", insertable = false, updatable = false)
    private Personal personal;
    @Column(columnDefinition = "text")
    private String observacoes;
    @JsonIgnore
    @OneToMany(mappedBy = "aluno")
    private List<Treino> treinos;

    public Aluno() {
    }

    public Aluno(String nome, LocalDateTime dataNascimento, String email, String instagram, String telefone, Personal personal, String observacoes, Long personalId, List<Treino> treinos) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.instagram = instagram;
        this.telefone = telefone;
        this.personal = personal;
        this.observacoes = observacoes;
        this.personal_Id = personalId;
        this.treinos = treinos;
    }

    public Long getPersonalId() {
        return personal_Id;
    }

    public void setPersonalId(Long personalId) {
        this.personal_Id = personalId;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public List<Treino> getTreinos() {
        return treinos;
    }

    public void setTreinos(List<Treino> treinos) {
        this.treinos = treinos;
    }
}
