package poo.ucb.Gerenciamento_Estudantil.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "professor")
public class Professor extends Pessoa {

    @Id
    @Column(name = "id_professor", nullable = false, unique = true)
    private Long id;
    @Column(name = "especialidade", nullable = false)
    private String especialidade;
    @OneToMany(mappedBy = "professor")
    private List<Curso> cursos;

    public Professor(String nome, int idade, Long id, String especialidade) {
        super(nome, idade);
        this.id = id;
        this.especialidade = especialidade;
    }

    public Professor(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
