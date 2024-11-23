package poo.ucb.Gerenciamento_Estudantil.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarCurso extends JFrame {
    private JTextField textFieldNome;
    private JButton buttonEnviarNome;
    private JButton buttonVoltar;
    private JPanel janelaConsCurso;

    public ConsultarCurso() {
    // Configurações iniciais
        setContentPane(janelaConsCurso);
        setTitle("Janela Consultar Curso");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        buttonVoltar.addActionListener(new ActionListener() { // Botão Voltar (fecha aba)
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        buttonEnviarNome.addActionListener(new ActionListener() { // Botão Enviar
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldNome.getText();
                // TODO enviar nome para pesquisa na DB

                // if (curso encontrado) {apresentar tela de editar ou excluir}
                int i = 0; // Valor arbitrário para testes
                if (i == 0) {
                    EditarCurso janelaEditCurso = new EditarCurso();
                    janelaEditCurso.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(ConsultarCurso.this, "Desculpe, esse estudante não foi encontrado");
                }
            }
        });
    }
}
