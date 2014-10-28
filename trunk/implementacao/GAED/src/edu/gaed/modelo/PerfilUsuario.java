package edu.gaed.modelo;

public enum PerfilUsuario {
	 ADMIN(0),
	 GESTOR(1),
	 SECRETARIA(2),
	 PROFESSOR(3),
	 RESPONSAVEL(4),
	 ALUNO(5);  
	  
	 private int value;
	  
	 private PerfilUsuario(int value) {
	    this.value = value;
	 }

	 public static PerfilUsuario fromValue(int value) {  
	   for (PerfilUsuario my: PerfilUsuario.values()) {  
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
