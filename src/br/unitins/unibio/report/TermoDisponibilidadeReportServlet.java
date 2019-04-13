package br.unitins.unibio.report;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;

import br.unitins.unibio.factory.JPAFactory;


@WebServlet("/TermoDisponibilidade")
public class TermoDisponibilidadeReportServlet extends ReportServlet {

	private static final long serialVersionUID = 9141996493770740470L;

	@Override
	public String getArquivoJasper() {
		return "TermoDisponibilidade.jasper";
	}

	@Override
	public HashMap<String, Class<?>> getParametros() {
		HashMap<String, Class<?>> param = new HashMap<String, Class<?>>();
		param.put("USUARIO_CPF", String.class);
		param.put("CURSO_ID", Integer.class);
		param.put("DIA_SEMANA", String.class);
		param.put("PERIODO", String.class);
		return param;
	}

	@Override
	public EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}

}
