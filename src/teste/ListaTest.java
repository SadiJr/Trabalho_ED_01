package teste;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;

import trabalho.IGenerico;
import trabalho.Aluno;
import trabalho.ListaOrdenada;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ListaTest {
		private static Aluno aluno1 = new Aluno(39, "Higor");
		private static Aluno aluno2 = new Aluno(18, "Sadi");;
		private static Aluno aluno3 = new Aluno(45, "Marcos");;
		private static Aluno aluno4 = new Aluno(1, "Lucas");;
		private static Aluno aluno5 = new Aluno(35, "João");;
		private static Aluno alunoRepetido = new Aluno(45, "Repetido");
		private static ListaOrdenada lista = new ListaOrdenada();

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
		@Rule public TestName name = new TestName();
		
		@Test()
		public void test1() {
			try {
				System.out.println("Testando se é lançada uma exceção ao tentar excluir "
						+ "um objeto da lista quando a mesma está vazia");
				this.lista.excluir(6);
				fail("Uma exceção deveria ser lançada");
			}catch(Exception e) {
				System.out.println("A exceção que deve ser lançada é 'Lista vazia'");
				assertEquals("Lista vazia", e.getMessage());
				System.out.println("O teste passou");
			}
		}
		
		@Test
		public void test2() throws Exception {
			this.lista.insereOrdenado(aluno5);
			this.lista.insereOrdenado(aluno2);
			this.lista.insereOrdenado(aluno3);
			this.lista.insereOrdenado(aluno1);
			this.lista.insereOrdenado(aluno4);
			IGenerico[] experado = new IGenerico[]{aluno4, aluno2, aluno5, aluno1, aluno3};
			Assert.assertArrayEquals(experado, this.lista.listaTodos());
			//assertTrue(Arrays.equals(experado, lista.listaTodos()));
		}
			
		@Test
		public void test3() {
			try {
				this.lista.excluir(18);
				this.lista.buscar(18);
				fail("Uma exceção deveria ser lançada");
			}catch(Exception e) {
				assertEquals("O objeto com o id 18 não existe na lista", e.getMessage());
			}
			
			
		}
		
		@Test
		public void test4() throws Exception {
			Assert.assertSame(aluno1, this.lista.buscar(39));
			
		}
		
		@Test
		public void test5() {
			try {
				this.lista.insereOrdenado(alunoRepetido);
				fail("Uma exceção deve ser lançada");
			}catch(Exception e) {
				assertEquals("Já existe um objeto com a id 45 na lista", e.getMessage());
			}
		}
			
		

}
