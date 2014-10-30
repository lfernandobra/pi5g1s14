package edu.gaed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.gaed.modelo.Aluno;
import edu.gaed.modelo.Boletim;
import edu.gaed.modelo.Compoe;
import edu.gaed.modelo.Disciplina;
import edu.gaed.modelo.Turma;


public class BoletimDao extends BaseDao{
	
	public List<Boletim> obterBoletimProfessor(int ID_Professor) {
		
		List<Boletim> boletimTurma = new ArrayList<Boletim>();
		Connection conn = null;
		
		try {
			conn = this.getConnection();
			
			String sql = "select u.nome,a.ID_Aluno,t.Serie,t.Nome_Turma,p.ID_Professor,d.ID_Disciplina,d.nome_disciplina,b.ID_Boletim,t.Bimestre,c.nota,c.faltas from usuario u,turma t,disciplina d,boletim b,compoe c,aluno a ,estuda e,inserido i,professor p , ministra m where u.ID_Usuario = a.ID_Usuario and a.ID_Aluno = e.ID_Aluno and e.ID_Turma = t.ID_Turma and b.ID_Boletim = c.ID_Boletim and c.ID_Disciplina = d.ID_Disciplina and d.ID_Disciplina = m.ID_Disciplina and m.ID_Professor = p.ID_Professor and b.ID_Boletim = i.ID_Boletim and i.ID_Aluno = a.ID_Aluno and p.ID_Professor = ? order by u.Nome,d.Nome_Disciplina";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, ID_Professor);
			
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				
				Boletim bolAluno = new Boletim();
				bolAluno.setBimestre(resultado.getInt("Bimestre"));
				System.out.println(resultado.getInt("Bimestre"));
				bolAluno.setID(resultado.getInt("ID_Boletim"));
				
				Aluno aluno = new Aluno();
				aluno.setID(resultado.getInt("ID_Aluno"));
				aluno.setNome(resultado.getString("nome"));
				
				bolAluno.setAluno(aluno);
				
				Turma turma = new Turma();
				turma.setNome(resultado.getString("Nome_Turma"));
				turma.setSerie(resultado.getInt("Serie"));
				
				bolAluno.setTurma(turma);
														
				Disciplina disciplina = new Disciplina();
				disciplina.setID(resultado.getInt("ID_Disciplina"));
				disciplina.setNome(resultado.getString("nome_disciplina"));
				
				Compoe compoe = new Compoe();
				
				compoe.setDisciplina(disciplina);
				compoe.setFaltas(resultado.getInt("faltas"));
				compoe.setNota(resultado.getFloat("nota"));
				
				bolAluno.setCompoe(compoe);
								
				boletimTurma.add(bolAluno);
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
		return boletimTurma;
	}
	
	public Boletim obterBoletim(int ID_Aluno,int ID_Boletim,int ID_Disciplina){
		Boletim bolAluno = new Boletim();
		Connection conn = null;
		
		try
		{
			conn = getConnection();
			
			String sql = "select u.nome,a.ID_Aluno,t.Nome_Turma,t.Serie,d.ID_Disciplina,d.nome_disciplina,b.bimestre,b.ID_Boletim,c.nota,c.faltas from usuario u,turma t,disciplina d,boletim b,compoe c,aluno a ,estuda e,inserido i where u.ID_Usuario = a.ID_Usuario and a.ID_Aluno = e.ID_Aluno and e.ID_Turma = t.ID_Turma and b.ID_Boletim = c.ID_Boletim and c.ID_Disciplina = d.ID_Disciplina and b.ID_Boletim = i.ID_Boletim and i.ID_Aluno = a.ID_Aluno and a.ID_Aluno = ? and b.ID_Boletim = ? and c.ID_Disciplina = ?";			
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ID_Aluno);
			stmt.setInt(2, ID_Boletim);
			stmt.setInt(3, ID_Disciplina);
			
			ResultSet resultado = stmt.executeQuery();			
			if (resultado.next())
			{
				
				bolAluno.setBimestre(resultado.getInt("bimestre"));
				bolAluno.setID(resultado.getInt("ID_Boletim"));
				
				Aluno aluno = new Aluno();
				aluno.setID(resultado.getInt("ID_Aluno"));
				aluno.setNome(resultado.getString("nome"));
				
				bolAluno.setAluno(aluno);
				
				Turma turma = new Turma();
				turma.setNome(resultado.getString("Nome_Turma"));
				turma.setSerie(resultado.getInt("Serie"));
				
				bolAluno.setTurma(turma);
														
				Disciplina disciplina = new Disciplina();
				disciplina.setID(resultado.getInt("ID_Disciplina"));
				disciplina.setNome(resultado.getString("nome_disciplina"));
				
				Compoe compoe = new Compoe();
				
				compoe.setDisciplina(disciplina);
				compoe.setFaltas(resultado.getInt("faltas"));
				compoe.setNota(resultado.getFloat("nota"));
				
				bolAluno.setCompoe(compoe);
				
			}
			
			return bolAluno;
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
}
