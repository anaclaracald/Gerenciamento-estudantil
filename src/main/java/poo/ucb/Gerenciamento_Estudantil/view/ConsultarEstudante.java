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
        setVisible(true);

        buttonVoltar.addActionListener(new ActionListener() { // Botão voltar
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        buttonEnviarNome.addActionListener(new ActionListener() { // Botão Enviar (nome)
            @Override
            public void actionPerformed(ActionEvent e) {

                String nome = textFieldNome.getText();

                try{
                    // (estudante encontrado) {apresentar tela de editar ou excluir}
                    estudanteService.buscarPorNome(nome);
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
                try { // Pegar input de matrícula
                    long matricula = Long.parseLong(textFieldMatricula.getText());
                    estudanteService.buscarPorMatricula(matricula);
                    EditarEstudante janelaEditEstudante = new EditarEstudante();
                    janelaEditEstudante.setVisible(true);
                }
                catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(ConsultarEstudante.this, "Insira um valor numérico.");
                }
            }
        });
    }
}
