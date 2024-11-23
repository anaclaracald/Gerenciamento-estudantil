package poo.ucb.Gerenciamento_Estudantil.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vinculacao extends JFrame {
    private JPanel janelaVinculacao;
    private JButton buttonMatEstudante;
    private JButton buttonVoltar;
    private JButton buttonAssociarProf;

    public Vinculacao() {
    // Configurações iniciais
        setContentPane(janelaVinculacao);
        setTitle("Janela Vinculação");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        buttonVoltar.addActionListener(new ActionListener() { // Botão Voltar (fecha aba)
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        buttonMatEstudante.addActionListener(new ActionListener() { // Botão Matricular Estudante
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pegar input de matrícula
                try {
                    int matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe a matrícula do estudante que deseja matricular:"));
                }
                catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(Vinculacao.this, "Insira um valor numérico.");
                }

                // TODO matricular aluno no curso
            }
        });

        buttonAssociarProf.addActionListener(new ActionListener() { // Botão Associar Professor
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pegar input de ID
                try {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do professor que deseja associar:"));
                }
                catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(Vinculacao.this, "Insira um valor numérico.");
                }

                // TODO associar professor ao curso
            }
        });
    }
}
