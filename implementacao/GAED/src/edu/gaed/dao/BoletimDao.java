package edu.gaed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.gaed.vo.Aluno;
import edu.gaed.vo.Boletim;
import edu.gaed.vo.Compoe;
import edu.gaed.vo.Disciplina;
import edu.gaed.vo.Inserido;


public class BoletimDao extends BaseDao{
	
	public boolean atualizaBoletim(Compoe compoe) {
		Connection conn = null;
		
		try {
			conn = this.getConnection();
			
			String sql = "update compoe set nota = ?, faltas = ? where ID_Boletim = ? and ID_Disciplina = ?";			
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setFloat(1, compoe.getNota());
			stmt.setInt(2, compoe.getFaltas());
			stmt.setInt(3, compoe.getBoletim().getID());
			stmt.setInt(4, compoe.getDisciplina().getID());
			
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
	
	public Compoe obterBoletim(int ID_Aluno,int ID_Boletim,int ID_Disciplina){
		Compoe compoe = new Compoe();
		Connection conn = null;
		
		try
		{
			conn = getConnection();
			
			String sql = "select u.nome,a.ID_Aluno,t.Nome_Turma,t.Serie,d.ID_Disciplina,d.nome_disciplina,b.bimestre,b.ID_Boletim,c.nota,c.faltas from usuario u,turma t,disciplina d,boletim b,compoe c,aluno a ,estuda e,inserido i where u.ID_Usuario = a.ID_Usuario and a.ID_Aluno = e.ID_Aluno and e.ID_Turma = t.ID_Turma and b.ID_Boletim = c.ID_Boletim and c.ID_Disciplina = d.ID_Disciplina and b.ID_Boletim = i.ID_Boletim and i.ID_Aluno = a.ID_Aluno and a.ID_Aluno = ? and b.ID_Boletim = ? and c.ID_Disciplina = ?";			
			
			System.out.println(ID_Boletim);
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ID_Aluno);
			stmt.setInt(2, ID_Boletim);
			stmt.setInt(3, ID_Disciplina);
			
			ResultSet resultado = stmt.executeQuery();			
			if (resultado.next())
			{
				
				Boletim boletim = new Boletim();
				 
				boletim.setID(resultado.getInt("ID_Boletim"));
														
				Disciplina disciplina = new Disciplina();
				disciplina.setID(resultado.getInt("ID_Disciplina"));
				disciplina.setNome(resultado.getString("nome_disciplina"));
				
				
				compoe.setBoletim(boletim);
				compoe.setDisciplina(disciplina);
				compoe.setFaltas(resultado.getInt("faltas"));
				compoe.setNota(resultado.getFloat("nota"));	
			}
			
			return compoe;
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
	
	public List<Boletim> obterBoletinsTurma(int idTurma, int idDisciplina) {
		
		List<Boletim> boletins = new ArrayList<Boletim>();
		Connection conn = null;
		
		try {
			conn = this.getConnection();
			
			String sql = "select b.ID_Boletim,b.Data_Boletim from Boletim b,Inserido i,Aluno a,Estuda e,Turma t,"+
			"Possui p,Disciplina d,Ministra m where b.ID_Boletim = i.ID_Boletim and i.ID_Aluno = a.ID_Aluno and a.ID_Aluno = e.ID_Aluno and e.ID_Turma = t.ID_Turma and t.ID_Turma = p.ID_Turma and "+
			"p.ID_Professor = m.ID_Professor and m.ID_Disciplina = d.ID_Disciplina and d.ID_Disciplina = ? and t.ID_Turma = ?;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			
			stmt.setInt(1, idDisciplina);
			stmt.setInt(2, idTurma);
			
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				
				Boletim bolAluno = new Boletim();
				
				bolAluno.setID(resultado.getInt("ID_Boletim"));
				bolAluno.setDataBoletim(resultado.getDate("Data_Boletim"));
				
				boletins.add(bolAluno);
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
		return boletins;
	}
	
	public boolean insereBoletim(Inserido inserido)
	{
		Connection conn = null;
		
		try
		{
			conn = getConnection();
					
			String sql1 = "insert into boletim (Bimestre) values (?);";
			
			PreparedStatement stmt1 = conn.prepareStatement(sql1);
			
			stmt1.setInt(1, inserido.getBoletim().getBimestre());
			
			//ResultSet resultado1 = stmt1.executeQuery();
			
			int id = stmt1.executeUpdate();
			
			//Obter quantidade de boletins cadastrados no sistema
			
			String sqlCount = "SELECT COUNT(*) as Quantidade_Boletins FROM boletim u ";
			
			PreparedStatement stmt2 = conn.prepareStatement(sqlCount);
			
			ResultSet resultado2 = stmt2.executeQuery();
			
			int qtyBoletim = 0;
			
			if (resultado2.next()) {
				qtyBoletim = resultado2.getInt("Quantidade_Boletins"); 
			}
			
			String sql3 = "insert into inserido (ID_Boletim,ID_Aluno) values (?,?);";
			
			PreparedStatement stmt3 = conn.prepareStatement(sql3);
			
			stmt3.setInt(1, qtyBoletim);
			stmt3.setInt(2, inserido.getAluno().getID());
					
			id = stmt3.executeUpdate();
			//
			String sql4 = "select d.ID_Disciplina,d.Nome_disciplina from Aluno a,Estuda e,Turma t,Possui p,Professor pf,"
					+ "Ministra m,Disciplina d where a.ID_Aluno = e.ID_Aluno and e.ID_Turma = t.ID_Turma and "
					+ "t.ID_Turma = p.ID_Turma and p.ID_Professor = pf.ID_Professor "
					+ "and pf.ID_Professor = m.ID_Professor and m.ID_Disciplina = d.ID_Disciplina and a.ID_Aluno = ?;";
			
			PreparedStatement stmt4 = conn.prepareStatement(sql4);
			
			stmt4.setInt(1, inserido.getAluno().getID());
			
			ResultSet resultado4 = stmt4.executeQuery();
			
			while (resultado4.next())
			{
				String sql5 = "insert into compoe (ID_Boletim,ID_Disciplina) values (?,?);";
				PreparedStatement stmt5 = conn.prepareStatement(sql5);
				
				stmt5.setInt(1, qtyBoletim);
				stmt5.setInt(2, resultado4.getInt("ID_Disciplina"));
				
				id = stmt5.executeUpdate();
				
			}
			
			
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
	
	public List<Inserido> obterBoletinsInseridos() {
		
		List<Inserido> boletinsInseridos = new ArrayList<Inserido>();
		Connection conn = null;
		
		try {
			conn = this.getConnection();
			
			String sql = "select b.ID_Boletim,b.Data_Boletim,a.ID_Aluno,a.ID_Usuario,u.Nome from Boletim b,Inserido i,Usuario u,Aluno a,Estuda e,Turma t where a.ID_Usuario = u.ID_Usuario and b.ID_Boletim = i.ID_Boletim and i.ID_Aluno = a.ID_Aluno and a.ID_Aluno = e.ID_Aluno and e.ID_Turma = t.ID_Turma order by b.ID_Boletim;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
						
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				
				Boletim boletim = new Boletim();
				
				boletim.setID(resultado.getInt("ID_Boletim"));
				boletim.setDataBoletim(resultado.getDate("Data_Boletim"));
				
				Aluno aluno = new Aluno();
				aluno.setID(resultado.getInt("ID_Aluno"));
				aluno.setNome(resultado.getString("Nome"));
		
				Inserido inserido = new Inserido();
				inserido.setBoletim(boletim);
				inserido.setAluno(aluno);
				
				boletinsInseridos.add(inserido);
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
		return boletinsInseridos;
	}

	public List<Compoe> obterBoletim(int ID_Aluno, int ID_Bimestre) {
		
		List<Compoe> boletimcompoe = new ArrayList<Compoe>();
		Connection conn = null;
		
		try
		{
			conn = getConnection();
			
			String sql = "select u.nome,a.ID_Aluno,t.Nome_Turma,t.Serie,d.ID_Disciplina,d.nome_disciplina,"
					+ "b.bimestre,b.ID_Boletim,c.nota,c.faltas from usuario u,turma t,disciplina d,boletim b"
					+ ",compoe c,aluno a ,estuda e,inserido i where u.ID_Usuario = a.ID_Usuario and "
					+ "a.ID_Aluno = e.ID_Aluno and e.ID_Turma = t.ID_Turma and b.ID_Boletim = c.ID_Boletim "
					+ "and c.ID_Disciplina = d.ID_Disciplina and b.ID_Boletim = i.ID_Boletim and i.ID_Aluno = a.ID_Aluno "
					+ "and a.ID_Aluno = ? and b.Bimestre = ?";			
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ID_Aluno);
			stmt.setInt(2, ID_Bimestre);
			
			ResultSet resultado = stmt.executeQuery();			
			
			while (resultado.next()) {
				
				Boletim boletim = new Boletim();
				 
				boletim.setID(resultado.getInt("ID_Boletim"));
														
				Disciplina disciplina = new Disciplina();
				disciplina.setID(resultado.getInt("ID_Disciplina"));
				disciplina.setNome(resultado.getString("nome_disciplina"));
				
				Compoe compoe = new Compoe();
				
				compoe.setBoletim(boletim);
				compoe.setDisciplina(disciplina);
				compoe.setFaltas(resultado.getInt("faltas"));
				compoe.setNota(resultado.getFloat("nota"));
				
				boletimcompoe.add(compoe);
			}
						
			return boletimcompoe;
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
