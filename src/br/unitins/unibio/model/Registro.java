package br.unitins.unibio.model;

public class Registro extends DefaultEntity<Registro> {

	private static final long serialVersionUID = -826144251430323374L;

	private String data;
	private String entrada;
	private String saida;
	private Matricula matricula;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	 

}
