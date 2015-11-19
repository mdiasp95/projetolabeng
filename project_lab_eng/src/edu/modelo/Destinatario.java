package edu.modelo;

public class Destinatario extends Cliente {
	String cnpj;
	String contato;
	String servProd;
	String observacao;

	public Destinatario(String cnpj) {
		super();
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	
	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getServProd() {
		return servProd;
	}

	public void setServProd(String servProd) {
		this.servProd = servProd;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
