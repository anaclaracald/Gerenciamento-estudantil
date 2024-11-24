package poo.ucb.Gerenciamento_Estudantil.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import poo.ucb.Gerenciamento_Estudantil.model.entities.Professor;
import poo.ucb.Gerenciamento_Estudantil.model.services.ProfessorService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

@Component
public class EditarProfessor extends JFrame {
    private JTextField textFieldNome;
    private JTextField textFieldEspecialidade;
    private JTextField textFieldId;
    private JButton buttonSalvarNome;
    private JButton buttonVoltar;
    private JPanel janelaEditProfessor;
    private JButton buttonSalvarEspecialidade;
    private JButton buttonExcluir;

    @Autowired
    private ProfessorService professorService;

    public EditarProfessor() {
        // Primeiras configurações
        setContentPane(janelaEditProfessor);
        setTitle("Janela Editar Professor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        buttonVoltar.addActionListener(new ActionListener() { // Botão Voltar (fecha aba)
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        buttonSalvarNome.addActionListener(new ActionListener() { // botão salvar novo nome
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pegar input de nova especialidade
                try {
                    long id = Long.parseLong(textFieldId.getText().trim());
                    Optional<Professor> professorOptional = professorService.buscarPorId(id);

                    if (professorOptional.isPresent()) {
                        Professor professor = professorOptional.get();
                        String novoNome = textFieldNome.getText().trim();

                        if (!novoNome.isEmpty()) {
                            professor.setNome(novoNome);
                            professorService.editarProfessor(professor.getId(), professor);
                            JOptionPane.showMessageDialog(EditarProfessor.this, "Nome atualizado com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(EditarProfessor.this, "O nome não pode estar vazio.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(EditarProfessor.this, "Professor não encontrado.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(EditarProfessor.this, "ID deve ser um número válido.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(EditarProfessor.this, "Erro ao salvar: " + ex.getMessage());
                }
            }
        });

        buttonSalvarEspecialidade.addActionListener(new ActionListener() { // botão salvar nova especialidade
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long id = Long.parseLong(textFieldId.getText().trim());
                    Optional<Professor> professorOptional = professorService.buscarPorId(id);

                    if (professorOptional.isPresent()) {
                        Professor professor = professorOptional.get();
                        String novaEspecialidade = textFieldEspecialidade.getText().trim();

                        professor.setEspecialidade(novaEspecialidade);
                        professorService.editarProfessor(professor.getId(), professor);
                        JOptionPane.showMessageDialog(EditarProfessor.this, "Especialidade atualizada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(EditarProfessor.this, "Professor não encontrado.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(EditarProfessor.this, "Insira um ID e especialidade válidos.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(EditarProfessor.this, "Erro ao salvar: " + ex.getMessage());
                }
            }
        });

        buttonExcluir.addActionListener(new ActionListener() { // botao excluir
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long id = Long.parseLong(textFieldId.getText().trim());

                    int confirmacao = JOptionPane.showConfirmDialog(
                            EditarProfessor.this,
                            "Tem certeza de que deseja excluir este professor?",
                            "Confirmação",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (confirmacao == JOptionPane.YES_OPTION) {
                        professorService.excluirProfessor(id);
                        JOptionPane.showMessageDialog(EditarProfessor.this, "Professor excluído com sucesso!");

                        // Limpar campos
                        textFieldId.setText("");
                        textFieldNome.setText("");
                        textFieldEspecialidade.setText("");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(EditarProfessor.this, "Insira uma ID válido.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(EditarProfessor.this, "Erro ao excluir: " + ex.getMessage());
                }
            }
        });
    }
}
