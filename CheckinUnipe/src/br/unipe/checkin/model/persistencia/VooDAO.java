package br.unipe.checkin.model.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.unipe.checkin.model.entidades.Voo;
import br.unipe.checkin.util.Conexao;

public class VooDAO {
	
	private static final String SQL_VERIFICAR_ASSENTO = 
			"SELECT * FROM voo WHERE fileira = ? and poltrona = ?";
	
	private static final String SQL_VERIFICAR_OVERBOOKING = 
			"SELECT count(*) as quantidade FROM voo";
	
	private static final String SQL_CADASTRAR_VOO = 
			"INSERT INTO voo (`idUsuario`, `fileira`, `poltrona`) VALUES (?, ?, ?);";

	public boolean verificaAssento(int fileira, String poltrona) {
		
		PreparedStatement statement = null;
		try {
			statement = Conexao.getConexao().prepareStatement(SQL_VERIFICAR_ASSENTO);
			statement.setInt(1, fileira);
			statement.setString(2, poltrona);
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()){
				
				return false;
				
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
		
		return true;
		
	}// verificaAssento()
	
	public boolean cadastrarVoo(Voo voo) {
		
		boolean retorno = false;
		
		PreparedStatement statement = null;
		try {
			
			if(verificaAssento(voo.getFileira(), voo.getPoltrona())){
				
				statement = Conexao.getConexao().prepareStatement(SQL_CADASTRAR_VOO);
				
				statement.setInt(1, voo.getUsuario().getId());
				statement.setInt(2, voo.getFileira());
				statement.setString(3, voo.getPoltrona());
				
				if(statement.executeUpdate() == 1)
					retorno = true;
			}
			
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
	}// cadastrarVoo()
	
	public boolean verificaOverbooking() {
		
		PreparedStatement statement = null;
		int quantidade = 0;
		try {
			statement = Conexao.getConexao().prepareStatement(SQL_VERIFICAR_OVERBOOKING);
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()){
				
				quantidade = resultSet.getInt("quantidade");
				
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
		
		return quantidade == 9;
		
	}// verificaOverbooking()

}
