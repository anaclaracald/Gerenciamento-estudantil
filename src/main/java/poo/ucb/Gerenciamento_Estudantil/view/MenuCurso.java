package poo.ucb.Gerenciamento_Estudantil.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuCurso extends JFrame {
    private JButton CADASTRARCURSOButton;
    private JButton CONSULTARButton;
    private JButton VINCULARPROFESSORButton;
    private JButton SAIRButton;
    private JPanel janelaCurso;

    MenuCurso() {
    // Configurações iniciais
        setContentPane(janelaCurso);
        setTitle("Janela Curso");
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
    }
}
