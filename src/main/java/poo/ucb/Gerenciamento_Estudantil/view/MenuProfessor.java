package poo.ucb.Gerenciamento_Estudantil.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuProfessor extends JFrame {
    private JButton CADASTRARPROFESSORButton;
    private JButton CONSULTARButton;
    private JButton SAIRButton;
    private JPanel janelaProfessor;

    MenuProfessor () {
        setContentPane(janelaProfessor);
        setTitle("Janela Professor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        SAIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
