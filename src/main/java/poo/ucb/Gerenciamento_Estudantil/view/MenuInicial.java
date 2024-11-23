package poo.ucb.Gerenciamento_Estudantil.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class MenuInicial extends JFrame {
    private JButton menuEstudanteButton;
    private JButton MENUPROFESSORButton;
    private JButton MENUCURSOButton;
    private JButton sairDoProgramaButton;
    private JPanel janelaPrincipal;
    private JButton GERARRELATORIOSButton;

    public MenuInicial() {
    // Primeiras configurações
        setContentPane(janelaPrincipal);
        setTitle("Janela Principal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        sairDoProgramaButton.addActionListener(new ActionListener() { // Botão sair (encerra programa)
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuEstudanteButton.addActionListener(new ActionListener() { // Abrir aba Estudante
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuEstudante janelaEstudante = new MenuEstudante();
                janelaEstudante.setVisible(true);
            }
        });

        MENUPROFESSORButton.addActionListener(new ActionListener() { // Abrir aba Professor
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuProfessor janelaProfessor = new MenuProfessor();
                janelaProfessor.setVisible(true);
            }
        });

        MENUCURSOButton.addActionListener(new ActionListener() { // Abrir aba Curso
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuCurso janelaCurso = new MenuCurso();
                janelaCurso.setVisible(true);
            }
        });

        GERARRELATORIOSButton.addActionListener(new ActionListener() { // Abrir aba Gerar Relatórios
            @Override
            public void actionPerformed(ActionEvent e) {
                GerarRelatorios janelaRelartorios = new GerarRelatorios();
                janelaRelartorios.setVisible(true);
            }
        });
    }

    public static boolean confirmar() {
        int option = JOptionPane.showConfirmDialog(
                null,
                "Você quer realizar a ação?",
                "Escolha uma opção",
                JOptionPane.YES_NO_OPTION
        );

        return option == JOptionPane.YES_OPTION;
    }

}
