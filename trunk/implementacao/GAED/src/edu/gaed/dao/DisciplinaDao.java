package edu.gaed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.gaed.vo.Disciplina;
import edu.gaed.vo.Professor;

public class DisciplinaDao extends BaseDao{
	
	public List<Disciplina> obterDisciplinas() {
		
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		Connection conn = null;
		
		try {
			conn = this.getConnection();
			
			String sql = "select d.ID_Disciplina,d.Nome_Disciplina,d.Conteudo_Disciplina from Disciplina d";
			PreparedStatement stmt = conn.prepareStatement(sql);
					
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				
				Disciplina disciplina = new Disciplina();
				
				disciplina.setID(resultado.getInt("ID_Disciplina"));
				disciplina.setNome(resultado.getString("Nome_Disciplina"));
				disciplina.setConteudo(resultado.getString("Conteudo_Disciplina"));
				
				disciplinas.add(disciplina);
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
		return disciplinas;
	}

	public Disciplina obtemDisciplinaProfessor(Professor professor) {
		
		Disciplina disciplina = new Disciplina();
		Connection conn = null;
		
		try {
			conn = this.getConnection();
			
			String sql = "select d.ID_Disciplina,d.Nome_Disciplina,d.Conteudo_Disciplina from Disciplina d,Ministra m,Professor p where d.ID_Disciplina = m.ID_Disciplina and m.ID_Professor = p.ID_Professor and p.ID_Professor = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, professor.getIdProfessor());
			
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				
				disciplina.setID(resultado.getInt("ID_Disciplina"));
				disciplina.setNome(resultado.getString("Nome_Disciplina"));
				disciplina.setConteudo(resultado.getString("Conteudo_Disciplina"));
				
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
		return disciplina;
	}
}	
