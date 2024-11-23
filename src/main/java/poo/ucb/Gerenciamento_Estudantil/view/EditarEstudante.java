package poo.ucb.Gerenciamento_Estudantil.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class EditarEstudante extends JFrame {
    private JTextField textFieldNome;
    private JTextField textFieldIdade;
    private JButton buttonSalvarNome;
    private JButton buttonVoltar;
    private JPanel janelaEditEstudante;
    private JButton buttonSalvarIdade;
    private JButton buttonExcluir;

    public EditarEstudante() {
    // Primeiras configurações
        setContentPane(janelaEditEstudante);
        setTitle("Janela Editar Estudante");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        buttonVoltar.addActionListener(new ActionListener() { // Botão Voltar (fecha aba)
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        buttonSalvarNome.addActionListener(new ActionListener() { // Botão Salvar Alterações (nome)
            @Override
            public void actionPerformed(ActionEvent e) {
                String novoNome = textFieldNome.getText();

                if (Main.confirmar()) {
                    // TODO salvar alterações de nome
                }
            }
        });

        buttonSalvarIdade.addActionListener(new ActionListener() { // Botão Salvar Alterações (idade)
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int novaIdade = Integer.parseInt(textFieldIdade.getText());
                }
                catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(EditarEstudante.this, "Insira um valor numérico.");
                }

                if (Main.confirmar()) {
                    // TODO salvar alterações de idade
                }
            }
        });

        buttonExcluir.addActionListener(new ActionListener() { // Botão Excluir Estudante
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Main.confirmar()) {
                    // TODO excluir estudante
                }
            }
        });
    }
}
