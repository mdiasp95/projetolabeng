package edu.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.dao.DatabaseConnection;
import edu.modelo.Motorista;

public class DaoMotorista implements IDaoMotorista {

	
	public void adicionar(Motorista f) {
		try {
			Connection con = DatabaseConnection.getConnection();

			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO tb_motorista(cnh, nome, categoria, vencimento, moop,");
			sb.append("fone, status, dtcadastro) ");
			sb.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?);");

			PreparedStatement st = con.prepareStatement(sb.toString());
			st.setString(1, f.getCnh());
			st.setString(2, f.getNome());
			st.setString(3, f.getCategoria());
			st.setDate(4, dataBanco(f.getVencimento()));
			st.setBoolean(5, f.isMopp());
			st.setString(6, f.getFone());
			st.setString(7, f.getStatus());
			st.setDate(8, dataBanco(f.getDtCadastro()));

			st.executeUpdate();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Motorista f) {
		try {
			Connection con = DatabaseConnection.getConnection();


			StringBuffer sb = new StringBuffer();
			sb.append("UPDATE tb_motorista SET nome = ?, categoria = ?, vencimento = ? ");
			sb.append(",moop = ?, fone = ?, status = ?, dtCadastro = ? ");
			sb.append("WHERE  cnh = ?; ");

			PreparedStatement st = con.prepareStatement(sb.toString());
			st.setString(1, f.getNome());
			st.setString(2, f.getCategoria());
			st.setDate(3, dataBanco(f.getVencimento()));
			st.setBoolean(4, f.isMopp());
			st.setString(5, f.getFone());
			st.setString(6, f.getStatus());
			st.setDate(7, dataBanco(f.getDtCadastro()));
			st.setString(8,f.getCnh());
			System.out.println(st.toString());
			st.executeUpdate();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void remover(Motorista f) {
		try {
			Connection con = DatabaseConnection.getConnection();
			String sql = "DELETE FROM tb_motorista WHERE cnh = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, f.getCnh());
			st.executeUpdate();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Motorista> listar() {

		List<Motorista> lista = new ArrayList<Motorista>();
		try {
			Connection con = DatabaseConnection.getConnection();

			StringBuffer sb = new StringBuffer();
			sb.append("SELECT cnh, nome, categoria, ");
			sb.append("vencimento, moop, fone, status, dtCadastro ");
			sb.append("FROM tb_motorista");
			PreparedStatement st = con.prepareStatement(sb.toString());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Motorista f = new Motorista();
				f.setCnh(rs.getString("cnh"));
				f.setNome(rs.getString("nome"));
				f.setCategoria(rs.getString("categoria"));
				f.setVencimento(rs.getDate("vencimento"));
				f.setMopp(rs.getBoolean("moop"));
				f.setStatus(rs.getString("status"));
				f.setDtCadastro(rs.getDate("dtcadastro"));
				lista.add(f);
			}
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}


	
	public Motorista BuscarPorCNH(String t) {
		Motorista f = new Motorista();
		try {
			Connection con = DatabaseConnection.getConnection();
			String sql = "SELECT  * FROM tb_motorista WHERE cnh = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				
				f.setCnh(rs.getString("cnh"));
				f.setNome(rs.getString("nome"));
				f.setCategoria(rs.getString("categoria"));
				f.setVencimento(rs.getDate("vencimento"));
				f.setMopp(rs.getBoolean("moop"));
				f.setStatus(rs.getString("status"));
				f.setDtCadastro(rs.getDate("dtcadastro"));

			}
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

	private java.sql.Date dataBanco(Date data) {
		try {
			return new java.sql.Date(data.getTime());
		} catch (Exception e) {
			return null;
		}
	}



}
