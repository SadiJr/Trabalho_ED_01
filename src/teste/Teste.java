package teste;

import trabalho.Aluno;
import trabalho.IGenerico;
import trabalho.Lista;

public class Teste {
	private Aluno aluno1;
	private Aluno aluno2;
	private Aluno aluno3;
	private Aluno aluno4;
	private Aluno aluno5;
	private Lista lista;
	
	public Teste() {
		aluno1 = new Aluno("Higor");
		aluno2 = new Aluno("Sadi");
		aluno3 = new Aluno("Marcos");
		aluno4 = new Aluno("Lucas");
		aluno5 = new Aluno("João");
		lista = new Lista();
	}
	

	public void testInsereOrdenado() {
		lista.insereOrdenado(aluno5);
		lista.insereOrdenado(aluno1);
		lista.insereOrdenado(aluno3);
		lista.insereOrdenado(aluno2);
		lista.insereOrdenado(aluno4);
		IGenerico[] genericos = lista.listaTodos();
		for(int i = 0; i < genericos.length; i++) {
			System.out.println("Id " + genericos[i].getId());
		}
	}

	void testExcluir() {
		try {
			lista.excluir(5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void testBuscar() {
	}

}
