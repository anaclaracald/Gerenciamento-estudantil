package poo.ucb.Gerenciamento_Estudantil.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "estudante")
public class Estudante extends Pessoa {

    @Id
    @Column(name = "id_estudante", nullable = false, unique = true)
    private Long matricula;
    @ManyToMany(mappedBy = "estudantes")
    private List<Curso> curso;

    public Estudante() {
    }

    public Estudante(String nome, int idade, Long matricula, List<Curso> curso) {
        super(nome, idade);
        this.matricula = matricula;
        this.curso = curso;
    }

    // getters e setters
    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public List<Curso> getCurso() {
        return curso;
    }

    public void setCurso(List<Curso> curso) {
        this.curso = curso;
    }

}
