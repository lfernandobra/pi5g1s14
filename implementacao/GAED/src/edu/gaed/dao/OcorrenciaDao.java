package edu.gaed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.gaed.vo.Data;
import edu.gaed.vo.Ocorrencia;


public class OcorrenciaDao extends BaseDao{
	
	public boolean insereOcorrencia(int idAluno,Ocorrencia ocorrencia)
	{
		Connection conn = null;
		
		try
		{
			conn = getConnection();
			String sql = "insert into Ocorrencia (Assunto_Ocorrencia,Descricao_Ocorrencia,Data_Ocorrencia) values (?,?,?);";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, ocorrencia.getAssunto());
			stmt.setString(2, ocorrencia.getDescricao());
			stmt.setDate(3, new Data().formata(ocorrencia.getData()));
						
			int id = stmt.executeUpdate();
			
			ocorrencia.setID(id);
			
			//Obter quantidade de usuarios cadastrados no sistema
			
			String sqlCount = "SELECT COUNT(*) as Quantidade_Ocorrencias FROM ocorrencia";
			
			PreparedStatement stmt2 = conn.prepareStatement(sqlCount);
			
			ResultSet resultado = stmt2.executeQuery();
			
			int qtyOcorrencia = 0;
			
			if (resultado.next()) {
				qtyOcorrencia = resultado.getInt("Quantidade_Ocorrencias"); 
			}
			
			//Insere ocorrencia á tabela de "recebe" com o numero da ultima ocorrencia inserida
			
			System.out.println(qtyOcorrencia);
			
			String sqlrecebeOcorrencia = "insert into recebe (ID_Aluno,ID_Ocorrencia) values (?,?);";
			PreparedStatement stmt3 = conn.prepareStatement(sqlrecebeOcorrencia);
			
			stmt3.setInt(1, idAluno);
			stmt3.setInt(2, qtyOcorrencia);
			
			int idOcorrencia = stmt3.executeUpdate();
			ocorrencia.setID(idOcorrencia);
			
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
