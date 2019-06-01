package br.com.caelum.relatorio.modelo;

import java.math.BigDecimal;
import java.util.Date;

public class Movimentacao {

	private Integer id;
	private String descricao;
	private Date data;
	private BigDecimal valor;
	private String tipoMovimentacao;

	public Movimentacao(Integer id, Date data, String descricao, 
			String tipoMovimentacao, BigDecimal valor) {
		this.id = id;
		this.data = data;
		this.tipoMovimentacao = tipoMovimentacao;
		this.valor = valor;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public Date getData() {
		return data;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public String getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	@Override
	public String toString() {
		return "Movimentacao [id=" + id + ", descricao=" + descricao
				+ ", valor=" + valor + ", tipoMovimentacao=" + tipoMovimentacao +
				"]";
	}

}
