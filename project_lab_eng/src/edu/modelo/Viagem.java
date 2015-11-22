package edu.modelo;

import java.util.Date;
import java.util.List;

public class Viagem {	
	
	Date dataSaida;
	Date dataChegada;
	int kmSaida;
	int kmChegada;
	String cidadeDestino;
	Motorista motorista;
	Veiculo veiculo;
	List<Entrega> entregas;
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	public Date getDataChegada() {
		return dataChegada;
	}
	public void setDataChegada(Date dataChegada) {
		this.dataChegada = dataChegada;
	}
	public int getKmSaida() {
		return kmSaida;
	}
	public void setKmSaida(int kmSaida) {
		this.kmSaida = kmSaida;
	}
	public int getKmChegada() {
		return kmChegada;
	}
	public void setKmChegada(int kmChegada) {
		this.kmChegada = kmChegada;
	}
	public String getCidadeDestino() {
		return cidadeDestino;
	}
	public void setCidadeDestino(String cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public List<Entrega> getEntregas() {
		return entregas;
	}
	public void setEntregas(List<Entrega> entregas) {
		this.entregas = entregas;
	}
	
	

}
