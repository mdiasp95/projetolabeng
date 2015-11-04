package edu.modelo;

import java.util.Date;

public class Nota {
 
	private int notaFiscal;
	 
	private Cliente cliente;
	 
	private Caminhao caminhao;
	 
	private Motorista motorista;
	 
	private Date status;
	 
	public int getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(int notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Caminhao getCaminhao() {
		return caminhao;
	}

	public void setCaminhao(Caminhao caminhao) {
		this.caminhao = caminhao;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Date getStatus() {
		return status;
	}

	public void setStatus(Date status) {
		this.status = status;
	}



	 
}
 
