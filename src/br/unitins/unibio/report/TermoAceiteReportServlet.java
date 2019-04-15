package br.unitins.unibio.report;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;

import br.unitins.unibio.factory.JPAFactory;


@WebServlet("/TermoAceite")
public class TermoAceiteReportServlet extends ReportServlet {

	private static final long serialVersionUID = 1498447842163614442L;

	@Override
	public String getArquivoJasper() {
		return "TermoAceite.jasper";
	}

	@Override
	public HashMap<String, Class<?>> getParametros() {
		HashMap<String, Class<?>> param = new HashMap<String, Class<?>>();
		param.put("USUARIO_CPF", String.class);
		return param;
	}

	@Override
	public EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}

}
