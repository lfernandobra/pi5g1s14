package edu.gaed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.gaed.vo.Aluno;
import edu.gaed.vo.Estuda;
import edu.gaed.vo.Inserido;
import edu.gaed.vo.Turma;

public class EstudaDao extends BaseDao{

	public List<Estuda> obterComposicao(List<Inserido> alunosinseridos) {
		
		List<Estuda> estudaturma = new ArrayList<Estuda>();
		Connection conn = null;
		
		//
		for(int i=0;i<alunosinseridos.size();i++){
			
			
			try {
				conn = this.getConnection();
				
				String sql = "select e.ID_Aluno,e.ID_Turma,a.ID_Aluno,t.ID_Turma,t.Nome_Turma,t.Periodo,t.Serie,t.Ano_Letivo,t.Bimestre from estuda e , aluno a , turma t where a.ID_Aluno = e.ID_Aluno and e.ID_Turma = t.ID_Turma and e.ID_Aluno =?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				
				stmt.setInt(1, alunosinseridos.get(i).getAluno().getID());
						
				ResultSet resultado = stmt.executeQuery();
				
				while (resultado.next()) {
					Turma turma = new Turma();
					turma.setID(resultado.getInt("ID_Turma"));
					turma.setNome(resultado.getString("Nome_Turma"));
					turma.setPeriodo(resultado.getString("Periodo"));
					turma.setSerie(resultado.getInt("Serie"));
					turma.setAno(resultado.getInt("Ano_Letivo"));
					turma.setBimestre(resultado.getInt("Bimestre"));
									
					Aluno aluno = new Aluno();
					aluno.setID(resultado.getInt("ID_Aluno"));
					
					
					Estuda estuda = new Estuda();
					estuda.setAluno(aluno);
					estuda.setTurma(turma);
					
					estudaturma.add(estuda);
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
		
		return estudaturma;
	}
	
	public Estuda obterComposicao(int idUsuario){
		
		Estuda estuda = new Estuda();
		Connection conn = null;
		
		try  {
			conn = getConnection();
		
			String sql = "select u.ID_Usuario,e.ID_Turma,t.Nome_Turma,t.Periodo,t.Serie,t.Ano_Letivo,t.Bimestre"
					+ ",a.ID_Aluno from estuda e,turma t,aluno a,usuario u where t.ID_Turma = e.ID_Turma and "
					+ "e.ID_Aluno = a.ID_Aluno and a.ID_Usuario = u.ID_Usuario and a.ID_Usuario = ?;";	
				
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idUsuario);
		
			ResultSet resultSet = stmt.executeQuery();			
			if (resultSet.next())
			{
				Aluno aluno = new Aluno();
				aluno.setID(resultSet.getInt("ID_Aluno"));
				
				Turma turma = new Turma();
				turma.setID(resultSet.getInt("ID_Turma"));
				turma.setNome(resultSet.getString("Nome_Turma"));
				turma.setPeriodo(resultSet.getString("Periodo"));
				turma.setSerie(resultSet.getInt("Serie"));
				turma.setAno(resultSet.getInt("Ano_Letivo"));
				turma.setBimestre(resultSet.getInt("Bimestre"));
				
				estuda.setAluno(aluno);
				estuda.setTurma(turma);
			}
			return estuda;
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
