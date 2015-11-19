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
import model.Recebimento;

public class DaoRecebimento implements IDaoRecebimento {

	@Override
	public void adicionar(Recebimento r) {
		try {
			Connection con = DatabaseConnection.getConnection();

			StringBuffer sb = new StringBuffer();

			sb.append("INSERT INTO tb_recebimento(dt_entrada, tp_entrada, nf_numero, nf_valor, peso, qtde_volumes, cnpj_cliente, destinatario, status) ");
			sb.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

			PreparedStatement st = con.prepareStatement(sb.toString());
			st.setDate(1, dataBanco(r.getDataEntrada()));
			st.setString(2, r.getTipoEntrada());
			st.setDouble(3, r.getNotaFiscal());
			st.setDouble(4, r.getValorNf());
			st.setDouble(5, r.getPeso());
			st.setInt(6, r.getVolumes());
			st.setString(7, r.getCnpjCli());
			st.setString(8, r.getDestinatario());
			st.setString(9, EnumStatusRecebimento.GALPÃO.toString());

			st.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Recebimento> listarPorCliente(String cnpj) {
		List<Recebimento> lista = new ArrayList<Recebimento>();
		try {
			Connection con = DatabaseConnection.getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT dt_entrada, tp_entrada, nf_numero, nf_valor, peso, qtde_volumes, cnpj_cliente, destinatario, status ");
			sb.append("FROM tb_recebimento WHERE cnpj_cliente = ? ORDER BY dt_entrada DESC");

			PreparedStatement st = con.prepareStatement(sb.toString());
			st.setString(1, cnpj);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Recebimento r = new Recebimento();
				r.setDataEntrada(rs.getDate("dt_entrada"));
				r.setTipoEntrada(rs.getString("tp_entrada"));
				r.setNotaFiscal(rs.getInt("nf_numero"));
				r.setValorNf(rs.getDouble("nf_valor"));
				r.setPeso(rs.getDouble("peso"));
				r.setVolumes(rs.getInt("qtde_volumes"));
				r.setCnpjCli(rs.getString("cnpj_cliente"));
				r.setDestinatario(rs.getString("destinatario"));
				r.setStatus(rs.getString("status"));

				lista.add(r);

			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	@Override
	public List<Recebimento> listarPorData(Date dataIni, Date dataFim) {
		List<Recebimento> lista = new ArrayList<Recebimento>();
		try {
			Connection con = DatabaseConnection.getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT dt_entrada, tp_entrada, nf_numero, nf_valor, peso, qtde_volumes, cnpj_cliente, destinatario, status ");
			sb.append("FROM tb_recebimento WHERE dt_entrada BETWEN ? AND ? ORDER BY dt_entrada DESC");

			PreparedStatement st = con.prepareStatement(sb.toString());
			st.setDate(1, dataBanco(dataIni));
			st.setDate(2, dataBanco(dataFim));
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Recebimento r = new Recebimento();
				r.setDataEntrada(rs.getDate("dt_entrada"));
				r.setTipoEntrada(rs.getString("tp_entrada"));
				r.setNotaFiscal(rs.getInt("nf_numero"));
				r.setValorNf(rs.getDouble("nf_valor"));
				r.setPeso(rs.getDouble("peso"));
				r.setVolumes(rs.getInt("qtde_volumes"));
				r.setCnpjCli(rs.getString("cnpj_cliente"));
				r.setDestinatario(rs.getString("destinatario"));
				r.setStatus(rs.getString("status"));

				lista.add(r);
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Recebimento buscarRecebimento(int nota, String cnpj) {
		Recebimento r = null;
		try {
			Connection con = DatabaseConnection.getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT dt_entrada, tp_entrada, nf_numero, nf_valor, peso, qtde_volumes, cnpj_cliente, destinatario ");
			sb.append("FROM tb_recebimento WHERE nf_numero = ? and cnpj_cliente = ?");

			PreparedStatement st = con.prepareStatement(sb.toString());
			st.setInt(1, nota);
			st.setString(2, cnpj);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				r = new Recebimento();
				r.setDataEntrada(rs.getDate("dt_entrada"));
				r.setTipoEntrada(rs.getString("tp_entrada"));
				r.setNotaFiscal(rs.getInt("nf_numero"));
				r.setValorNf(rs.getDouble("nf_valor"));
				r.setPeso(rs.getDouble("peso"));
				r.setVolumes(rs.getInt("qtde_volumes"));
				r.setCnpjCli(rs.getString("cnpj_cliente"));
				r.setDestinatario(rs.getString("destinatario"));

			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return r;

	}

	@Override
	public List<Recebimento> listarPorStatus(String status) {
		List<Recebimento> lista = new ArrayList<Recebimento>();
		try {
			Connection con = DatabaseConnection.getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT dt_entrada, tp_entrada, nf_numero, nf_valor, peso, qtde_volumes, cnpj_cliente, destinatario, status ");
			sb.append("FROM tb_recebimento WHERE status = ? ORDER BY dt_entrada ASC");

			PreparedStatement st = con.prepareStatement(sb.toString());
			st.setString(1, status);
			
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Recebimento r = new Recebimento();
				r.setDataEntrada(rs.getDate("dt_entrada"));
				r.setTipoEntrada(rs.getString("tp_entrada"));
				r.setNotaFiscal(rs.getInt("nf_numero"));
				r.setValorNf(rs.getDouble("nf_valor"));
				r.setPeso(rs.getDouble("peso"));
				r.setVolumes(rs.getInt("qtde_volumes"));
				r.setCnpjCli(rs.getString("cnpj_cliente"));
				r.setDestinatario(rs.getString("destinatario"));
				r.setStatus(rs.getString("status"));

				lista.add(r);
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
