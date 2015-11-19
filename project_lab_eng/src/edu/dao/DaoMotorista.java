package edu.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.dao.DatabaseConnection;
import model.Motorista;

public class DaoMotorista implements IDaoMotorista {

	@Override
	public void adicionar(Motorista f) {
		try {
			Connection con = DatabaseConnection.getConnection();

			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO tb_motorista(nome, cep, rua, numero, complemento, bairro, cidade, uf, ");
			sb.append("fone1, fone2, status, dt_cadastro, rg, cpf_motorista, cnh_numero, cnh_categoria, cnh_vencimento, cnh_mopp) ");
			sb.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			PreparedStatement st = con.prepareStatement(sb.toString());
			st.setString(1, f.getNome());
			st.setString(2, f.getCep());
			st.setString(3, f.getRua());
			st.setString(4, f.getNum());
			st.setString(5, f.getCompl());
			st.setString(6, f.getBairro());
			st.setString(7, f.getCidade());
			st.setString(8, f.getUf());
			st.setString(9, f.getFone1());
			st.setString(10, f.getFone2());
			st.setString(11, f.getStatus());
			st.setDate(12, dataBanco(new Date()));
			st.setString(13, f.getRg());
			st.setLong(14, f.getCpf());
			st.setString(15, f.getCnh());
			st.setString(16, f.getCategoria());
			st.setDate(17, dataBanco(f.getVencimento()));
			st.setBoolean(18, f.isMopp());

			st.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Motorista f) {
		try {
			Connection con = DatabaseConnection.getConnection();

			StringBuffer sb = new StringBuffer();
			sb.append("UPDATE tb_motorista SET nome = ?, cep = ?, rua = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, uf = ?, ");
			sb.append("fone1 = ?, fone2 = ?, status = ?, rg = ?, cnh_numero = ?, cnh_categoria = ?, cnh_vencimento = ?, cnh_mopp =? ");
			sb.append("WHERE  cpf_motorista = ?");

			PreparedStatement st = con.prepareStatement(sb.toString());
			st.setString(1, f.getNome());
			st.setString(2, f.getCep());
			st.setString(3, f.getRua());
			st.setString(4, f.getNum());
			st.setString(5, f.getCompl());
			st.setString(6, f.getBairro());
			st.setString(7, f.getCidade());
			st.setString(8, f.getUf());
			st.setString(9, f.getFone1());
			st.setString(10, f.getFone2());
			st.setString(11, f.getStatus());
			st.setString(12, f.getRg());
			st.setString(13, f.getCnh());
			st.setString(14, f.getCategoria());
			st.setDate(15, dataBanco(f.getVencimento()));
			st.setBoolean(16, f.isMopp());
			st.setLong(17, f.getCpf());
			st.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void remover(Motorista f) {
		try {
			Connection con = DatabaseConnection.getConnection();
			String sql = "DELETE FROM tb_motorista WHERE cpf_motorista = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setLong(1, f.getCpf());
			st.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Motorista> listar() {

		List<Motorista> lista = new ArrayList<Motorista>();
		try {
			Connection con = DatabaseConnection.getConnection();

			StringBuffer sb = new StringBuffer();
			sb.append("SELECT nome, cep, rua, numero, complemento, bairro, cidade, uf, ");
			sb.append("fone1, fone2, status, dt_cadastro, rg, cpf_motorista, cnh_numero, cnh_categoria, cnh_vencimento, cnh_mopp ");
			sb.append("FROM tb_motorista");
			PreparedStatement st = con.prepareStatement(sb.toString());

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Motorista f = new Motorista(rs.getInt("cpf_motorista"));
				f.setNome(rs.getString("nome"));
				f.setCep(rs.getString("cep"));
				f.setRua(rs.getString("rua"));
				f.setNum(rs.getString("numero"));
				f.setCompl(rs.getString("complemento"));
				f.setBairro(rs.getString("bairro"));
				f.setCidade(rs.getString("cidade"));
				f.setUf(rs.getString("uf"));
				f.setFone1(rs.getString("fone1"));
				f.setFone2(rs.getString("fone2"));
				f.setStatus(rs.getString("status"));
				f.setDtCadastro(rs.getDate("dt_cadastro"));
				f.setRg(rs.getString("rg"));
				f.setCnh(rs.getString("cnh_numero"));
				f.setCategoria(rs.getString("cnh_categoria"));
				f.setVencimento(rs.getDate("cnh_vencimento"));
				f.setMopp(rs.getBoolean("cnh_mopp"));

				lista.add(f);
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public List<Motorista> listarPorCpf(int t) {
		List<Motorista> lista = new ArrayList<Motorista>();
		try {
			Connection con = DatabaseConnection.getConnection();

			StringBuffer sb = new StringBuffer();
			sb.append("SELECT nome, cep, rua, numero, complemento, bairro, cidade, uf, ");
			sb.append("fone1, fone2, status, dt_cadastro, rg, cpf_motorista, cnh_numero, cnh_categoria, cnh_vencimento, cnh_mopp ");
			sb.append("FROM tb_motorista WHERE cpf_motorista = ?");
			PreparedStatement st = con.prepareStatement(sb.toString());
			st.setLong(1, t);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Motorista f = new Motorista(rs.getInt("cpf_motorista"));
				f.setNome(rs.getString("nome"));
				f.setCep(rs.getString("cep"));
				f.setRua(rs.getString("rua"));
				f.setNum(rs.getString("numero"));
				f.setCompl(rs.getString("complemento"));
				f.setBairro(rs.getString("bairro"));
				f.setCidade(rs.getString("cidade"));
				f.setUf(rs.getString("uf"));
				f.setFone1(rs.getString("fone1"));
				f.setFone2(rs.getString("fone2"));
				f.setStatus(rs.getString("status"));
				f.setDtCadastro(rs.getDate("dt_cadastro"));
				f.setRg(rs.getString("rg"));
				f.setCnh(rs.getString("cnh_numero"));
				f.setCategoria(rs.getString("cnh_categoria"));
				f.setVencimento(rs.getDate("cnh_vencimento"));
				f.setMopp(rs.getBoolean("cnh_mopp"));
				lista.add(f);
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public List<Motorista> listarPorNome(String t) {
		List<Motorista> lista = new ArrayList<Motorista>();
		try {
			Connection con = DatabaseConnection.getConnection();

			StringBuffer sb = new StringBuffer();
			sb.append("SELECT nome, cep, rua, numero, complemento, bairro, cidade, uf, ");
			sb.append("fone1, fone2, status, dt_cadastro, rg, cpf_motorista, cnh_numero, cnh_categoria, cnh_vencimento, cnh_mopp ");
			sb.append("FROM tb_motorista WHERE nome like ?");
			PreparedStatement st = con.prepareStatement(sb.toString());
			st.setString(1, "%" + t + "%");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Motorista f = new Motorista(rs.getInt("cpf_motorista"));
				f.setNome(rs.getString("nome"));
				f.setCep(rs.getString("cep"));
				f.setRua(rs.getString("rua"));
				f.setNum(rs.getString("numero"));
				f.setCompl(rs.getString("complemento"));
				f.setBairro(rs.getString("bairro"));
				f.setCidade(rs.getString("cidade"));
				f.setUf(rs.getString("uf"));
				f.setFone1(rs.getString("fone1"));
				f.setFone2(rs.getString("fone2"));
				f.setStatus(rs.getString("status"));
				f.setDtCadastro(rs.getDate("dt_cadastro"));
				f.setRg(rs.getString("rg"));
				f.setCnh(rs.getString("cnh_numero"));
				f.setCategoria(rs.getString("cnh_categoria"));
				f.setVencimento(rs.getDate("cnh_vencimento"));
				f.setMopp(rs.getBoolean("cnh_mopp"));

				lista.add(f);
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	private java.sql.Date dataBanco(Date data) {
		try {
			return new java.sql.Date(data.getTime());
		} catch (Exception e) {
			return null;
		}
	}

}
