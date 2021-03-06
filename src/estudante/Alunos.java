package estudante;

public class Alunos {
	
	private float renda;
	private String nome;
	private String email;
	 
	public Alunos(float renda, String nome, String email){
		
		this.setRenda(renda);
		this.setNome(nome);
		this.setEmail(email);
	}
		
	
		@Override
	public String toString() {
		String resposta = "----------Aluno----------"+"\n"+
					      "Nome: " + nome +"\n"+
					      "Email: " + email +"\n"+
					      "Renda: " + renda + "\n";
		return resposta;
	}
	
	
	public float getRenda() {
		return renda;
	}
	
	public void setRenda(float renda) {
		this.renda = renda;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}


