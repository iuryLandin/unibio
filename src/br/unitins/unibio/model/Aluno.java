package br.unitins.unibio.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Tabela_Aluno")
public class Aluno extends Pessoa {

	private static final long serialVersionUID = -3763771903748482697L;
	
	private byte[] digital;
	

	public byte[] getDigital() {
		return digital;
	}

	public void setDigital(byte[] digital) {
		this.digital = digital;
	}
	
	

}
