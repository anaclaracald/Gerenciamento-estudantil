package poo.ucb.Gerenciamento_Estudantil.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerarRelatorios extends JFrame {
    private JPanel janelaRelatorios;
    private JButton buttonRelEstudantes;
    private JButton buttonRelProfessores;
    private JButton SAIRButton;

    public GerarRelatorios() {
    // Primeiras configurações
        setContentPane(janelaRelatorios);
        setTitle("Janela Gerar Relatórios");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        SAIRButton.addActionListener(new ActionListener() { // Botão sair (fecha aba)
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        buttonRelEstudantes.addActionListener(new ActionListener() { // Botão Gerar Relatório (estudantes)
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO gerar relatório dos estudantes
            }
        });

        buttonRelProfessores.addActionListener(new ActionListener() { // Botão Gerar Relatório (professores)
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO gerar relatório dos professores
            }
        });
    }
}
