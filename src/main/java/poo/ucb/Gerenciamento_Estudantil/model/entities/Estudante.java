package poo.ucb.Gerenciamento_Estudantil.model.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Table(name = "estudante")
public class Estudante extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int matricula;

    @ManyToMany(mappedBy = "estudantes")
    private List<Curso> curso;


    // métodos
    @Override
    public void exibirDados() {
        // TODO Auto-generated method stub

    }

    @Override
    public void excluir() {
        // TODO Auto-generated method stub

    }

    @Override
    public void editar() {
        // TODO Auto-generated method stub

    }


    // getters e setters
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public void cadastrar() {
        // TODO Auto-generated method stub

    }
}
