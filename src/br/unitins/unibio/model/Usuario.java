package br.unitins.unibio.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends DefaultEntity<Usuario> {

	private static final long serialVersionUID = -3763771903748482697L;
	private String nome;
	private String cpf;
	private String rg;
	private String orgaoExpeditor;
	private String matricula;
	private String telefone;
	private String email;
	private String senha;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idendereco", unique = true)
	private Endereco endereco;

	private TipoUsuario tipoUsuario;
	private byte[] digital;
	private Date data_alteracao;
	private Usuario user;
	private boolean ativo;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", orphanRemoval = true)
//	private List<Disciplina> listaDisciplina;

	@ManyToMany
	@JoinTable(name = "UsuarioDisciplina", joinColumns = @JoinColumn(name = "idusuario"), inverseJoinColumns = @JoinColumn(name = "iddisciplina"))
	private List<Disciplina> listaDisciplina;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", orphanRemoval = true)
	private List<Registro> listaRegistro;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", orphanRemoval = true)
	private List<Atividade> listaAtividade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Endereco getEndereco() {
		if (endereco == null)
			endereco = new Endereco();
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public byte[] getDigital() {
		return digital;
	}

	public void setDigital(byte[] digital) {
		this.digital = digital;
	}

	public Date getData_alteracao() {
		return data_alteracao;
	}

	public void setData_alteracao(Date data_alteracao) {
		this.data_alteracao = data_alteracao;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgaoExpeditor() {
		return orgaoExpeditor;
	}

	public void setOrgaoExpeditor(String orgaoExpeditor) {
		this.orgaoExpeditor = orgaoExpeditor;
	}

	public List<Disciplina> getListaDisciplina() {
		return listaDisciplina;
	}

	public void setListaDisciplina(List<Disciplina> listaDisciplina) {
		this.listaDisciplina = listaDisciplina;
	}

	public List<Registro> getListaRegistro() {
		return listaRegistro;
	}

	public void setListaRegistro(List<Registro> listaRegistro) {
		this.listaRegistro = listaRegistro;
	}

	public List<Atividade> getListaAtividade() {
		return listaAtividade;
	}

	public void setListaAtividade(List<Atividade> listaAtividade) {
		this.listaAtividade = listaAtividade;
	}

}
