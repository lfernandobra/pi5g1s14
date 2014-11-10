package edu.gaed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.gaed.vo.Aluno;
import edu.gaed.vo.Data;

public class AlunoDao extends BaseDao{
	
	public boolean insereAluno(Aluno aluno,String senha)
	{
		Connection conn = null;
		
		try
		{
			conn = getConnection();
			String sql = "insert into usuario (Login,Senha,Nome,Sobrenome,Sexo,Data_Nascimento,Perfil_Usuario,Email,Rua,Numero,Bairro,Cidade,Estado,CEP,Telefone) values (?,SHA1(?), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, aluno.getLogin());
			stmt.setString(2, senha);
			stmt.setString(3, aluno.getNome());
			stmt.setString(4, aluno.getSobrenome());
			stmt.setString(5, aluno.getSexo());
			stmt.setDate(6, new Data().formata(aluno.getDatanasc()));
			stmt.setInt(7, 5);
			stmt.setString(8, aluno.getEmail());
			stmt.setString(9, aluno.getRua());
			stmt.setString(10, aluno.getNumero());
			stmt.setString(11, aluno.getBairro());
			stmt.setString(12, aluno.getCidade());
			stmt.setString(13, aluno.getEstado());
			stmt.setString(14, aluno.getCEP());
			stmt.setString(15, aluno.getTelefone());
			
			int id = stmt.executeUpdate();
			
			aluno.setId(id);
			
			//Obter quantidade de usuarios cadastrados no sistema
			
			String sqlCount = "SELECT COUNT(*) as Quantidade_Usuarios FROM usuario u ";
			
			PreparedStatement stmt2 = conn.prepareStatement(sqlCount);
			
			ResultSet resultado = stmt2.executeQuery();
			
			int qtyUsuario = 0;
			
			if (resultado.next()) {
				qtyUsuario = resultado.getInt("Quantidade_Usuarios"); 
			}
			
			//Insere usuario á tabela de responsaveis com o numero da ultimo usuario inserido
			
			String sqlaluno = "insert into aluno (ID_Usuario) values (?);";
			PreparedStatement stmt3 = conn.prepareStatement(sqlaluno);
			
			stmt3.setInt(1, qtyUsuario);
						
			int idAluno = stmt3.executeUpdate();
			aluno.setID(idAluno);
			
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

}
