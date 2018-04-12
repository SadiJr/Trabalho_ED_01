package trabalho;

public class Aluno implements IGenerico{
	private int id;
	private String nome;
	
	public Aluno(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
