package poo.ucb.Gerenciamento_Estudantil.view;

import org.springframework.beans.factory.annotation.Autowired;
import poo.ucb.Gerenciamento_Estudantil.model.entities.Estudante;
import poo.ucb.Gerenciamento_Estudantil.model.services.EstudanteService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public class EditarEstudante extends JFrame {
    private JTextField textFieldNome;
    private JTextField textFieldIdade;
    private JTextField textFieldMatricula;
    private JButton buttonSalvarNome;
    private JButton buttonVoltar;
    private JPanel janelaEditEstudante;
    private JButton buttonSalvarIdade;
    private JButton buttonExcluir;

    @Autowired
    private EstudanteService estudanteService;

    public EditarEstudante() {
    // Primeiras configurações
        setContentPane(janelaEditEstudante);
        setTitle("Janela Editar Estudante");
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
                // Pegar input de nova idade
                try {
                    long matricula = Long.parseLong(textFieldMatricula.getText().trim());
                    Optional<Estudante> estudanteOptional = estudanteService.buscarPorMatricula(matricula);

                    if (estudanteOptional.isPresent()) {
                        Estudante estudante = estudanteOptional.get();
                        String novoNome = textFieldNome.getText().trim();

                        if (!novoNome.isEmpty()) {
                            estudante.setNome(novoNome);
                            estudanteService.editarEstudante(estudante.getMatricula(), estudante);
                            JOptionPane.showMessageDialog(EditarEstudante.this, "Nome atualizado com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(EditarEstudante.this, "O nome não pode estar vazio.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(EditarEstudante.this, "Estudante não encontrado.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(EditarEstudante.this, "Matrícula deve ser um número válido.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(EditarEstudante.this, "Erro ao salvar: " + ex.getMessage());
                }
            }
        });

        buttonSalvarIdade.addActionListener(new ActionListener() { // botão salvar nova idade
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long matricula = Long.parseLong(textFieldMatricula.getText().trim());
                    Optional<Estudante> estudanteOptional = estudanteService.buscarPorMatricula(matricula);

                    if (estudanteOptional.isPresent()) {
                        Estudante estudante = estudanteOptional.get();
                        int novaIdade = Integer.parseInt(textFieldIdade.getText().trim());

                        estudante.setIdade(novaIdade);
                        estudanteService.editarEstudante(estudante.getMatricula(), estudante);
                        JOptionPane.showMessageDialog(EditarEstudante.this, "Idade atualizada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(EditarEstudante.this, "Estudante não encontrado.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(EditarEstudante.this, "Insira uma matrícula e idade válidas.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(EditarEstudante.this, "Erro ao salvar: " + ex.getMessage());
                }
            }
        });

        buttonExcluir.addActionListener(new ActionListener() { // botao excluir
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long matricula = Long.parseLong(textFieldMatricula.getText().trim());

                    int confirmacao = JOptionPane.showConfirmDialog(
                            EditarEstudante.this,
                            "Tem certeza de que deseja excluir este estudante?",
                            "Confirmação",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (confirmacao == JOptionPane.YES_OPTION) {
                        estudanteService.deletarEstudante(matricula);
                        JOptionPane.showMessageDialog(EditarEstudante.this, "Estudante excluído com sucesso!");

                        // Limpar campos
                        textFieldMatricula.setText("");
                        textFieldNome.setText("");
                        textFieldIdade.setText("");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(EditarEstudante.this, "Insira uma matrícula válida.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(EditarEstudante.this, "Erro ao excluir: " + ex.getMessage());
                }
            }
        });
    }
}
