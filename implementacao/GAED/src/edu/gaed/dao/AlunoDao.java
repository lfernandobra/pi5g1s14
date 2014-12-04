package edu.gaed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.gaed.vo.Aluno;
import edu.gaed.vo.Data;
import edu.gaed.vo.Estuda;
import edu.gaed.vo.Foto;
import edu.gaed.vo.Turma;


public class AlunoDao extends BaseDao{
	
	public boolean insereAluno(Aluno aluno,String senha)
	{
		Connection conn = null;
		
		try
		{
			conn = getConnection();
			String sql = "insert into usuario (Login,Senha,Nome,Sobrenome,Sexo,Data_Nascimento,Perfil_Usuario,Email,Rua,Numero,Bairro,Cidade,Estado,CEP,Telefone) values (?,SHA1(?), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, aluno.getLogin());
			stmt.setString(2, senha);
			stmt.setString(3, aluno.getNome());
			stmt.setString(4, aluno.getSobrenome());
			stmt.setString(5, aluno.getSexo());
			stmt.setDate(6, new Data().formata(aluno.getDatanasc()));
			stmt.setInt(7, 5);
			stmt.setString(8, aluno.getEmail());
			stmt.setString(9, aluno.getRua());
			stmt.setString(10, aluno.getNumero());
			stmt.setString(11, aluno.getBairro());
			stmt.setString(12, aluno.getCidade());
			stmt.setString(13, aluno.getEstado());
			stmt.setString(14, aluno.getCEP());
			stmt.setString(15, aluno.getTelefone());
			
			int id = stmt.executeUpdate();
			
			aluno.setId(id);
			
			//Obter quantidade de usuarios cadastrados no sistema
			
			String sqlCount = "SELECT COUNT(*) as Quantidade_Usuarios FROM usuario u ";
			
			PreparedStatement stmt2 = conn.prepareStatement(sqlCount);
			
			ResultSet resultado = stmt2.executeQuery();
			
			int qtyUsuario = 0;
			
			if (resultado.next()) {
				qtyUsuario = resultado.getInt("Quantidade_Usuarios"); 
			}
			
			//Insere usuario á tabela de responsaveis com o numero da ultimo usuario inserido
			
			String sqlaluno = "insert into aluno (ID_Usuario) values (?);";
			PreparedStatement stmt3 = conn.prepareStatement(sqlaluno);
			
			stmt3.setInt(1, qtyUsuario);
						
			int idAluno = stmt3.executeUpdate();
			aluno.setID(idAluno);
			
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
	
	public Aluno obterAluno(int idUsuario){
		Aluno aluno = new Aluno();
		Connection conn = null;
		
		try  {
			conn = getConnection();
		
			String sql = "select u.Nome,u.Sobrenome,a.ID_Aluno from usuario u,aluno a "
					+ "where u.ID_Usuario = a.ID_Usuario and a.ID_Usuario = ?;";	
				
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idUsuario);
		
			ResultSet resultSet = stmt.executeQuery();			
			if (resultSet.next())
			{
				aluno.setID(resultSet.getInt("ID_Aluno"));
				aluno.setNome(resultSet.getString("Nome"));
				aluno.setSobrenome(resultSet.getString("Sobrenome"));
			}
			return aluno;
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
	public List<Estuda> obterAlunos() {
		
		List<Estuda> alunos = new ArrayList<Estuda>();
		Connection conn = null;
		
		try {
			conn = this.getConnection();
			
			String sql = "select a.ID_Aluno,u.Login,u.Nome,u.Sobrenome,u.Sexo,f.cod_foto,f.img_foto,t.ID_Turma,t.Nome_Turma,t.Periodo,"
					+ "t.Serie,t.Ano_Letivo,t.Bimestre from usuario u,aluno a,foto f,estuda e,turma t where "
					+ "u.ID_Usuario = a.ID_Usuario and a.ID_Aluno = e.ID_Aluno and e.ID_Turma = t.ID_Turma and "
					+ "u.Foto = f.cod_foto group by a.ID_Aluno";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				Foto foto = new Foto();
				foto.setId(resultado.getInt("cod_foto"));
				foto.setImagem(resultado.getBytes("img_foto"));
				
				Aluno aluno = new Aluno();
				
				aluno.setID(resultado.getInt("ID_Aluno"));
				aluno.setNome(resultado.getString("Nome"));
				aluno.setSobrenome(resultado.getString("Sobrenome"));
				aluno.setSexo(resultado.getString("Sexo"));
				aluno.setFoto(foto);
				
				Turma turma = new Turma();
				
				turma.setID(resultado.getInt("ID_Turma"));
				turma.setNome(resultado.getString("Nome_Turma"));
				turma.setPeriodo(resultado.getString("Periodo"));
				turma.setSerie(resultado.getInt("Serie"));
				turma.setAno(resultado.getInt("Ano_Letivo"));
				turma.setBimestre(resultado.getInt("Bimestre"));
				
				Estuda estuda = new Estuda();
				estuda.setAluno(aluno);
				estuda.setTurma(turma);
								
				alunos.add(estuda);
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
		
		return alunos;
	}

}
