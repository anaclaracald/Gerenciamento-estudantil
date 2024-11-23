package poo.ucb.Gerenciamento_Estudantil.model.entities.enums;

public enum Especialidade {
    CIENCIA_DA_COMPUTACAO("Ciência da computação"),
    ENGENHARIA_DE_SOFTWARE("Engenharia de Software"),
    MEDICINA("Medicina"),
    DIREITO("Direito"),
    ADMINISTRACAO("Administração"),
    ECONOMIA("Economia"),
    PSICOLOGIA("Psicologia"),
    ARQUITETURA("Arquitetura"),
    ENFERMAGEM("Enfermagem"),
    PEDAGOGIA("Pedagogia"),
    MATEMATICA("Matemática"),
    FISICA("Física"),
    QUIMICA("Química"),
    BIOLOGIA("Biologia"),
    LETRAS("Letras"),
    HISTORIA("História"),
    GEOGRAFIA("Geografia"),
    FILOSOFIA("Filosofia"),
    SOCIOLOGIA("Sociologia");

    private final String descricao;

    Especialidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
