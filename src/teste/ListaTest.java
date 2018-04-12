package teste;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import trabalho.Aluno;
import trabalho.Lista;

public class ListaTest {
		private Aluno aluno1 = new Aluno("Higor");
		private Aluno aluno2 = new Aluno("Sadi");;
		private Aluno aluno3 = new Aluno("Marcos");;
		private Aluno aluno4 = new Aluno("Lucas");;
		private Aluno aluno5 = new Aluno("João");;
		private Lista lista = new Lista();;
			
		@Test
		public void testInsereOrdenado() {
			lista.insereOrdenado(aluno5);
			lista.insereOrdenado(aluno2);
			lista.insereOrdenado(aluno3);
			lista.insereOrdenado(aluno1);
			lista.insereOrdenado(aluno4);
		}
			
		@Test
		public void testExcluir() {
			try {
				lista.excluir(5);
				lista.excluir(1);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}	
		}
		
		@Test
		public void testBuscar() {
			
		}
			
		@Rule
		public ExpectedException excecaoEsperada = ExpectedException.none();
			
		@Test
		public void testExceptionExclusao() throws Exception {
			excecaoEsperada.expect(Exception.class);
			excecaoEsperada.expectMessage("Lista vazia");
			lista.excluir(6);
		}

}
