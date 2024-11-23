package poo.ucb.Gerenciamento_Estudantil.model.services.utilRelatorios;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.springframework.stereotype.Service;
import poo.ucb.Gerenciamento_Estudantil.model.entities.Professor;
import poo.ucb.Gerenciamento_Estudantil.model.services.ProfessorService;

import java.io.ByteArrayOutputStream;

@Service
public class RelatorioServiceProfessor{

    public byte[] gerarRelatorioCursoPDF(ProfessorService professorService) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Título
            document.add(new Paragraph("Relatório Professores").setFontSize(14));

            document.add(new Paragraph(" "));

            // Tabela de estudantes
            float[] columnWidths = {50F, 200F, 100F};
            Table table = new Table(columnWidths);
            table.addCell("ID");
            table.addCell("Nome");
            table.addCell("Especialidade");

            for (Professor professor : professorService.listarProfessores()) {
                table.addCell(String.valueOf(professor.getId()));
                table.addCell(professor.getNome());
                table.addCell(professor.getEspecialidade());
            }

            document.add(table);
            document.close();

            return out.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar relatório PDF", e);
        }
    }
}
