package poo.ucb.Gerenciamento_Estudantil.model.services.utilRelatorios;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.springframework.stereotype.Service;
import poo.ucb.Gerenciamento_Estudantil.model.entities.Estudante;
import poo.ucb.Gerenciamento_Estudantil.model.services.EstudanteService;

import java.io.ByteArrayOutputStream;

@Service
public class RelatorioServiceEstudante{

    public byte[] gerarRelatorioCursoPDF(EstudanteService estudanteService) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Título
            document.add(new Paragraph("Relatório Estudantes").setFontSize(14));

            document.add(new Paragraph(" "));

            // Tabela de estudantes
            float[] columnWidths = {50F, 200F, 100F};
            Table table = new Table(columnWidths);
            table.addCell("ID");
            table.addCell("Nome");
            table.addCell("Idade");

            for (Estudante estudante : estudanteService.listarEstudantes()) {
                table.addCell(String.valueOf(estudante.getMatricula()));
                table.addCell(estudante.getNome());
                table.addCell(String.valueOf(estudante.getIdade()));
            }

            document.add(table);
            document.close();

            return out.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar relatório PDF", e);
        }
    }
}
