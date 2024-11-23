package poo.ucb.Gerenciamento_Estudantil.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.Id;

@MappedSuperclass
public abstract class Pessoa {

    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "idade", nullable = false)
    private int idade;


    public Pessoa() {
    }

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
