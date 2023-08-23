package br.com.strongfit.myapistrongfit.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "exercicio", schema = "operation")
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exercicioId;
    @Column(columnDefinition = "text")
    private String nome;
    @Column(columnDefinition = "text")
    private String categoria;
    @Column(columnDefinition = "text")
    private String descricao;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "treino_exercicio", joinColumns = @JoinColumn(name = "exercicio_id", referencedColumnName = "exercicioId"),
            inverseJoinColumns = @JoinColumn(name = "treino_id", referencedColumnName = "treinoId"))
    private List<Treino> treinos;

    public Exercicio() {
    }

    public Exercicio(String nome, String categoria, String descricao, List<Treino> treinos) {
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.treinos = treinos;
    }

    public Long getExercicioId() {
        return exercicioId;
    }

    public void setExercicioId(Long exercicioId) {
        this.exercicioId = exercicioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Treino> getTreinos() {
        return treinos;
    }

    public void setTreinos(List<Treino> treinos) {
        this.treinos = treinos;
    }
}
