package edu.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.dao.DatabaseConnection;
import servicos.EnumStatusRecebimento;
import servicos.EnumStatusVeiculo;
import servicos.EnumTipoRecebimento;
import model.Entrega;
import model.Recebimento;
import model.Veiculo;
import model.Viagem;

public class DaoViagem implements IDaoViagem {

	@Override
	public void adicionarViagem(Viagem via) {
		
		try {
			Connection con = DatabaseConnection.getConnection();

			StringBuffer sb = new StringBuffer();

			sb.append("INSERT INTO tb_viagem (dt_saida, km_saida, placa, cpf_motorista) ");
			sb.append("VALUES (?, ?, ?, ?)");
			
			PreparedStatement st = con.prepareStatement(sb.toString());
			st.setDate(1, dataBanco(new Date()));
			st.setInt(2, via.getKmSaida());
			st.setString(3, via.getPlaca());
			st.setInt(4, via.getCpfMot());

			st.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	

	private java.sql.Date dataBanco(Date data) {
		try {
			return new java.sql.Date(data.getTime());
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void atualizar(Viagem via) {
		// TODO Auto-generated method stub

	}

	@Override
	public Viagem buscarViagem(int nota, String cnpj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Viagem> listarPorCliente(String cli) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Viagem> listarPorData(Date dataIni, Date dataFim) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Viagem> listarPorStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}



	

}
