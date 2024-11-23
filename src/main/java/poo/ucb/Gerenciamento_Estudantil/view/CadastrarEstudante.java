package poo.ucb.Gerenciamento_Estudantil.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.*;

public class CadastrarEstudante extends JFrame {
    private JTextField textFieldNome;
    private JTextField textFieldIdade;
    private JTextField textFieldMatricula;
    private JButton buttonEnviar;
    private JButton buttonVoltar;
    private JPanel janelaCadEstudante;

    public CadastrarEstudante() {
    // Primeiras configurações
        setContentPane(janelaCadEstudante);
        setTitle("Janela Cadastrar Estudante");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        buttonVoltar.addActionListener(new ActionListener() { // Botão voltar (fecha aba)
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        buttonEnviar.addActionListener(new ActionListener() { // Botão enviar
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldNome.getText(); // Pegar input de nome

                try { // Pegar input de idade
                    int idade = Integer.parseInt(textFieldIdade.getText());
                }
                catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(CadastrarEstudante.this, "Insira um valor numérico.");
                }

                try { // Pegar input de matrícula
                    int matricula = Integer.parseInt(textFieldMatricula.getText());
                }
                catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(CadastrarEstudante.this, "Insira um valor numérico.");
                }

                // TODO - passar dados para o banco de dados
            }
        });
    }
}
