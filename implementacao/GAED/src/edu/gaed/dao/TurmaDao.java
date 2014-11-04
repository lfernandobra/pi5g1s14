package edu.gaed.dao;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import edu.gaed.vo.Turma;


public class TurmaDao extends BaseDao {

    public List<Turma> getTurmas(int idProfessor) {
     
    	Connection conn = null;
        List<Turma> turmaList = new ArrayList<Turma>();
        
        try {
        	conn = this.getConnection();
			
			String sql = "select t.ID_Turma,t.Nome_Turma,t.Periodo,t.Serie,t.Ano_Letivo,t.Bimestre from turma t,possui p,disciplina d,ministra m,professor pr where t.ID_Turma = p.ID_Turma and p.ID_Disciplina = d.ID_Disciplina and d.ID_Disciplina = m.ID_Disciplina and m.ID_Professor = pr.ID_Professor and pr.ID_Professor = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, idProfessor);
			
			ResultSet rs = stmt.executeQuery();
        
            while(rs.next()) { 
             Turma turma=new Turma();
             turma.setID(rs.getInt("ID_Turma"));
             turma.setNome(rs.getString("Nome_Turma"));
             turma.setPeriodo(rs.getString("Periodo"));
             turma.setSerie(rs.getInt("Serie"));
             turma.setAno_letivo(rs.getInt("Ano_Letivo"));
             turma.setBimestre(rs.getInt("Bimestre"));
             
             turmaList.add(turma);
             
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return turmaList;
    }
}