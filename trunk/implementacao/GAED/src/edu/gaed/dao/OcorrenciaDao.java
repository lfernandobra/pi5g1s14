package edu.gaed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.gaed.vo.Aluno;
import edu.gaed.vo.Data;
import edu.gaed.vo.Ocorrencia;
import edu.gaed.vo.Recebe;


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
			
			System.out.println("Quantidades de ocorrencias no banco"+qtyOcorrencia);
			
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
	
	public List<Recebe> obterOcorrenciasAluno() {
		
		List<Recebe> ocorrencias = new ArrayList<Recebe>();
		Connection conn = null;
		
		try {
			conn = this.getConnection();
			
			String sql = "select o.ID_Ocorrencia,o.Assunto_Ocorrencia,o.Descricao_Ocorrencia,o.Data_Ocorrencia,a.ID_Aluno,u.Nome,u.Sobrenome,t.Nome_Turma from usuario u,aluno a,turma t,recebe r,ocorrencia o,estuda e where u.ID_Usuario = a.ID_Usuario and a.ID_Aluno = e.ID_Aluno and e.ID_Turma = t.ID_Turma and a.ID_Aluno = r.ID_Aluno and r.ID_Ocorrencia = o.ID_Ocorrencia order by o.ID_Ocorrencia;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				
				Recebe recebe = new Recebe();
				
				Ocorrencia ocorrencia = new Ocorrencia();
								
				ocorrencia.setID(resultado.getInt("ID_Ocorrencia"));
				ocorrencia.setAssunto(resultado.getString("Assunto_Ocorrencia"));
				ocorrencia.setDescricao(resultado.getString("Descricao_Ocorrencia"));
				ocorrencia.setData(resultado.getString("Data_Ocorrencia"));
				
				Aluno aluno = new Aluno();
				aluno.setID(resultado.getInt("ID_Aluno"));
				aluno.setNome(resultado.getString("Nome"));
				aluno.setSobrenome(resultado.getString("Sobrenome"));
				
				recebe.setOcorrencia(ocorrencia);
				recebe.setAluno(aluno);
				
				ocorrencias.add(recebe);
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
		
		return ocorrencias;
	}
	
	public List<Recebe> obterOcorrenciasAluno(int ID_Aluno) {
		
		List<Recebe> ocorrencias = new ArrayList<Recebe>();
		Connection conn = null;
		
		try {
			conn = this.getConnection();
			
			String sql = "select o.ID_Ocorrencia,o.Assunto_Ocorrencia,o.Descricao_Ocorrencia,o.Data_Ocorrencia,"
					+ "a.ID_Aluno,u.Nome,u.Sobrenome from usuario u,aluno a,recebe r,ocorrencia o where u.ID_Usuario = a.ID_Usuario "
					+ "and a.ID_Aluno = r.ID_Aluno and r.ID_Ocorrencia = o.ID_Ocorrencia and a.ID_Aluno = ? order by o.ID_Ocorrencia";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ID_Aluno);
			
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				
				Recebe recebe = new Recebe();
				
				Ocorrencia ocorrencia = new Ocorrencia();
								
				ocorrencia.setID(resultado.getInt("ID_Ocorrencia"));
				ocorrencia.setAssunto(resultado.getString("Assunto_Ocorrencia"));
				ocorrencia.setDescricao(resultado.getString("Descricao_Ocorrencia"));
				ocorrencia.setData(resultado.getString("Data_Ocorrencia"));
				
				Aluno aluno = new Aluno();
				aluno.setID(resultado.getInt("ID_Aluno"));
				aluno.setNome(resultado.getString("Nome"));
				aluno.setSobrenome(resultado.getString("Sobrenome"));
				
				recebe.setOcorrencia(ocorrencia);
				recebe.setAluno(aluno);
				
				ocorrencias.add(recebe);
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
		
		return ocorrencias;
	}
	
	public Ocorrencia obterOcorrencia(int idAluno,int idOcorrencia)
	{
		Ocorrencia ocorrencia = new Ocorrencia();
		Connection conn = null;
		
		try
		{
			conn = getConnection();
			
			String sql = "select u.Nome,t.Nome_Turma,o.ID_Ocorrencia,o.Assunto_Ocorrencia,o.Descricao_Ocorrencia,o.Data_Ocorrencia from usuario u,aluno a,turma t,recebe r,ocorrencia o,estuda e where u.ID_Usuario = a.ID_Usuario and a.ID_Aluno = e.ID_Aluno and e.ID_Turma = t.ID_Turma and a.ID_Aluno = r.ID_Aluno and r.ID_Ocorrencia = o.ID_Ocorrencia and a.ID_Aluno = ? and o.ID_Ocorrencia = ?;";	
			
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idAluno);
			stmt.setInt(2, idOcorrencia);
			
			
			ResultSet resultSet = stmt.executeQuery();			
			if (resultSet.next())
			{
				ocorrencia.setID(resultSet.getInt("ID_Ocorrencia"));
				ocorrencia.setAssunto(resultSet.getString("Assunto_Ocorrencia"));
				ocorrencia.setDescricao(resultSet.getString("Descricao_Ocorrencia"));
				ocorrencia.setData(resultSet.getString("Data_Ocorrencia"));		
			}
			
			return ocorrencia;
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

	public boolean atualizaOcorrencia(Ocorrencia ocorrencia) {
		Connection conn = null;
		System.out.println(ocorrencia.getID());
		System.out.println(ocorrencia.getAssunto());
		try {
			conn = this.getConnection();
			
			String sql = "update ocorrencia set Assunto_Ocorrencia = ?, Descricao_Ocorrencia = ? , Data_Ocorrencia = ? where ID_Ocorrencia = ?";			
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, ocorrencia.getAssunto());
			stmt.setString(2, ocorrencia.getDescricao());
			stmt.setString(3, ocorrencia.getData());
			stmt.setInt(4, ocorrencia.getID());
						
			int id = stmt.executeUpdate();
						
			return id > 0;
		}
		catch (SQLException e) {
			return false;
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

}
