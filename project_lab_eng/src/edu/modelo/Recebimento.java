package edu.modelo;

import java.util.Date;

public class Recebimento {
	Date dataEntrada;
	String tipoEntrada;
	int notaFiscal;
	double valorNf;
	double peso;
	int volumes;	
	String status;
	Destinatario destinatario;
	Remetente remetente;
	
	public Recebimento(){
		super();
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getTipoEntrada() {
		return tipoEntrada;
	}
	public void setTipoEntrada(String tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}
	public int getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(int notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	public double getValorNf() {
		return valorNf;
	}
	public void setValorNf(double valorNf) {
		this.valorNf = valorNf;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public int getVolumes() {
		return volumes;
	}
	public void setVolumes(int volumes) {
		this.volumes = volumes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Destinatario getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
	}
	public Remetente getRemetente() {
		return remetente;
	}
	public void setRemetente(Remetente remetente) {
		this.remetente = remetente;
	}
	
	public String getCnpj(){
		if(destinatario != null){
			return destinatario.cnpj;
		}
		else if(remetente != null){
			return remetente.cnpj;
		}else{
			return "";
		}
	}
	public String getCnpjDestinatario(){
		return destinatario.cnpj;
			}
	public String getCnpjRemetente(){
			return remetente.cnpj;
	}
	}