package br.unitins.unibio.report;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;

import br.unitins.unibio.factory.JPAFactory;


@WebServlet("/TermoResponsabilidade")
public class TermoResponsabilidadeReportServlet extends ReportServlet {

	private static final long serialVersionUID = 1498447842163614442L;

	@Override
	public String getArquivoJasper() {
		return "TermoResponsabilidade.jasper";
	}

	@Override
	public HashMap<String, Class<?>> getParametros() {
		HashMap<String, Class<?>> param = new HashMap<String, Class<?>>();
		param.put("USUARIO_CPF", String.class);
		param.put("PERIODO", String.class);
		param.put("PRODESSOR_NOME", String.class);
		param.put("TEMA", String.class);
		return param;
	}

	@Override
	public EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}

}
