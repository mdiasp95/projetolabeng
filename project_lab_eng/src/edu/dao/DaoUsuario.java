package edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.modelo.Entrega;
import edu.modelo.Usuario;

public class DaoUsuario implements IDaoUsuario{

	public Usuario Pesquisar(String id) {
		Usuario u = new Usuario();
		
		Connection con;
		try {
			con = DatabaseConnection.getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("Select * from ");
			sb.append("where userid = ?");
			PreparedStatement st = con.prepareStatement(sb.toString());
			ResultSet rs = st.executeQuery();
			if(rs.equals(null)){
				return null;
			}
			u.setUserid(rs.getString("userid"));
			u.setSenha(rs.getString("senha"));
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
		
		
	
	}

}
