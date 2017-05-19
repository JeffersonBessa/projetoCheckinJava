package br.unipe.checkin.model.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.unipe.checkin.model.entidades.Usuario;
import br.unipe.checkin.util.Conexao;

public class UsuarioDAO {
	
	private static final String SQL_VERIFICAR_LOGIN = 
			"SELECT * FROM usuario WHERE username = ? and password = ?";
	
	private static final String SQL_CONSULTAR_USUARIO = 
			"SELECT * FROM usuario WHERE username = ?";
	
	private static final String SQL_CADASTRAR_USUARIO = 
			"INSERT INTO usuario (`nome`, `username`, `password`) VALUES (?, ?, ?);";

	public Usuario verificarLogin(Usuario usuario) {
		
		Usuario usuarioRetorno = null;
		
		PreparedStatement statement = null;
		try {
			statement = Conexao.getConexao().prepareStatement(SQL_VERIFICAR_LOGIN);
			statement.setString(1, usuario.getUsername());
			statement.setString(2, usuario.getPassword());
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()){
				
				usuarioRetorno = new Usuario();
				usuarioRetorno.setId(resultSet.getInt("idUsuario"));
				usuarioRetorno.setUsername(resultSet.getString("username"));
				usuarioRetorno.setNome(resultSet.getString("nome"));
				
			}// if
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}// try-catch
			Conexao.fecharConexao();
		}// try-catch-finally
		
		return usuarioRetorno;
	}// verificarLogin()
	
	public boolean cadastrarUsuario(Usuario usuario) {
		
		boolean retorno = false;
		
		PreparedStatement statement = null;
		try {
			
			statement = Conexao.getConexao().prepareStatement(SQL_CONSULTAR_USUARIO);
			statement.setString(1, usuario.getUsername());
			
			ResultSet resultSet = statement.executeQuery();
			
			if(!resultSet.next()){
				
				statement.close();
				
				statement = Conexao.getConexao().prepareStatement(SQL_CADASTRAR_USUARIO);
				
				statement.setString(1, usuario.getNome());
				statement.setString(2, usuario.getUsername());
				statement.setString(3, usuario.getPassword());
				
				if(statement.executeUpdate() == 1)
					retorno = true;
			}// if
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}// try-catch
			Conexao.fecharConexao();
		}// try-catch-finally
		
		return retorno;
	}// cadastrarUsuario()

}
