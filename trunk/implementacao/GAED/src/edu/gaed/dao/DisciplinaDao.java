package edu.gaed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.gaed.vo.Disciplina;

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
}	
