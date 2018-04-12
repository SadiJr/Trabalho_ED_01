package teste;

import junit.framework.TestCase;
import trabalho.Aluno;
import trabalho.Lista;

public class TesteTest extends TestCase {
	private Aluno aluno1 = new Aluno("Higor");
	private Aluno aluno2 = new Aluno("Sadi");;
	private Aluno aluno3 = new Aluno("Marcos");;
	private Aluno aluno4 = new Aluno("Lucas");;
	private Aluno aluno5 = new Aluno("João");;
	private Lista lista = new Lista();;

	public void testInsereOrdenado() {
		lista.insereOrdenado(aluno5);
		lista.insereOrdenado(aluno2);
		lista.insereOrdenado(aluno3);
		lista.insereOrdenado(aluno1);
		lista.insereOrdenado(aluno4);
	}

	public void testExcluir() {
		try {
			lista.excluir(6);
			fail("O teste falhou, pois não lançou uma exceção");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void testBuscar() {
		fail("Not yet implemented");
	}

}
