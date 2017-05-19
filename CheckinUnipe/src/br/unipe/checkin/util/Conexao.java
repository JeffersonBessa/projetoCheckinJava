package br.unipe.checkin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
private static final String URL = "jdbc:mysql://localhost/checkinunipe?user=root&password=";
	
	public static Connection getConexao(){
		
		Connection conx = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conx = DriverManager.getConnection(URL);
			
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}// try-catch
		
		return conx;
		
	}// getConexao()
	
	public static boolean fecharConexao() { 
		try {
			Conexao.getConexao().close(); 
			return true;
			
		} catch (SQLException e) {
			return false; 
		}// try-catch

	}// fecharConexao

}
