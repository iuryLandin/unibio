package br.unitins.unibio.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.unibio.model.Disciplina;
import br.unitins.unibio.model.Registro;
import br.unitins.unibio.model.RelatorioRegistro;
import br.unitins.unibio.model.Usuario;

public class RegistroRepository extends Repository<Registro> {

	public RegistroRepository(EntityManager em) {
		super(em);
	}

	@SuppressWarnings("unchecked")
	public List<Registro> getRegistros() {
		List<Registro> lista = getEntityManager().createQuery("Select r From Registro r Order by r.id desc")
				.getResultList();
		if (lista == null)
			lista = new ArrayList<Registro>();
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<RelatorioRegistro> getListaRelatorioRegistro(Usuario usuario, Disciplina disciplina, Date dtInicial, Date dtFinal) {
		List<RelatorioRegistro> lista = new ArrayList<RelatorioRegistro>();

		try {
			Date startDate = dtInicial;
			Date endDate = dtFinal;
 

			Calendar start = Calendar.getInstance();
			start.setTime(startDate);
			Calendar end = Calendar.getInstance();
			end.setTime(endDate);

			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

			RelatorioRegistro relatorioRegistro = new RelatorioRegistro();

			for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {

				String strDate = dateFormat.format(date);

				Query query = getEntityManager().createNativeQuery("SELECT id, data, dia, "
						+ " (SELECT hora FROM registro WHERE idusuario = ?usuario AND data = ?strDate ORDER BY hora ASC LIMIT 1) AS entrada, "
						+ " (SELECT hora FROM registro WHERE idusuario = ?usuario AND data = ?strDate ORDER BY hora DESC LIMIT 1) AS saida "
						+ " FROM registro WHERE data = ?strDate AND dia = ?diaSemana LIMIT 1; ");
				query.setParameter("strDate", strDate);
				query.setParameter("usuario", usuario.getId() );
				query.setParameter("diaSemana", disciplina.getDiaSemana() );
				
				try {
				Object[] result = (Object[]) query.getSingleResult();
 

					String data = (String) result[1];
					String dia = (String) result[2];
					String entrada = (String) result[3];
					String saida = (String) result[4];

					if (relatorioRegistro == null)
						relatorioRegistro = new RelatorioRegistro();

					relatorioRegistro.setData(data);
					relatorioRegistro.setDia(dia);
					relatorioRegistro.setEntrada(entrada);
					relatorioRegistro.setSaida(saida);
					relatorioRegistro.setNome(usuario.getNome());
					relatorioRegistro.setMatricula(usuario.getMatricula());
					relatorioRegistro.setDisciplina(disciplina.getNome());

					lista.add(relatorioRegistro);

					relatorioRegistro = null;
					result = null;
					
				} catch (Exception e) {
					// TODO: handle exception
				}

			}

		}  catch (Exception e) {
			// TODO: handle exception
		}

		return lista;

	}

}
