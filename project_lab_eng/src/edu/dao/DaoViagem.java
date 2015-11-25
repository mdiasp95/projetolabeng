package edu.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.dao.DatabaseConnection;
import edu.modelo.Viagem;
import servicos.EnumStatusRecebimento;
import servicos.EnumStatusVeiculo;
import servicos.EnumTipoRecebimento;

public class DaoViagem implements IDaoViagem {

	public void adicionarViagem(Viagem via) {

		try {
			Connection con = DatabaseConnection.getConnection();

			StringBuffer sb = new StringBuffer();

			sb.append("INSERT INTO tb_viagem (dt_saida, dt_chegada, km_saida, km_chegada, placa, cnh_motorista, cidadedestino) ");
			sb.append("VALUES (?, ?, ?, ?, ?, ?, ?)");

			PreparedStatement st = con.prepareStatement(sb.toString());
			st.setDate(1, dataBanco(via.getDataSaida()));
			st.setDate(2, dataBanco(via.getDataSaida()));
			st.setInt(3, via.getKmSaida());
			st.setInt(4, via.getKmChegada());
			st.setString(5, via.getVeiculo().getPlaca());
			st.setString(6, via.getMotorista().getCnh());
			st.setString(7, via.getCidadeDestino());

			st.executeUpdate();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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

	public void atualizar(Viagem via) {
		// TODO Auto-generated method stub

	}

	public Viagem buscarViagem(int nota, String cnpj) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Viagem> listarPorCliente(String cli) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Viagem> listarPorData(Date dataIni, Date dataFim) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Viagem> listarPorStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

}
