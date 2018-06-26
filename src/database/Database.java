package database;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import estudante.Alunos;

public class Database {
	
	private String DELIMITADOR = ",";
	private String NOVA_LINHA = "\n";
	private String FILE_NAME = "database.csv";
	FileWriter writer;
	
	//Metodo para salvar collection no
	//arquivo CSV
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
	//Método para recuperar todos os alunos
	//salvos no arquivo CSV
	public List<Alunos> recuperarDados(){
		
		List<Alunos> alunos = new ArrayList<Alunos>();
		BufferedReader br = null;
		int contador = 0;
		String line = "";  
		
		try {
			br = new BufferedReader(new FileReader(FILE_NAME));
			while ((line = br.readLine()) != null) {
				//O contador serve para identificar se
				//a linha lida é o HEADER do arquivos CSV
				//se for, essa linha é pulada
				if(contador == 0) {
					contador++;
					continue;
				}
				else {
					
					String[] alunos_csv = line.split(DELIMITADOR);
					String nome = alunos_csv[0];
					String email = alunos_csv[1];
					Float renda =  Float.parseFloat(alunos_csv[2].toString());
					
					Alunos aluno = new Alunos(renda, nome, email);
					alunos.add(aluno);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		 return alunos;
	}
	//Esvazia o arquivo para popular novamente
	//com dados atualizado
	private void esvaziaBanco() {
		File file = new File(FILE_NAME);
		try {
			
			file.createNewFile();
			this.writer = new FileWriter(FILE_NAME, false);
			this.writer.append("NOME,EMAIL,RENDA");
			writer.flush();
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
