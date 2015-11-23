package edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import edu.modelo.Entrega;
import edu.modelo.Recebimento;

public class DaoEntrega implements IDaoEntrega{

		public void adicionar(Entrega f) {
			try {
				Connection con = DatabaseConnection.getConnection();

				StringBuffer sb = new StringBuffer();
				sb.append("INSERT INTO tb_entrega(dataSaida, dataRetorno, observacao, nfrecebimento, cnpjreceb ");
				sb.append("VALUES (?, ?, ?, ?, ?)");

				PreparedStatement st = con.prepareStatement(sb.toString());
				st.setDate(1, dataBanco(f.getDataSaida()));
				st.setDate(2, dataBanco(f.getDataRetorno()));
				st.setString(3, f.getObservacao());
				st.setInt(4, f.getRecebimento().getNotaFiscal());
				st.executeUpdate();
				con.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public void alterar(Entrega f) {
			try {
				Connection con = DatabaseConnection.getConnection();

				StringBuffer sb = new StringBuffer();
				sb.append("UPDATE tb_entrega SET datasaida = ?, dataretorno = ?, obeservacao = ?");
				sb.append("WHERE  nfrecebimento = ? and cnpjreceb = ?");

				PreparedStatement st = con.prepareStatement(sb.toString());
				st.setDate(1, dataBanco(f.getDataSaida()));
				st.setDate(2, dataBanco(f.getDataRetorno()));
				st.setString(3, f.getObservacao());
				st.setInt(4, f.getRecebimento().getNotaFiscal());
							st.executeUpdate();
				con.close();
			} catch (ClassNotFoundException e){
				e.printStackTrace();
			}catch (SQLException e) {
				e.printStackTrace();
			}

		}

		public void remover(Entrega f) {
			try {
				Connection con = DatabaseConnection.getConnection();
				String sql = "DELETE FROM tb_cliente WHERE nfrecebimento = ? and cnpjreceb = ?";
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, f.getRecebimento().getNotaFiscal());
				st.executeUpdate();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		}

		public List<Entrega> listar() {

			List<Entrega> lista = new ArrayList<Entrega>();
			try {
				Connection con = DatabaseConnection.getConnection();

				StringBuffer sb = new StringBuffer();
				sb.append("SELECT dataSaida, dataRetorno, observacao, nfrecebimento, cnpjrecebimento");
				sb.append("FROM tb_entrega");
				PreparedStatement st = con.prepareStatement(sb.toString());

				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					Entrega f = new Entrega();
					f.setDataRetorno((rs.getDate("datasaida")));
					f.setDataSaida(rs.getDate("staretorno"));
					f.setObservacao(rs.getString("observacao"));
					f.setRecebimento(new DaoRecebimento().buscarRecebimento(rs.getInt("nfrecebimento"), rs.getString("nfcnpj")));
					
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

		private java.sql.Date dataBanco(Date data) {
			try {
				return new java.sql.Date(data.getTime());
			} catch (Exception e) {
				return null;
			}
		}
	}

