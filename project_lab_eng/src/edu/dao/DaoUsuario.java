package edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import edu.modelo.Entrega;
import edu.modelo.Usuario;

public class DaoUsuario implements IDaoUsuario {

	public Usuario Pesquisar(String id) {
		Usuario u = new Usuario();

		Connection con;
		try {
			con = DatabaseConnection.getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("Select * from tb_usuario ");
			sb.append("where userid =  ? ;");
			PreparedStatement st = con.prepareStatement(sb.toString());
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				u.setUserid(rs.getString("userid"));
				u.setSenha(rs.getString("senha"));
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;

	}

	public void adicionar(Usuario u) {
		try {
			Connection con = DatabaseConnection.getConnection();
			String sql = "INSERT INTO tb_usuario(userid, senha)" + "VALUES (?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, u.getUserid());
			st.setString(2, u.getSenha());
			st.executeUpdate();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
