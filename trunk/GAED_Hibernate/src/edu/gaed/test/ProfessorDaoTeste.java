package edu.gaed.test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import edu.gaed.vo.Disciplina;
import edu.gaed.vo.Professor;

public class ProfessorDaoTeste {

	@Test
		public void testSalvar() throws ParseException {
			Professor professor = new Professor();
			Set<Disciplina> disciplinas = new HashSet<Disciplina>();
			Disciplina disciplina01 = new Disciplina();
			disciplina01.setNome("matematica");
			disciplinas.add(disciplina01);
			
			professor.setNome("Ana");
			professor.setSobrenome("Siqueria");
			professor.setTelefone("19999999999");
			professor.setSexo("Feminino");
			professor.setRG("498765432");
			professor.setNumero("123141");
			professor.setInstituicaoAcad("instituicao");
			professor.setEscolaAnterior("Escola Anterior");
			professor.setEmail("professor@professor.com");
			professor.setCPF("12345609876");
			professor.setComplemento("casa");
			professor.setAnoConclusao(DateFormat.getInstance().parse("20/12/2008"));
			professor.setDataIngresso(DateFormat.getInstance().parse("20/12/2008"));
			professor.setDatanasc(DateFormat.getInstance().parse("30/09/1988"));
			professor.setDataSaida(DateFormat.getInstance().parse("30/09/2009"));
			professor.setDisciplinas(disciplinas);
			professor.setFoto(null);
			professor.setLogin("professor0101");
			professor.setSenha("professor1234134");
			
			edu.gaed.dao.ProfessorDao professorDao = new edu.gaed.dao.ProfessorDao();
			professorDao.inserir(professor);
	}

}
