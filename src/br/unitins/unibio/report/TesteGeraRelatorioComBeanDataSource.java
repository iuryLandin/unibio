package br.unitins.unibio.report;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.ServletContext;

import br.unitins.unibio.application.Session;
import br.unitins.unibio.application.Util;
import br.unitins.unibio.model.Disciplina;
import br.unitins.unibio.model.RelatorioRegistro;
import br.unitins.unibio.model.Usuario;
import br.unitins.unibio.repository.RegistroRepository;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class TesteGeraRelatorioComBeanDataSource {
	static List<RelatorioRegistro> listaRelatorioRegistro = null;
	
	 

	public static void gerarRelatorioFrequencia(EntityManager em, Disciplina disciplina, Date inicio, Date fim) throws FileNotFoundException {
		
		try {
			ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
				    
			String nome = servletContext.getRealPath("/reports/RegistroFrequencia" );

			Usuario usuario =  (Usuario) Session.getInstance().getAttribute( "usuarioLogado" );
			
			RegistroRepository repository = new RegistroRepository( em );
			listaRelatorioRegistro = repository.getListaRelatorioRegistro(usuario, disciplina, inicio, fim);
			
			JasperCompileManager.compileReportToFile( nome + ".jrxml");
			
			Map<String, Object> parametros = new HashMap<String, Object>();
			
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaRelatorioRegistro);
			
			GeradorRelatorioDS geradorRelatorio = new GeradorRelatorioDS(nome, parametros, dataSource);
			geradorRelatorio.geraPDFRelatorio(new FileOutputStream(nome + ".pdf"));
			
			Util.redirect("../reports/RegistroFrequencia.pdf");
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		} 

		
	}
	
	
}
