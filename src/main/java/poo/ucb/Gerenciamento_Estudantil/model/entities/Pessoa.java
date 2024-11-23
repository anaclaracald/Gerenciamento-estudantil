package poo.ucb.Gerenciamento_Estudantil.model.entities;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa {

    // atributos
    private String nome;
    private int idade;


    // métodos
    public abstract void exibirDados();
    public abstract void cadastrar();
    public abstract void editar();
    public abstract void excluir();


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
