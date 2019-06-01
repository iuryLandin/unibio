package br.com.caelum.relatorio.teste;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.caelum.relatorio.GeradorRelatorioDS;
import br.com.caelum.relatorio.modelo.Movimentacao;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class TesteGeraRelatorioComBeanDataSource {

	public static void main(String[] args) throws SQLException, JRException, FileNotFoundException {
		
		String nome = "movimentacoes";

		JasperCompileManager.compileReportToFile(nome + ".jrxml"); 

		Map<String, Object> parametros = new HashMap<String, Object>();

		List<Movimentacao> listaMovimentacao = Arrays.asList(
				new Movimentacao(1,new Date(),"Telefone","SAIDA",new BigDecimal("143.7")),
				new Movimentacao(2,new Date(),"Agua","SAIDA",new BigDecimal("36.8")),
				new Movimentacao(3,new Date(),"Luz","SAIDA",new BigDecimal("46.91"))
				);

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaMovimentacao);
		
		GeradorRelatorioDS geradorRelatorio = new GeradorRelatorioDS(nome, parametros, dataSource);
		geradorRelatorio.geraPDFRelatorio(new FileOutputStream(nome + ".pdf"));
	}
}
