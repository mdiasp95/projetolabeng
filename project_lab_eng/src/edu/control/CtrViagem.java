package edu.control;

import edu.dao.DaoViagem;
import edu.dao.IDaoViagem;
import model.Viagem;

public class CtrViagem {
	
	private IDaoViagem dao = new DaoViagem();	
	
	public boolean adicionarViagem(Viagem via) {
		
		try {
			dao.adicionarViagem(via);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean alterar(Viagem v) {
		try {
			//dao.alterar(v);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void remover() {

	}

	
}
