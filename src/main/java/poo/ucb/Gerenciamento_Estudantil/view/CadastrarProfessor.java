package poo.ucb.Gerenciamento_Estudantil.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import poo.ucb.Gerenciamento_Estudantil.model.entities.Professor;
import poo.ucb.Gerenciamento_Estudantil.model.services.ProfessorService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class CadastrarProfessor extends JFrame {
    private JTextField textFieldNome;
    private JTextField textFieldEspecialidade;
    private JTextField textFieldId;
    private JButton buttonEnviar;
    private JButton buttonVoltar;
    private JPanel janelaCadProfessor;

    @Autowired
    private ProfessorService professorService;

    public CadastrarProfessor() {
    // Primeiras configurações
        setContentPane(janelaCadProfessor);
        setTitle("Janela Cadastrar Professor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        buttonVoltar.addActionListener(new ActionListener() { // Botão voltar (fecha aba)
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        buttonEnviar.addActionListener(new ActionListener() { // Botão Enviar
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldNome.getText(); // Pegar input de nome
                String especialidade = textFieldEspecialidade.getText(); // Pegar input de especialidade
                Long id;

                try { // Pegar input do ID
                    id = Long.parseLong(textFieldId.getText());
                }
                catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(CadastrarProfessor.this, "Insira um valor numérico.");
                }

                // Criação do objeto
                Professor professor = new Professor();
                professor.setNome(nome);
                professor.setEspecialidade(especialidade);
                professor.setId(id);

                // Salvar no banco de dados

                try{
                    professorService.cadastrarProfessor(professor);
                    JOptionPane.showMessageDialog(CadastrarProfessor.this, "Professor cadastrado com sucesso!");

                    //Limpar campos
                    textFieldNome.setText("");
                    textFieldEspecialidade.setText("");
                    textFieldId.setText("");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(CadastrarProfessor.this, "Erro ao cadastrar o professor: " + ex.getMessage());
                }
            }
        });
    }
}
