package edu.dao;

import java.util.List;

import edu.modelo.Destinatario;



public interface IDaoDestinatario {

	public void adicionar(Destinatario d);

	public void alterar(Destinatario d);

	public void remover(Destinatario d);

	public Destinatario selecionar(String cnpj);
}
