package poo.ucb.Gerenciamento_Estudantil.model.services.utilRelatorios;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.springframework.stereotype.Service;
import poo.ucb.Gerenciamento_Estudantil.model.entities.Curso;
import poo.ucb.Gerenciamento_Estudantil.model.entities.Estudante;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class RelatorioServiceCurso {

    public byte[] gerarRelatorioCursoPDF(Curso curso, List<Estudante> estudantes) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Título
            document.add(new Paragraph("Relatório de Curso").setFontSize(14));
            document.add(new Paragraph("Curso: " + curso.getNomeCurso()).setFontSize(12));
            document.add(new Paragraph("Carga Horária: " + curso.getCargaHoraria() + " horas").setFontSize(12));
            document.add(new Paragraph("Professor: " + curso.getProfessor().getNome()).setFontSize(12));

            document.add(new Paragraph(" "));

            // Tabela de estudantes
            float[] columnWidths = {50F, 200F, 100F};
            Table table = new Table(columnWidths);
            table.addCell("ID");
            table.addCell("Nome");

            for (Estudante estudante : estudantes) {
                table.addCell(String.valueOf(estudante.getMatricula()));
                table.addCell(estudante.getNome());
            }

            document.add(table);
            document.close();

            return out.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar relatório PDF", e);
        }
    }
}
