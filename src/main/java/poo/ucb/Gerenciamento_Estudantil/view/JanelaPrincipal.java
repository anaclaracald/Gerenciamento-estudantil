package poo.ucb.Gerenciamento_Estudantil.view;

import javax.swing.*;

public class JanelaPrincipal extends JFrame {


    public JanelaPrincipal() {
        setTitle("Sistema de Gerenciamento Estudantil");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuAluno = new JMenu("Aluno");
        JMenuItem itemCadastrarAluno = new JMenuItem("Cadastrar");
        JMenuItem itemConsultarAluno = new JMenuItem("Consultar");
        menuAluno.add(itemCadastrarAluno);
        menuAluno.add(itemConsultarAluno);

        JMenu menuProfessor = new JMenu("Professor");
        JMenuItem itemCadastrarProfessor = new JMenuItem("Cadastrar");
        JMenuItem itemConsultarProfessor = new JMenuItem("Consultar");
        menuProfessor.add(itemCadastrarProfessor);
        menuProfessor.add(itemConsultarProfessor);

        JMenu menuCurso = new JMenu("Curso");
        JMenuItem itemCadastrarCurso = new JMenuItem("Cadastrar");
        JMenuItem itemConsultarCurso = new JMenuItem("Consultar");
        menuCurso.add(itemCadastrarCurso);
        menuCurso.add(itemConsultarCurso);

        menuBar.add(menuAluno);
        menuBar.add(menuProfessor);
        menuBar.add(menuCurso);

        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JanelaPrincipal().setVisible(true);
        });
    }
}
