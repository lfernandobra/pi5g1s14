package edu.gaed.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import edu.gaed.modelo.PerfilUsuario;
import edu.gaed.modelo.Usuario;

public class UsuarioDao extends BaseDao{
	//Obter usuario para login
	public Usuario obterUsuario(String login, String senha) {
		Usuario usuario = null;
		Connection conn = null;
		
		try {
			conn = this.getConnection();
			
			String sql = "SELECT u.ID_usuario,u.Login,u.Nome,u.Perfil_Usuario FROM usuario u where u.Login=? AND u.Senha=SHA1(?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, login);
			stmt.setString(2, senha);
			
			ResultSet resultado = stmt.executeQuery();
			
			System.out.println(resultado);
			
			if (resultado.next()) {
				
				usuario = new Usuario();
				usuario.setId(resultado.getInt("ID_Usuario"));				
				usuario.setLogin(resultado.getString("Login"));
				usuario.setNome(resultado.getString("Nome"));
				short perfil = resultado.getShort("perfil_usuario");
		        usuario.setPerfil(PerfilUsuario.fromValue(perfil));
		        
		        System.out.println(usuario.getId());
				
		        return usuario;
			}
			else{
				return null;
			}
			
		}
		catch (SQLException e) {
			return null;
		}
		finally {
			try {
				if (conn != null) {
					conn.close();
				}				
			}
			catch (Exception e) {
				//do nothing
			}
		}
	}
	
	public boolean insereUsuario(Usuario usuario,String senha)
	{
		Connection conn = null;
		
		try
		{
			conn = getConnection();
			
			String sql = "insert into usuario (Login, Senha, Nome, Sobrenome, Sexo) values (?, ?, ?, ?, ?);"; 
					
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, senha); 
			stmt.setString(3, usuario.getNome());
			stmt.setString(4, usuario.getSobrenome());
			stmt.setString(5, usuario.getSexo());
						
			int id = stmt.executeUpdate();
			
			usuario.setId(id);
			
			return id > 0;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		finally
		{
			if (conn != null)
			{
				try
				{
					conn.close();
				}
				catch(Exception closeEx)
				{
					//do nothing
				}
			}
		}		
	}
		
	public Usuario obterUsuario(int codUsuario)
	{
		Usuario usuario = new Usuario();
		Connection conn = null;
		
		try
		{
			conn = getConnection();
			
			String sql = "select ID_Usuario, Login, Senha from usuario where ID_Usuario = ?;";	
			
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, codUsuario);
			
			ResultSet resultSet = stmt.executeQuery();			
			if (resultSet.next())
			{
				usuario.setId(resultSet.getInt("ID_Usuario"));
				usuario.setLogin(resultSet.getString("Login"));
				//usuario.setSenha(resultSet.getString("Senha"));				
			}
			
			return usuario;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		finally
		{
			if (conn != null)
			{
				try
				{
					conn.close();
				}
				catch(Exception closeEx)
				{
					//do nothing
				}
			}
		}
	}
	
	
	public List<Usuario> obterUsuarios() {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conn = null;
		
		try {
			conn = this.getConnection();
			
			String sql = "select * from usuario";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setId(resultado.getInt("ID_Usuario"));
				usuario.setLogin(resultado.getString("Login"));
				usuario.setNome(resultado.getString("Nome"));
				usuario.setSobrenome(resultado.getString("Sobrenome"));
				usuario.setSexo(resultado.getString("Sexo"));
				//usuario.setDatanasc(resultado.getDate("Data_Nascimento"));
								
				usuarios.add(usuario);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (conn != null) {
					conn.close();
				}				
			}
			catch (Exception e) {
				//do nothing
			}
		}
		
		return usuarios;
	}
}