package poo.ucb.Gerenciamento_Estudantil.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class MenuProfessor extends JFrame {

    private JButton SAIRButton;
    private JPanel janelaProfessor;

    MenuProfessor() {
        setContentPane(janelaProfessor);
        setTitle("Janela Professor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        SAIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
