package br.unitins.unibio.model;

import javax.persistence.Entity;

import org.primefaces.model.UploadedFile;

@Entity
public class Aluno extends Pessoa {

	private static final long serialVersionUID = -7258996734346536445L;

	private byte digital;
	private UploadedFile foto;
	
	public byte getDigital() {
		return digital;
	}
	public void setDigital(byte digital) {
		this.digital = digital;
	}
	public UploadedFile getFoto() {
		return foto;
	}
	public void setFoto(UploadedFile foto) {
		this.foto = foto;
	}
 
	
	
	

}
