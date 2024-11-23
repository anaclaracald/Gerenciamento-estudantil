package poo.ucb.Gerenciamento_Estudantil.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class CadastrarCurso extends JFrame {
    private JTextField textFieldNome;
    private JButton buttonEnviar;
    private JButton buttonVoltar;
    private JPanel janelaCadCurso;
    private JTextField textFieldCHoraria;

    public CadastrarCurso() {
    // Configurações iniciais
        setContentPane(janelaCadCurso);
        setTitle("Janela Cadastrar Curso");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        buttonVoltar.addActionListener(new ActionListener() { // Botão voltar (fecha aba)
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        buttonEnviar.addActionListener(new ActionListener() { // Botão Enviar
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldNome.getText(); // Pegar input de nome

                // Pegar input de carga horária
                try {
                    int idade = Integer.parseInt(textFieldCHoraria.getText());
                }
                catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(CadastrarCurso.this, "Insira um valor numérico.");
                }

                // TODO - passar dados para o banco de dados
            }
        });
    }
}
