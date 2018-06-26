package estudante;

import javax.swing.JOptionPane;

import database.Database;

public class Principal {
	
	public static void main(String[] args) {
		
		Database database = new Database();
		
		Alunos aluno = new Alunos(0, "Bruno", "bruesmanbruesman@hotmail.com");
		Alunos aluno_a = new Alunos(0, "Jose", "Jose@hotmail.com");
		Alunos aluno_b = new Alunos(0, "Pedro", "Pedro@hotmail.com");
		
		database.salvarAluno(aluno);
		database.salvarAluno(aluno_a);
		database.salvarAluno(aluno_b);
		
	}

}

