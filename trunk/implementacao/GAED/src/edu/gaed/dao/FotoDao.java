package edu.gaed.dao;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import edu.gaed.albumWeb.exception.PersistenceException;
import edu.gaed.vo.Foto;

public class FotoDao extends BaseDao {
	
	public Foto getFoto(Foto foto) throws PersistenceException {
		Foto retorno = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		InputStream is = null;
		
		try {
			conn = this.getConnection();
			String query = "select * from foto where cod_foto = ?;";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,foto.getId());
			ResultSet resultado = pstmt.executeQuery();
			
			if (resultado.next()) {
				retorno = new Foto();

				retorno.setId(resultado.getInt("cod_foto"));
				retorno.setNome(resultado.getString("nom_foto"));
				retorno.setDescricao(resultado.getString("txt_descricao"));
				
				Blob blob = resultado.getBlob("img_foto");
				
				is = blob.getBinaryStream();
				byte[] imagem = blob.getBytes(1,(int)blob.length());
				retorno.setImagem(imagem);				
			}
			
			return retorno;
		}
		catch (Exception e) {
			throw new PersistenceException();
		}
		finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (is != null) {
					is.close();
				}
			}
			catch (Exception e) {
				//do nothing
			}
		}
	}
	
	public List<Foto> getFotos() throws PersistenceException {
		List<Foto> fotos = new ArrayList<Foto>();
		Connection conn = null;
		
		try {
			conn = this.getConnection();
			Statement statement = conn.createStatement();
			
			String sql = "select cod_foto, nom_foto, txt_descricao from foto";
			ResultSet resultado = statement.executeQuery(sql);
			
			while (resultado.next()) {
				Foto foto = new Foto();
				
				foto.setId(resultado.getInt("cod_foto"));				
				foto.setNome(resultado.getString("nom_foto"));
				foto.setDescricao(resultado.getString("txt_descricao"));

				fotos.add(foto);
			}
			
			return fotos;
		}
		catch (SQLException e) {
			throw new PersistenceException("Erro ao inserir novo foto", e);
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
	
	public boolean insertFoto(Foto foto) throws PersistenceException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = this.getConnection();
			
			String query = "insert into foto (nom_foto, txt_descricao, img_foto) values (?, ?, ?);";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, foto.getNome());
			pstmt.setString(2, foto.getDescricao());
			pstmt.setBinaryStream(3,new ByteArrayInputStream(foto.getImagem()),foto.getImagem().length);
			int id = pstmt.executeUpdate();
			pstmt.close();

			return id > 0;
		}
		catch (SQLException e) {
			throw new PersistenceException("Erro ao inserir novo foto", e);
		}
		finally {
			try {
				if (conn != null) {
					conn.close();
				}				
				if (pstmt != null) {
					pstmt.close();
				}
			}
			catch (Exception e) {
				//do nothing
			}
		}		
	}
	
	public boolean updateFoto(Foto foto) throws PersistenceException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = this.getConnection();
			
			String query = "update foto set nom_foto = ?, txt_descricao = ?, img_foto = ? where cod_foto = ?;";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, foto.getNome());
			pstmt.setString(2, foto.getDescricao());
			pstmt.setBinaryStream(3,new ByteArrayInputStream(foto.getImagem()),foto.getImagem().length);
			pstmt.setInt(4,foto.getId());
			int id = pstmt.executeUpdate();
			pstmt.close();
			
			return id > 0;
		}
		catch (SQLException e) {
			throw new PersistenceException("Erro ao atualizar foto", e);
		}
		finally {
			try {
				if (conn != null) {
					conn.close();
				}				
				if (pstmt != null) {
					pstmt.close();
				}
			}
			catch (Exception e) {
				//do nothing
			}
		}		
	}
	
	public boolean deleteFoto(Foto foto) throws PersistenceException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = this.getConnection();
			
			String query = "delete from foto where cod_foto = ?;";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,foto.getId());
			int id = pstmt.executeUpdate();
			pstmt.close();
			
			return id > 0;
		}
		catch (SQLException e) {
			throw new PersistenceException("Erro ao remover foto", e);
		}
		finally {
			try {
				if (conn != null) {
					conn.close();
				}				
				if (pstmt != null) {
					pstmt.close();
				}
			}
			catch (Exception e) {
				//do nothing
			}
		}		
	}
}
