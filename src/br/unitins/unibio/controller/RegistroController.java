package br.unitins.unibio.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.unibio.application.Session;
import br.unitins.unibio.application.Util;
import br.unitins.unibio.model.Disciplina;
import br.unitins.unibio.model.Registro;
import br.unitins.unibio.model.RelatorioRegistro;
import br.unitins.unibio.model.Usuario;
import br.unitins.unibio.report.TesteGeraRelatorioComBeanDataSource;
import br.unitins.unibio.repository.DisciplinaRepository;

@Named
@ViewScoped
public class RegistroController extends Controller<Registro> {

	private static final long serialVersionUID = -2275796299294713882L;

	public RegistroController() {
		super(null);

		popularListaDisciplina();
	}

	private List<Registro> listaRegistro = null;
	private List<RelatorioRegistro> listaRelatorioRegistro = null;

	private Date dtInicial;
	private Date dtFinal;

	private String diaSemana;
	private Disciplina disciplina;
	private List<Disciplina> listaDisciplina = null;

	public List<Disciplina> getListaDisciplina() {
		if (listaDisciplina == null)
			listaDisciplina = new ArrayList<Disciplina>();
		return listaDisciplina;
	}

	public void popularListaDisciplina() {
		Usuario usuario = (Usuario) Session.getInstance().getAttribute("usuarioLogado");
		DisciplinaRepository repository = new DisciplinaRepository(getEntityManager());
		listaDisciplina = repository.getDisciplinaByUsuario(usuario);
	}

	@Override
	public Registro incluir() {

		String data = Util.getData();
		String dia = Util.getDia();
		String hora = Util.getHora();

		getEntity().setData(data);
		getEntity().setDia(dia);
		getEntity().setHora(hora);
		getEntity().setTipo(2);
		getEntity().setUsuario(getUsuarioLogado());

		return super.incluir();
	}

	@Override
	public Registro alterar() {
		return super.alterar();
	}

	@Override
	public Registro getEntity() {
		if (entity == null)
			entity = new Registro();
		return entity;
	}

	@Override
	public void limpar() {
		setEntity(null);
		listaRegistro = null;
	}

	public List<Registro> getListaRegistro() {
		if (listaRegistro == null)
			listaRegistro = new ArrayList<Registro>();
		return listaRegistro;
	}

	public List<RelatorioRegistro> getListaRelatorioRegistro() {
		if (listaRelatorioRegistro == null)
			listaRelatorioRegistro = new ArrayList<RelatorioRegistro>();
		return listaRelatorioRegistro;
	}

//	public void pesquisar() {
//		Usuario usuario = getUsuarioLogado();
//		RegistroRepository repository = new RegistroRepository(getEntityManager());
//		listaRelatorioRegistro = repository.getListaRelatorioRegistro(usuario, getDtInicial(), getDtFinal());
//	}

	public void imprimir() {
		try {
			TesteGeraRelatorioComBeanDataSource.gerarRelatorioFrequencia(getEntityManager(), getDisciplina(), getDtInicial(), getDtFinal());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Date getDtInicial() {
		return dtInicial;
	}

	public void setDtInicial(Date dtInicial) {
		this.dtInicial = dtInicial;
	}

	public Date getDtFinal() {
		return dtFinal;
	}

	public void setDtFinal(Date dtFinal) {
		this.dtFinal = dtFinal;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Disciplina getDisciplina() {
		if (disciplina == null)
			disciplina = new Disciplina();
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
