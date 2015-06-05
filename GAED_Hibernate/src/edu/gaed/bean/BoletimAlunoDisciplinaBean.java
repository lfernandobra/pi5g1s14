package edu.gaed.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import edu.gaed.vo.Aluno;
import edu.gaed.vo.BoletimAlunoDisciplina;
import edu.gaed.vo.Disciplina;
import edu.gaed.vo.Turma;
import edu.gaed.dao.BoletimAlunoDisciplinaDao;
 
@ManagedBean(name="BoletimAlunoDisciplinaBean")
@ViewScoped
public class BoletimAlunoDisciplinaBean {
 
        private BoletimAlunoDisciplina boletimalunodisciplina = new BoletimAlunoDisciplina();
        private List<BoletimAlunoDisciplina> boletimalunodisciplinas = new ArrayList<BoletimAlunoDisciplina>(); 
        private Turma turma;
        
        public BoletimAlunoDisciplinaBean(BoletimAlunoDisciplina boletimalunodisciplina, List<BoletimAlunoDisciplina> boletimalunodisciplinas) {
                super();
                this.boletimalunodisciplina = new BoletimAlunoDisciplina();
                this.boletimalunodisciplinas = new ArrayList<BoletimAlunoDisciplina>();
        }
 
        //construtor
        @SuppressWarnings("unchecked")
        public BoletimAlunoDisciplinaBean(){
                boletimalunodisciplinas = new BoletimAlunoDisciplinaDao().listar();
                boletimalunodisciplina = new BoletimAlunoDisciplina();
        }
 
        //Métodos dos botões 
        public void cadastrar(ActionEvent actionEvent){
                        			
        	for(Iterator<Aluno> iterAluno = turma.getAlunos().iterator(); iterAluno.hasNext();) 
        	{ 
        		Aluno alunoAtual = iterAluno.next(); 
        		boletimalunodisciplina.setAluno(alunoAtual);
        		
        		for(Iterator<Disciplina> iterDisciplina = turma.getDisciplinas().iterator(); iterDisciplina.hasNext();)
        		{
        			Disciplina disciplinaAtual = iterDisciplina.next();
        			boletimalunodisciplina.setDisciplina(disciplinaAtual);
        			new BoletimAlunoDisciplinaDao().inserir(boletimalunodisciplina);
        		}
        	}
        }
        
        @SuppressWarnings("unchecked")
        public void alterar(){
                new BoletimAlunoDisciplinaDao().alterar(boletimalunodisciplina);
                boletimalunodisciplinas = new BoletimAlunoDisciplinaDao().listar();
                boletimalunodisciplina = new BoletimAlunoDisciplina();
        }
        @SuppressWarnings("unchecked")
        public void excluir(BoletimAlunoDisciplina boletimalunodisciplinaex){
                new BoletimAlunoDisciplinaDao().excluir(boletimalunodisciplinaex);
                boletimalunodisciplinas = new BoletimAlunoDisciplinaDao().listar();
                boletimalunodisciplina = new BoletimAlunoDisciplina();
        }
        
        //getters and setters
        

        public List<BoletimAlunoDisciplina> getBoletimAlunoDisciplinas() {
                return boletimalunodisciplinas;
        }

        public void setBoletimAlunoDisciplinas(List<BoletimAlunoDisciplina> boletimalunodisciplinas) {
                this.boletimalunodisciplinas = boletimalunodisciplinas;
        }

        public BoletimAlunoDisciplina getBoletimAlunoDisciplina() {
                return boletimalunodisciplina;
        }

        public void setBoletimAlunoDisciplina(BoletimAlunoDisciplina boletimalunodisciplina) {
                this.boletimalunodisciplina = boletimalunodisciplina;
        }

		public Turma getTurma() {
			return turma;
		}

		public void setTurma(Turma turma) {
			this.turma = turma;
		}
 
        // métodos reset
        
        
}