package poo.ucb.Gerenciamento_Estudantil.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import poo.ucb.Gerenciamento_Estudantil.model.entities.Estudante;
import poo.ucb.Gerenciamento_Estudantil.model.services.EstudanteService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class CadastrarEstudante extends JFrame {
    private JTextField textFieldNome;
    private JTextField textFieldIdade;
    private JTextField textFieldMatricula;
    private JButton buttonEnviar;
    private JButton buttonVoltar;
    private JPanel janelaCadEstudante;

    @Autowired
    private EstudanteService estudanteService; // injeta o serviço com os métodos

    public CadastrarEstudante() {
    // Primeiras configurações
        setContentPane(janelaCadEstudante);
        setTitle("Janela Cadastrar Estudante");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        buttonVoltar.addActionListener(new ActionListener() { // Botão voltar (fecha aba)
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        buttonEnviar.addActionListener(new ActionListener() { // Botão enviar
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldNome.getText().trim(); // Pegar input de nome
                int idade = 0;
                long matricula = 0;

                try { // Pegar input de idade
                    idade = Integer.parseInt(textFieldIdade.getText());
                }
                catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(CadastrarEstudante.this, "Insira um valor numérico.");
                    return;
                }

                try { // Pegar input de matrícula
                    matricula = Integer.parseInt(textFieldMatricula.getText());
                }
                catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(CadastrarEstudante.this, "Insira um valor numérico.");
                    return;
                }

                // Criação do objeto
                Estudante estudante = new Estudante();
                estudante.setNome(nome);
                estudante.setIdade(idade);
                estudante.setMatricula(matricula);

                // Salvar no banco de dados

                try{
                    estudanteService.cadastrarEstudante(estudante);
                    JOptionPane.showMessageDialog(CadastrarEstudante.this, "Estudante cadastrado com sucesso!");

                    //Limpar campos
                    textFieldNome.setText("");
                    textFieldIdade.setText("");
                    textFieldMatricula.setText("");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(CadastrarEstudante.this, "Erro ao cadastrar o estudante: " + ex.getMessage());
                }
            }
        });
    }
}
