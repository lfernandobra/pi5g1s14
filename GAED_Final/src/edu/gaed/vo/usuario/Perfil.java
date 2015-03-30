package edu.gaed.vo.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public enum Perfil {
	 ADMIN(0),
	 GESTOR(1),
	 SECRETARIA(2),
	 PROFESSOR(3),
	 RESPONSAVEL(4),
	 ALUNO(5);  
	 
	 @Id
	 @Column(name="id_value", nullable=false)
	 private int value;
	 
	 private Perfil(int value) {
	    this.value = value;
	 }
	 
	 @OneToMany(mappedBy="perfil")
	 
	 public static Perfil fromValue(int value) {  
	   for (Perfil my: Perfil.values()) {  
	      if (my.value == value) {  
	         return my;  
	      }  
	   }  
	  
	   return null;  
	 }  

	 public boolean isAdmin() {
	   return this.value == ADMIN.value;
	 }

	 public boolean isGestor(){
		 return this.value == GESTOR.value;
	 }
	 
	 public boolean isSecretaria(){
		 return this.value == SECRETARIA.value;
	 }
	 
	 public boolean isProfessor() {
	    return this.value == PROFESSOR.value;
	 }
	 
	 public boolean isResponsavel(){
		 return this.value == RESPONSAVEL.value;
	 }

	 public boolean isAluno() {
	    return this.value == ALUNO.value;
	 }

}
