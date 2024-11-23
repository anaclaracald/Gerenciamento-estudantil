package poo.ucb.Gerenciamento_Estudantil.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class EditarCurso extends JFrame {
    private JTextField textFieldNome;
    private JTextField textFieldCHoraria;
    private JButton buttonSalvarNome;
    private JButton buttonSalvarCHoraria;
    private JButton buttonVoltar;
    private JButton buttonExcluir;
    private JPanel janelaEditCurso;

    public EditarCurso() {
    // Configurações iniciais
        setContentPane(janelaEditCurso);
        setTitle("Janela Editar Curso");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        buttonVoltar.addActionListener(new ActionListener() { // Botão Voltar (fecha aba)
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        buttonSalvarNome.addActionListener(new ActionListener() { // Botão Salvar Alterações (nome)
            @Override
            public void actionPerformed(ActionEvent e) {
                String novoNome = textFieldNome.getText();

                if (MenuInicial.confirmar()) {
                    // TODO salvar alterações de nome
                }
            }
        });

        buttonSalvarCHoraria.addActionListener(new ActionListener() { // Botão Salvar Alterações (carga horária)
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pegar input de nova carga horária
                try {
                    int novaIdade = Integer.parseInt(textFieldCHoraria.getText());
                }
                catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(EditarCurso.this, "Insira um valor numérico.");
                }

                if (MenuInicial.confirmar()) {
                    // TODO salvar alterações de carga horária
                }
            }
        });

        buttonExcluir.addActionListener(new ActionListener() { // Botão Excluir Curso
            @Override
            public void actionPerformed(ActionEvent e) {

                if (MenuInicial.confirmar()) {
                    // TODO excluir curso
                }
            }
        });
    }
}
