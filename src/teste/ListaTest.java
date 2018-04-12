package teste;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import trabalho.IGenerico;
import trabalho.Aluno;
import trabalho.Lista;

public class ListaTest {
		private Aluno aluno1 = new Aluno(39, "Higor");
		private Aluno aluno2 = new Aluno(18, "Sadi");;
		private Aluno aluno3 = new Aluno(45, "Marcos");;
		private Aluno aluno4 = new Aluno(1, "Lucas");;
		private Aluno aluno5 = new Aluno(35, "João");;
		private Aluno alunoRepetido = new Aluno(45, "Repetido");
		private Lista lista = new Lista();;
		/*
		 * Os métodos de teste necessários são:
		 * 
		 * # Inclusão = verificar se foi incluso corretamente;
		 * # Exclusão = verificar se foi excluído corretamente;
		 * # Busca = verificar se a busca dá certo(também pode ser usada para verificar se a 
		 * 			 inclusão e a exclusão funcionam);
		 * # Ordenação = verificar se os elementos estão corretamente ordenados;
		 * # Exceptions = verificar se as exceções são lançadas corretamente;
		 * 
		 * @ Problemas
		 * 
		 * $ Não faço a menor ideia de como verificar se os elementos estão ordenados;
		 */
		@Rule
		public ExpectedException excecaoEsperada = ExpectedException.none();
		
		
		@Test
		public void testExceptionExclusao() throws Exception {
			excecaoEsperada.expect(Exception.class);
			excecaoEsperada.expectMessage("Lista vazia");
			lista.excluir(6);
		}
		
		@Test
		public void testInsereOrdenado() {
			lista.insereOrdenado(aluno5);
			lista.insereOrdenado(aluno2);
			lista.insereOrdenado(aluno3);
			lista.insereOrdenado(aluno1);
			lista.insereOrdenado(aluno4);
			IGenerico[] experado = new IGenerico[]{aluno4, aluno2, aluno5, aluno1, aluno3};
			Assert.assertArrayEquals(experado, lista.listaTodos());
		}
			
		@Test
		public void testExcluir() throws Exception {
			lista.excluir(18);
			excecaoEsperada.expect(Exception.class);
			excecaoEsperada.expectMessage("O objeto com o id" + 18 + " não existe na lista");
			lista.buscar(18);
			
			
		}
		
		@Test
		public void testBuscar() throws Exception {
			lista.buscar(39);
			Assert.assertSame(aluno1, aluno1);
			
		}
		
		@Test
		public void testExceptionInclusão() throws Exception {
			excecaoEsperada.expect(Exception.class);
			excecaoEsperada.expectMessage("Id repetido");
			lista.insereOrdenado(alunoRepetido);
		}

			
		

}
