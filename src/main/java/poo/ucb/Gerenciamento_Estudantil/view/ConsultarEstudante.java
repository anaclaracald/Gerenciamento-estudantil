package poo.ucb.Gerenciamento_Estudantil.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class ConsultarEstudante extends JFrame {
    private JTextField textFieldNome;
    private JTextField textFieldMatricula;
    private JButton buttonEnviarNome;
    private JButton buttonEnviarMatricula;
    private JButton buttonVoltar;
    private JPanel janelaConsEstudante;

    public ConsultarEstudante() {
    // Primeiras configurações
        setContentPane(janelaConsEstudante);
        setTitle("Janela Consultar Estudante");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        buttonVoltar.addActionListener(new ActionListener() { // Botão voltar
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        buttonEnviarNome.addActionListener(new ActionListener() { // Botão Enviar (nome)
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldNome.getText();
                // TODO enviar nome para pesquisa na DB

                int i = 0;

                // if (estudante encontrado) {apresentar tela de editar ou excluir}
                if (i == 0) {
                    EditarEstudante janelaEditEstudante = new EditarEstudante();
                    janelaEditEstudante.setVisible(true);
                }
            }
        });

        buttonEnviarMatricula.addActionListener(new ActionListener() { // Botão Enviar (matrícula)
            @Override
            public void actionPerformed(ActionEvent e) {
                int matricula = parseInt(textFieldMatricula.getText());
                // TODO enviar matrícula para pesquisa na DB

                int i = 0;

                // if (estudante encontrado) {apresentar tela de editar ou excluir}
                if (i == 0) {
                    EditarEstudante janelaEditEstudante = new EditarEstudante();
                    janelaEditEstudante.setVisible(true);
                }
            }
        });
    }
}
