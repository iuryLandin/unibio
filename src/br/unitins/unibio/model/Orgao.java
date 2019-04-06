package br.unitins.unibio.model;

public class Orgao extends DefaultEntity<Orgao> {

	private static final long serialVersionUID = 3509668897074735687L;

	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private Endereco endereco;
	private String telefone;
	private String representante;
	private String repCargo;
	private String respTce;
	private String cargoRespTce;
	private String supervisor;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getRepCargo() {
		return repCargo;
	}

	public void setRepCargo(String repCargo) {
		this.repCargo = repCargo;
	}

	public String getRespTce() {
		return respTce;
	}

	public void setRespTce(String respTce) {
		this.respTce = respTce;
	}

	public String getCargoRespTce() {
		return cargoRespTce;
	}

	public void setCargoRespTce(String cargoRespTce) {
		this.cargoRespTce = cargoRespTce;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

}
