package br.unitins.unibio.model;

import javax.persistence.Entity;

@Entity
public class Aluno extends Pessoa {

	private static final long serialVersionUID = -7258996734346536445L;

	private byte digital;
	private String foto;
	
	public byte getDigital() {
		return digital;
	}
	public void setDigital(byte digital) {
		this.digital = digital;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	

}
