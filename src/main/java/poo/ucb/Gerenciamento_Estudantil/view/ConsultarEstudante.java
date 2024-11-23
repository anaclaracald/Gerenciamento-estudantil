package poo.ucb.Gerenciamento_Estudantil.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        buttonVoltar.addActionListener(new ActionListener() { // Botão Voltar
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

                // if (estudante encontrado) {apresentar tela de editar ou excluir}
                int i = 0; // Valor arbitrário para testes
                if (i == 0) {
                    EditarEstudante janelaEditEstudante = new EditarEstudante();
                    janelaEditEstudante.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(ConsultarEstudante.this, "Desculpe, esse estudante não foi encontrado");
                }
            }
        });

        buttonEnviarMatricula.addActionListener(new ActionListener() { // Botão Enviar (matrícula)
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pegar input de matrícula
                try {
                    int matricula = Integer.parseInt(textFieldMatricula.getText());
                }
                catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(ConsultarEstudante.this, "Insira um valor numérico.");
                }

                // TODO enviar matrícula para pesquisa na DB



                // if (estudante encontrado) {apresentar tela de editar ou excluir}
                int i = 0; // Valor arbitrário para testes
                if (i == 0) {
                    EditarEstudante janelaEditEstudante = new EditarEstudante();
                    janelaEditEstudante.setVisible(true);
                }
            }
        });
    }
}
