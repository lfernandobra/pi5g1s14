package edu.gaed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.gaed.vo.Data;
import edu.gaed.vo.Responsavel;

public class ResponsavelDao extends BaseDao{

	public boolean insereResponsavel(Responsavel responsavel,String senha)
	{
		Connection conn = null;
		
		try
		{
			conn = getConnection();
			String sql = "insert into usuario (Login,Senha,Nome,Sobrenome,Sexo,Data_Nascimento,Perfil_Usuario,Email,Rua,Numero,Bairro,Cidade,Estado,CEP,Telefone) values (?,SHA1(?), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, responsavel.getLogin());
			stmt.setString(2, senha);
			stmt.setString(3, responsavel.getNome());
			stmt.setString(4, responsavel.getSobrenome());
			stmt.setString(5, responsavel.getSexo());
			stmt.setDate(6, new Data().formata(responsavel.getDatanasc()));
			stmt.setInt(7, 4);
			stmt.setString(8, responsavel.getEmail());
			stmt.setString(9, responsavel.getRua());
			stmt.setString(10, responsavel.getNumero());
			stmt.setString(11, responsavel.getBairro());
			stmt.setString(12, responsavel.getCidade());
			stmt.setString(13, responsavel.getEstado());
			stmt.setString(14, responsavel.getCEP());
			stmt.setString(15, responsavel.getTelefone());
			
			int id = stmt.executeUpdate();
			
			responsavel.setId(id);
			
			//Obter quantidade de usuarios cadastrados no sistema
			
			String sqlCount = "SELECT COUNT(*) as Quantidade_Usuarios FROM usuario u ";
			
			PreparedStatement stmt2 = conn.prepareStatement(sqlCount);
			
			ResultSet resultado = stmt2.executeQuery();
			
			int qtyUsuario = 0;
			
			if (resultado.next()) {
				qtyUsuario = resultado.getInt("Quantidade_Usuarios"); 
			}
			
			//Insere usuario á tabela de responsaveis com o numero da ultimo usuario inserido
			
			String sqlresponsavel = "insert into responsavel (ID_Usuario,CPF) values (?,?);";
			PreparedStatement stmt3 = conn.prepareStatement(sqlresponsavel);
			
			stmt3.setInt(1, qtyUsuario);
			stmt3.setString(2, responsavel.getCPF());
			
			int idResponsavel = stmt3.executeUpdate();
			responsavel.setID_Responsavel(idResponsavel);
			
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
