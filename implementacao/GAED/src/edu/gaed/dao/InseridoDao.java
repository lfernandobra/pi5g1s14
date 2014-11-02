package edu.gaed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.gaed.vo.Boletim;
import edu.gaed.vo.Inserido;
import edu.gaed.vo.Aluno;

public class InseridoDao extends BaseDao{
	public List<Inserido> obterComposicao(List<Boletim> boletins) {
		
		List<Inserido> inseridos = new ArrayList<Inserido>();
		Connection conn = null;
		
		//
		for(int i=0;i<boletins.size();i++){
			
			
			try {
				conn = this.getConnection();
				
				String sql = "select i.ID_Boletim,a.ID_Aluno,u.Nome,u.Sobrenome from inserido i,boletim b,aluno a,usuario u where i.ID_Aluno = a.ID_Aluno and a.ID_Usuario = u.ID_Usuario and i.ID_Boletim = b.ID_Boletim and b.ID_Boletim =?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				
				stmt.setInt(1, boletins.get(i).getID());
						
				ResultSet resultado = stmt.executeQuery();
				
				while (resultado.next()) {
					Boletim boletim = new Boletim();
					boletim.setID(resultado.getInt("ID_Boletim"));
					
					Aluno aluno = new Aluno();
					aluno.setID(resultado.getInt("ID_Aluno"));
					aluno.setNome(resultado.getString("Nome"));
					aluno.setSobrenome(resultado.getString("Sobrenome"));
					
					Inserido inserido = new Inserido();
					inserido.setAluno(aluno);
					inserido.setBoletim(boletim);
					
					inseridos.add(inserido);
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
		
		return inseridos;
	}
}
