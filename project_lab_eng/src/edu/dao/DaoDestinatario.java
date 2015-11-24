package edu.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.dao.DatabaseConnection;
import edu.modelo.Cliente;
import edu.modelo.Destinatario;
import edu.modelo.Entrega;

public class DaoDestinatario implements IDaoDestinatario {

	public void adicionar(Destinatario d) {
		try {
			Connection con = DatabaseConnection.getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO tb_destinatario(cnpj_cliente, contato, servprod, observacao ) ");
			sb.append("VALUES (?,?,?,?)");

			PreparedStatement st = con.prepareStatement(sb.toString());
			st.setString(1, d.getCnpj());
			st.setString(2, d.getContato());
			st.setString(3, d.getServProd());
			st.setString(4, d.getObservacao());
			st.executeUpdate();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Destinatario d) {
		try {
			Connection con = DatabaseConnection.getConnection();

			StringBuffer sb = new StringBuffer();
			sb.append("UPDATE tb_destinatario SET ");
			sb.append("contato = ?, servprod = ?,observacao = ? ");
			sb.append("WHERE  cnpj_cliente = ?");

			PreparedStatement st = con.prepareStatement(sb.toString());
			st.setString(1, d.getContato());
			st.setString(2, d.getServProd());
			st.setString(3, d.getObservacao());
			st.setString(4, d.getCnpj());
			st.executeUpdate();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void remover(Destinatario d) {
		try {
			Connection con = DatabaseConnection.getConnection();
			String sql = "DELETE FROM tb_destinatario WHERE cnpj_cliente = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, d.getCnpj());
			st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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

	public Destinatario selecionar(String cnpj) {
		Connection con;
		Destinatario d = null;
		try {
			con = DatabaseConnection.getConnection();
			String sql = "SELECT * from tb_destinatario where cnpj_cliente = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, cnpj);
			System.out.println(st.toString());
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				d = new Destinatario(cnpj);
				d.setContato(rs.getString("contato"));
				d.setObservacao(rs.getString("observacao"));
				d.setServProd(rs.getString("servprod"));
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return d;
	}
}
