package poo.ucb.Gerenciamento_Estudantil.model.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "curso")
public class Curso {
    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "curso_id")
    private Long id;
    @Column(name = "nome")
    private String nomeCurso;
    @Column(name = "cargaHoraria")
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

    // métodos
    public void editar() {
        // TODO
    }

    public void excluir() {
        // TODO
    }

    public void associarProfessor() {
        // TODO
    }


    // getters e setters
    public String getNomeCurso() {
        return nomeCurso;
    }
    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
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
