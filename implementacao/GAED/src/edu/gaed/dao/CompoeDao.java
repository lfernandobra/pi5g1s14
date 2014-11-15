package edu.gaed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.gaed.vo.Boletim;
import edu.gaed.vo.Compoe;
import edu.gaed.vo.Disciplina;

public class CompoeDao extends BaseDao{
	
	public List<Compoe> obterComposicao(List<Boletim> boletins) {
		
		List<Compoe> composicao = new ArrayList<Compoe>();
		Connection conn = null;
		
		//
		for(int i=0;i<boletins.size();i++){
			
			
			try {
				conn = this.getConnection();
				
				String sql = "select c.ID_Boletim,b.Bimestre,c.ID_Disciplina,d.Nome_Disciplina,c.Nota,c.Faltas from Compoe c,Boletim b ,Disciplina d where b.ID_Boletim = c.ID_Boletim and c.ID_Disciplina = d.ID_Disciplina and b.ID_Boletim =?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				
				stmt.setInt(1, boletins.get(i).getID());
						
				ResultSet resultado = stmt.executeQuery();
				
				while (resultado.next()) {
					Boletim boletim = new Boletim();
					boletim.setID(resultado.getInt("ID_Boletim"));
					boletim.setBimestre(resultado.getInt("Bimestre"));
					
					Disciplina disciplina = new Disciplina();
					disciplina.setID(resultado.getInt("ID_Disciplina"));
					disciplina.setNome(resultado.getString("Nome_Disciplina"));
					
					Compoe compoe = new Compoe();
					compoe.setBoletim(boletim);
					compoe.setNota(resultado.getFloat("Nota"));
					compoe.setFaltas(resultado.getInt("Faltas"));
					compoe.setDisciplina(disciplina);					
					composicao.add(compoe);
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
			
		}
		
		return composicao;
	}
	
	public List<Compoe> obterComposicao(int idBoletim) {
		Connection conn = null;
		List<Compoe> composicao = new ArrayList<Compoe>();
		
		try {
			conn = this.getConnection();
			
			String sql = "select c.ID_Boletim,b.Bimestre,c.ID_Disciplina,d.Nome_Disciplina,c.Nota,c.Faltas from Compoe c,Boletim b ,Disciplina d where b.ID_Boletim = c.ID_Boletim and c.ID_Disciplina = d.ID_Disciplina and b.ID_Boletim =?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, idBoletim);
					
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				Boletim boletim = new Boletim();
				boletim.setID(resultado.getInt("ID_Boletim"));
				boletim.setBimestre(resultado.getInt("Bimestre"));
				
				Disciplina disciplina = new Disciplina();
				disciplina.setID(resultado.getInt("ID_Disciplina"));
				disciplina.setNome(resultado.getString("Nome_Disciplina"));
				
				Compoe compoe = new Compoe();
				compoe.setBoletim(boletim);
				compoe.setNota(resultado.getFloat("Nota"));
				compoe.setFaltas(resultado.getInt("Faltas"));
				compoe.setDisciplina(disciplina);					
				
				composicao.add(compoe);
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
	
		return composicao;
	}
}
