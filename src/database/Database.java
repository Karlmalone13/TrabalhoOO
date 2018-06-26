package database;
import java.io.*;

import estudante.Alunos;

public class Database {
	
	private String DELIMITADOR = ",";
	private String NOVA_LINHA = "\n";
	private String FILE_NAME = "database.csv";
	FileWriter writer;
	
	public void salvarAluno(Alunos aluno) {
		
		String nome = aluno.getNome();
		String email = aluno.getEmail();
		Float renda = aluno.getRenda();
		
		System.out.println(nome);
		System.out.println(email);
		System.out.println(renda);
		
		try {
			
			this.writer = new FileWriter(FILE_NAME, true);
			
			this.writer.append(NOVA_LINHA);
			this.writer.append(nome);
			this.writer.append(DELIMITADOR);
			this.writer.append(email);
			this.writer.append(DELIMITADOR);
			this.writer.append(String.valueOf(renda));
			this.writer.append(DELIMITADOR);
			this.writer.flush();
			this.writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
