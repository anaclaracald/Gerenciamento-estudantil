package poo.ucb.Gerenciamento_Estudantil.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuCurso extends JFrame {
    private JButton CADASTRARCURSOButton;
    private JButton CONSULTARButton;
    private JButton buttonVinculacao;
    private JButton SAIRButton;
    private JPanel janelaCurso;

    MenuCurso() {
    // Configurações iniciais
        setContentPane(janelaCurso);
        setTitle("Janela Curso");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        SAIRButton.addActionListener(new ActionListener() { // Botão Sair (fecha aba)
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        CADASTRARCURSOButton.addActionListener(new ActionListener() { // Botão Cadastrar Curso
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastrarCurso janelaCadCurso = new CadastrarCurso();
                janelaCadCurso.setVisible(true);
            }
        });

        CONSULTARButton.addActionListener(new ActionListener() { // Botão Consultar Curso
            public void actionPerformed(ActionEvent e) {
                ConsultarCurso janelaConsCurso = new ConsultarCurso();
                janelaConsCurso.setVisible(true);
            }
        });

        buttonVinculacao.addActionListener(new ActionListener() { // Botão Vinculação
            @Override
            public void actionPerformed(ActionEvent e) {
                Vinculacao janelaVinculacao = new Vinculacao();
                janelaVinculacao.setVisible(true);
            }
        });
    }
}
