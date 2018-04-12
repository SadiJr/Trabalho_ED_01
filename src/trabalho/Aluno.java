package trabalho;

public class Aluno implements IGenerico{
	private static int numId = 0;
	private int id;
	private String nome;
	
	public Aluno(String nome) {
		this.id = numId;
		this.nome = nome;
		numId++;
	}
	
	@Override
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
