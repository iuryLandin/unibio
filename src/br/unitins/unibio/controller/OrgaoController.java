package br.unitins.unibio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.unibio.model.Endereco;
import br.unitins.unibio.model.Orgao;
import br.unitins.unibio.repository.OrgaoRepository;

@Named
@ViewScoped
public class OrgaoController extends Controller<Orgao> {

	private static final long serialVersionUID = -2275796299294713882L;

	public OrgaoController() {
		super(null);
	}

	private String pesquisa;
	private List<Orgao> listaOrgao = null;
	private Endereco endereco;

	@Override
	public Orgao incluir() {
		getEntity().setEndereco(getEndereco());
		return super.incluir();
	}

	@Override
	public Orgao alterar() {
		getEntity().setEndereco(getEndereco());
		return super.alterar();
	}

	@Override
	public Orgao getEntity() {
		if (entity == null)
			entity = new Orgao();
		return entity;
	}

	@Override
	public void limpar() {
		setEntity(null);
		listaOrgao = null;
	}

	public List<Orgao> getListaOrgao() {
		if (listaOrgao == null)
			listaOrgao = new ArrayList<Orgao>();
		return listaOrgao;
	}

	public void pesquisar() {
		OrgaoRepository repository = new OrgaoRepository(getEntityManager());
		listaOrgao = repository.getOrgaos(pesquisa);
	}

	public Endereco getEndereco() {
		if (endereco == null)
			endereco = new Endereco();
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

}
