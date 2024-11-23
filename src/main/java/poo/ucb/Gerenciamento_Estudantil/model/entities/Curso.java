package poo.ucb.Gerenciamento_Estudantil.model.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @Column(name = "curso_id", nullable = false, unique = true)
    private Long id;
    @Column(name = "nomeCurso", nullable = false)
    private String nome;
    @Column(name = "cargaHoraria", nullable = false)
    private int cargaHoraria;
    @ManyToOne
    private Professor professor;

    @ManyToMany
    @JoinTable(
            name = "curso_estudante",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "estudante_id")
    )
    private List<Estudante> estudantes;

    public Curso(Long id, String nome, int cargaHoraria, Professor professor, List<Estudante> estudantes) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        this.estudantes = estudantes;
    }

    // getters e setters
    public String getNomeCurso() {
        return nome;
    }
    public void setNomeCurso(String nome) {
        this.nome = nome;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
