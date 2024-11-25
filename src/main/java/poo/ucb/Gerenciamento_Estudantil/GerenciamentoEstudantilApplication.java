package poo.ucb.Gerenciamento_Estudantil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import poo.ucb.Gerenciamento_Estudantil.view.*;

import javax.swing.SwingUtilities;

@SpringBootApplication(scanBasePackages = "poo.ucb.Gerenciamento_Estudantil")
@ComponentScan(basePackages = "poo.ucb.Gerenciamento_Estudantil")
public class GerenciamentoEstudantilApplication {

	public static void main(String[] args) {
		new MenuInicial();
		// Inicia o contexto Spring
		ConfigurableApplicationContext context = SpringApplication.run(GerenciamentoEstudantilApplication.class, args);

		// Lança a interface Swing no Event Dispatch Thread
		SwingUtilities.invokeLater(() -> {
			// Obtém o bean da interface gráfica gerenciado pelo Spring
			MenuInicial menuInicial = context.getBean(MenuInicial.class);
			menuInicial.setVisible(true); // Exibe a janela
		});
	}
}
