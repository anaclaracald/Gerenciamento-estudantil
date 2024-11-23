package poo.ucb.Gerenciamento_Estudantil.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import poo.ucb.Gerenciamento_Estudantil.model.services.EstudanteService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class ConsultarEstudante extends JFrame {
    private JTextField textFieldNome;
    private JTextField textFieldMatricula;
    private JButton buttonEnviarNome;
    private JButton buttonEnviarMatricula;
    private JButton buttonVoltar;
    private JPanel janelaConsEstudante;

    @Autowired
    private EstudanteService estudanteService;

    public ConsultarEstudante() {
    // Primeiras configurações
        setContentPane(janelaConsEstudante);
        setTitle("Janela Consultar Estudante");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        buttonVoltar.addActionListener(new ActionListener() { // Botão Voltar
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        buttonEnviarNome.addActionListener(new ActionListener() { // Botão Enviar (nome)
            @Override
            public void actionPerformed(ActionEvent e) {

                String nome = textFieldNome.getText();

<<<<<<< HEAD
                try{
                    // (estudante encontrado) {apresentar tela de editar ou excluir}
                    estudanteService.buscarPorNome(nome);
=======
                // if (estudante encontrado) {apresentar tela de editar ou excluir}
                int i = 0; // Valor arbitrário para testes
                if (i == 0) {
>>>>>>> 36448243fd9f79723be6132701fa05bdb1d9eea0
                    EditarEstudante janelaEditEstudante = new EditarEstudante();
                    janelaEditEstudante.setVisible(true);
                }catch ( Exception ex){
                    JOptionPane.showMessageDialog(ConsultarEstudante.this, "Esse estudante está vinculado ao sistema: " + ex.getMessage());
                }
            }
        });

        buttonEnviarMatricula.addActionListener(new ActionListener() { // Botão Enviar (matrícula)
            @Override
            public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
                try { // Pegar input de matrícula
                    long matricula = Long.parseLong(textFieldMatricula.getText());
                    estudanteService.buscarPorMatricula(matricula);
                    EditarEstudante janelaEditEstudante = new EditarEstudante();
                    janelaEditEstudante.setVisible(true);
=======
                // Pegar input de matrícula
                try {
                    int matricula = Integer.parseInt(textFieldMatricula.getText());
>>>>>>> 36448243fd9f79723be6132701fa05bdb1d9eea0
                }
                catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(ConsultarEstudante.this, "Insira um valor numérico.");
                }
<<<<<<< HEAD
=======

                // TODO enviar matrícula para pesquisa na DB



                // if (estudante encontrado) {apresentar tela de editar ou excluir}
                int i = 0; // Valor arbitrário para testes
                if (i == 0) {
                    EditarEstudante janelaEditEstudante = new EditarEstudante();
                    janelaEditEstudante.setVisible(true);
                }
>>>>>>> 36448243fd9f79723be6132701fa05bdb1d9eea0
            }
        });
    }
}
