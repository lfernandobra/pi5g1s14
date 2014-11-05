package edu.gaed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.gaed.vo.Professor;

public class ProfessorDao extends BaseDao{
	
	public Professor obterProfessor(int codUsuario)
	{
		Professor professor = new Professor();
		Connection conn = null;
		
		try
		{
			conn = getConnection();
			
			String sql = "select u.ID_Usuario,u.Nome,u.Sobrenome,p.ID_Professor,p.Data_Admissao from usuario u,professor p where u.ID_Usuario = p.ID_Usuario and p.ID_Usuario = ?";	
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, codUsuario);
			
			ResultSet resultSet = stmt.executeQuery();			
			
			if (resultSet.next())
			{
				professor.setId(resultSet.getInt("ID_Usuario"));
				professor.setIdProfessor(resultSet.getInt("ID_Professor"));
				professor.setNome(resultSet.getString("Nome"));
				professor.setSobrenome(resultSet.getString("Sobrenome"));
				professor.setData(resultSet.getDate("Data_Admissao"));
							
			}
			
			return professor;
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

}
