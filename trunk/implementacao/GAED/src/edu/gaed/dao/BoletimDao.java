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
	/*
	public List<BoletimTurma> obterBoletimTurma(int ID_Turma,int serie) {
		
		List<BoletimTurma> boletimTurma = new ArrayList<BoletimTurma>();
		Connection conn = null;
		
		try {
			conn = this.getConnection();
			
			String sql = "select u.nome,t.Serie,t.Nome_Turma,d.ID_Disciplina,d.nome_disciplina,b.ID_Boletim,b.bimestre,c.nota,c.faltas from usuario u,turma t,disciplina d,boletim b,compoe c,aluno a ,estuda e,inserido i where u.ID_Usuario = a.ID_Usuario and a.ID_Aluno = e.ID_Aluno and e.ID_Turma = t.ID_Turma and b.ID_Boletim = c.ID_Boletim and c.ID_Disciplina = d.ID_Disciplina and b.ID_Boletim = i.ID_Boletim and i.ID_Aluno = a.ID_Aluno and e.ID_Turma = ? and b.Bimestre = ? order by u.Nome,d.Nome_Disciplina";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, ID_Turma);
			stmt.setInt(2, serie);
			
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				
				BoletimTurma bolAluno = new BoletimTurma();
				bolAluno.setNomealuno(resultado.getString("nome"));
				bolAluno.setNomedisciplina(resultado.getString("nome_disciplina"));
				bolAluno.setBimestre(resultado.getInt("ID_Boletim"));
				bolAluno.setSerie(resultado.getInt("Serie"));
				bolAluno.setNometurma(resultado.getString("Nome_Turma"));
				bolAluno.setNota(resultado.getFloat("nota"));
				bolAluno.setFaltas(resultado.getInt("faltas"));
								
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
		
		System.out.println(boletimTurma);
		
		return boletimTurma;
	}*/
	
public List<Boletim> obterBoletimTurma(int ID_Turma,int serie) {
		
		List<Boletim> boletimTurma = new ArrayList<Boletim>();
		Connection conn = null;
		
		try {
			conn = this.getConnection();
			
			String sql = "select u.nome,t.Serie,t.Nome_Turma,d.ID_Disciplina,d.nome_disciplina,b.ID_Boletim,b.bimestre,c.nota,c.faltas from usuario u,turma t,disciplina d,boletim b,compoe c,aluno a ,estuda e,inserido i where u.ID_Usuario = a.ID_Usuario and a.ID_Aluno = e.ID_Aluno and e.ID_Turma = t.ID_Turma and b.ID_Boletim = c.ID_Boletim and c.ID_Disciplina = d.ID_Disciplina and b.ID_Boletim = i.ID_Boletim and i.ID_Aluno = a.ID_Aluno and e.ID_Turma = ? and b.Bimestre = ? order by u.Nome,d.Nome_Disciplina";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, ID_Turma);
			stmt.setInt(2, serie);
			
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				
				Boletim bolAluno = new Boletim();
				bolAluno.setBimestre(resultado.getInt("bimestre"));
				bolAluno.setID(resultado.getInt("ID_Boletim"));
				
				Aluno aluno = new Aluno();
				aluno.setNome(resultado.getString("nome"));
				
				bolAluno.setAluno(aluno);
				
				Turma turma = new Turma();
				turma.setNome(resultado.getString("Nome_Turma"));
				turma.setSerie(resultado.getInt("Serie"));
				
				bolAluno.setTurma(turma);
														
				Disciplina disciplina = new Disciplina();
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
		
		System.out.println(boletimTurma);
		
		return boletimTurma;
	}
}
