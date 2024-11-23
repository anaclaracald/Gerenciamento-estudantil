package poo.ucb.Gerenciamento_Estudantil.model.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Table(name = "professor")
public class Professor extends Pessoa {

    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProfessor;
    @Column(name = "especialidade")
    private String especialidade;

    @OneToMany(mappedBy = "professor")
    private List<Curso> cursos;


    // métodos
    @Override
    public void exibirDados() {
        // TODO Auto-generated method stub

    }

    @Override
    public void cadastrar() {
        // TODO Auto-generated method stub

    }

    @Override
    public void editar() {
        // TODO Auto-generated method stub

    }

    @Override
    public void excluir() {
        // TODO Auto-generated method stub

    }


    // getters e setters
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
