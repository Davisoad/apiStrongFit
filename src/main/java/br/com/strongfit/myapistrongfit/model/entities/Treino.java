package br.com.strongfit.myapistrongfit.model.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "treino", schema = "operation")
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long treinoId;
    @ManyToOne
    @JoinColumn(name = "alunoId", insertable = false, updatable = false)
    private Aluno aluno;
    private LocalDateTime dataHora;
    @ManyToMany(mappedBy = "treinos")
    private List<Exercicio> exercicios = new ArrayList<>();

    public Treino() {
    }

    public Treino(Aluno aluno, LocalDateTime dataHora, List<Exercicio> exercicios) {
        this.aluno = aluno;
        this.dataHora = dataHora;
        this.exercicios = exercicios;
    }

    public Long getTreinoId() {
        return treinoId;
    }

    public void setTreinoId(Long treinoId) {
        this.treinoId = treinoId;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }
}
