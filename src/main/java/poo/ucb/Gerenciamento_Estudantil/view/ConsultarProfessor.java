package poo.ucb.Gerenciamento_Estudantil.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import poo.ucb.Gerenciamento_Estudantil.model.services.ProfessorService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class ConsultarProfessor extends JFrame {
    private JTextField textFieldNome;
    private JTextField textFieldId;
    private JButton buttonEnviarNome;
    private JButton buttonEnviarId;
    private JButton buttonVoltar;
    private JPanel janelaConsProfessor;

    @Autowired
    private ProfessorService professorService;

    public ConsultarProfessor() {
        // Primeiras configurações
        setContentPane(janelaConsProfessor);
        setTitle("Janela Consultar Professor");
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
                    // (professor encontrado) {apresentar tela de editar ou excluir}
                    professorService.buscarPorNome(nome);
                    EditarProfessor janelaEditProfessor = new EditarProfessor();
                    janelaEditProfessor.setVisible(true);
                }catch ( Exception ex){
                    JOptionPane.showMessageDialog(ConsultarProfessor.this, "Esse professor está vinculado ao sistema: " + ex.getMessage());
                }
            }
        });

        buttonEnviarId.addActionListener(new ActionListener() { // Botão Enviar (ID)
            @Override
            public void actionPerformed(ActionEvent e) {
                try { // Pegar input de ID
                    long id = Long.parseLong(textFieldId.getText());
                    professorService.buscarPorId(id);
                    EditarProfessor janelaEditProfessor = new EditarProfessor();
                    janelaEditProfessor.setVisible(true);
                }
                catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(ConsultarProfessor.this, "Insira um valor numérico.");
                }
            }
        });
    }
}
