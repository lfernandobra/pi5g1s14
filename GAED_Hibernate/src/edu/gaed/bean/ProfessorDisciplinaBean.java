package edu.gaed.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
//import javax.faces.model.SelectItem;

import edu.gaed.vo.Disciplina;
 
@ManagedBean
public class ProfessorDisciplinaBean {
         
    private List<Disciplina> selectedDisciplinas;   
    private List<Disciplina> disciplinas;
    DisciplinaBean disciplinaBean = new DisciplinaBean();
     
    @PostConstruct
    public void init() {
        disciplinas = new ArrayList<Disciplina>();
        
		List<Disciplina> disciplinasBeanCadastradas = disciplinaBean.disciplinas;
                
		disciplinas = new ArrayList<Disciplina>(disciplinasBeanCadastradas.size());
        
        for(Disciplina d : disciplinasBeanCadastradas){
        	disciplinas.add(d);
        	System.out.println(d.getId());
        }
    }
 
    public List<Disciplina> getSelectedDisciplinas() {
    	return selectedDisciplinas;
    }
 
    public void setSelectedDisciplinas(List<Disciplina> selectedDisciplinas) {
        this.selectedDisciplinas = selectedDisciplinas;
    }
 
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}
