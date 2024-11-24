package poo.ucb.Gerenciamento_Estudantil.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class MenuEstudante extends JFrame {
    private JButton CADASTRARESTUDANTEButton;
    private JButton CONSULTARButton;
    private JButton SAIRButton;
    private JPanel janelaEstudante;

    @Autowired
    private ConsultarEstudante consultarEstudante;

    @Autowired
    private CadastrarEstudante cadastrarEstudante;

    public MenuEstudante () {
    // Primeiras configurações
        setContentPane(janelaEstudante);
        setTitle("Janela Estudante");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        SAIRButton.addActionListener(new ActionListener() { // Fechar aba
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        CADASTRARESTUDANTEButton.addActionListener(new ActionListener() { // Abrir aba Cadastrar Estudante
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarEstudante.setVisible(true);
            }
        });

        CONSULTARButton.addActionListener(new ActionListener() { // Abrir aba Consultar Estudante
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarEstudante.setVisible(true);
            }
        });
    }
}
