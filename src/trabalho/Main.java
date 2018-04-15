package trabalho;

import org.junit.runner.JUnitCore; 
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import teste.ListaTest;
public class Main {

	public static void main(String[] args) {
		try {
			JUnitCore junit = new JUnitCore();
			//junit.run(ListaTest.class);
			ListaTest teste = new ListaTest();
			Result result = junit.run(teste.getClass());
			//Util.printResult(result);
			
			System.out.println("Run " + result.getRunCount() + " tests in "+ result.getRunTime() +"ms.");
			if (result.wasSuccessful()) {
				System.out.println("\nAll tests were successfull!");
			}else {
				System.err.println(result.getFailureCount() + "Failures:");
				for (Failure fail: result.getFailures()){
					System.err.println("Failure in: "+ fail.getTestHeader());
					System.err.println(fail.getMessage());
					System.err.println(fail.getTrace());
					System.out.println();
				}
				if(result.getIgnoreCount() > 0) {
					System.out.println("And " + result.getIgnoreCount() + " tests ignored");
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}

			
//			System.out.println("Testando se é lançado erro quando se tenta excluir algo da lista "
//					+ "quando ela está vazia");
//			testErroExclusao(lista, 6);
//			
//			
//		}catch(Exception e) {
//			System.out.println("O teste passou. O erro lançado é:");
//			System.out.println(e.getMessage());
//			System.out.println();
//			try {
//				inserir();
//			} catch (Exception e1) {
//				System.out.println(e1.getMessage());
//			}
//		}finally {
//			System.exit(0);
//		}
//
//	}
//	
//	private static void testErroExclusao(ListaOrdenada lista, int id) throws Exception {
//		lista.excluir(id);
//	}
//	
//	private static void inserir() throws Exception {
//		System.out.println("Testando inserção.\nOs ids devem estar na seguinte ordem:\n"
//				+ "1, 18, 35, 39 e 45");
//		lista.insereOrdenado(aluno5);
//		lista.insereOrdenado(aluno3);
//		lista.insereOrdenado(aluno1);
//		lista.insereOrdenado(aluno4));
//		lista.insereOrdenado(aluno2);
//		/*IGenerico[] array = lista.listaTodos();
//		System.out.println("Resuldado:");
//		for(int i = 0; i<ar)ray.length; i++) {
//			System.out.println(array[i].getId());
//		}*/
//		lista.imprimeTodos();
//		exclusao();
//	}
//	
//	private static void exclusao() throws Exception {
//		System.out.println("\nTestando se a exclusão está funcionando:\nSerá excluído o objeto de id 18");
//		lista.excluir(18);
//		/*IGenerico[] array = lista.listaTodos();
//		System.out.println("Resultado");
//		for(int i = 0; i<array.length; i++) {
//			System.out.println(array[i].getId());
//		}*/
//		lista.imprimeTodos();
//		testeBusca();
//	}
//	
//	private static void testeBusca() throws Exception {
//		System.out.println("Testando a busca.\nO objeto que deve ser retornado deverá ter o id"
//				+ " igual à 39");
//		System.out.println("Objeto retornado " + lista.buscar(39).getId());
//		testDuplicacao();
//	}
//	
//	private static void testDuplicacao() {
//		System.out.println("\nÚltimo teste: Verificar se o sistema lança exceção ao tentar inserir objeto"
//				+ " com id já existente\nId que será testado: 45");
//		try {
//			lista.insereOrdenado(alunoRepetido);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
		