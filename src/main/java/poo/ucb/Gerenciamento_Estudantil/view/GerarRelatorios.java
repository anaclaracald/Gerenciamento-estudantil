package poo.ucb.Gerenciamento_Estudantil.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import poo.ucb.Gerenciamento_Estudantil.model.services.EstudanteService;
import poo.ucb.Gerenciamento_Estudantil.model.services.ProfessorService;
import poo.ucb.Gerenciamento_Estudantil.model.services.utilRelatorios.RelatorioServiceEstudante;
import poo.ucb.Gerenciamento_Estudantil.model.services.utilRelatorios.RelatorioServiceProfessor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class GerarRelatorios extends JFrame {
    private JPanel janelaRelatorios;
    private JTextField textFieldMatricula;
    private JButton buttonRelEstudantes;
    private JButton buttonRelProfessores;
    private JButton buttonRelCursos;
    private JButton SAIRButton;

    @Autowired
    private RelatorioServiceEstudante relatorioServiceEstudante;

    @Autowired
    private RelatorioServiceProfessor relatorioServiceProfessor;

    @Autowired
    private EstudanteService estudanteService;

    @Autowired
    private ProfessorService professorService;


    public GerarRelatorios() {
    // Primeiras configurações
        setContentPane(janelaRelatorios);
        setTitle("Janela Gerar Relatórios");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        SAIRButton.addActionListener(new ActionListener() { // Botão sair (fecha aba)
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        buttonRelEstudantes.addActionListener(new ActionListener() { // Botão Gerar Relatório (estudantes)
            @Override
            public void actionPerformed(ActionEvent e) {
               try{
                   relatorioServiceEstudante.gerarRelatorioEstudantesPDF(estudanteService);
               }catch (Exception ex){
                   JOptionPane.showMessageDialog(GerarRelatorios.this, "Houve um erro ao gerar o relatório: " + ex.getMessage());
               }
            }
        });

        buttonRelProfessores.addActionListener(new ActionListener() { // Botão Gerar Relatório (professores)
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    relatorioServiceProfessor.gerarRelatorioProfessoresPDF(professorService);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(GerarRelatorios.this, "Houve um erro ao gerar o relatório: " + ex.getMessage());
                }
            }
        });


    }
}
