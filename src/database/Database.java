package database;
import java.io.*;
import java.util.List;

import estudante.Alunos;

public class Database {
	
	private String DELIMITADOR = ",";
	private String NOVA_LINHA = "\n";
	private String FILE_NAME = "database.csv";
	FileWriter writer;
	
	public void salvar(List<Alunos> alunos) {
		
		this.esvaziaBanco();
		
		for(Alunos aluno : alunos) {
			
			String nome = aluno.getNome();
			String email = aluno.getEmail();
			Float renda = aluno.getRenda();
			
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
	
	private void esvaziaBanco() {
		File file = new File(FILE_NAME);
		try {
			
			file.createNewFile();
			this.writer = new FileWriter(FILE_NAME, false);
			this.writer.append("NOME,EMAIL,REDA");
			writer.flush();
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
