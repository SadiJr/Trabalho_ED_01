package trabalho;

public class ListaOrdenada {
	private Caixa primeiro;
	private int numElem;
	
	
	public ListaOrdenada() {
		primeiro = new Caixa(null, null, null);
		numElem = 0;
	}
	
	public void insereOrdenado(IGenerico generico) throws Exception {
		if(ListaSimples.getInstance().existe(primeiro, generico.getId(), numElem)) {
			throw new Exception("Já existem um objeto com o id " + generico.getId() + " na lista");
		}
		if(numElem == 0) {
			//primeiro = new Caixa(null, generico, null);
			//primeiro.setAnterior(primeiro);
			//primeiro.setSeguinte(primeiro);
			primeiro = ListaSimples.getInstance().inserirPrimeiro(primeiro, generico);
			numElem++;
		}else if(numElem == 1){
			if(primeiro.getGenerico().getId() > generico.getId()) {
				primeiro = ListaSimples.getInstance().inserirAntesPrimeiro(primeiro, generico);
				numElem++;
				//insereAntesPrimeiro(generico);
			}else {
				primeiro = ListaSimples.getInstance().inserirDepoisPrimeiro(primeiro, generico);
				numElem++;
				//inserirDepoisPrimeiro(generico);
			}
		}else {
			if(primeiro.getGenerico().getId() > generico.getId()) {
				primeiro = ListaSimples.getInstance().inserirAntesPrimeiro(primeiro, generico);
				numElem++;
				//insereAntesPrimeiro(generico);
			}else {
				ListaSimples.getInstance().inserirAntesDe(ListaSimples.getInstance().percorreLista(primeiro, generico), generico);
				//inserirAntesDe(percorreLista(generico), generico);
				numElem++;
			}
		}
		
	}
	
	/*private void insereAntesPrimeiro(IGenerico generico) {
		Caixa nova = new Caixa(primeiro.getAnterior(), generico, primeiro);
		primeiro.getAnterior().setSeguinte(nova);
		primeiro.setAnterior(nova);
		primeiro = nova;
		numElem++;
	}
	
	private void inserirDepoisPrimeiro(IGenerico generico) {
		Caixa nova = new Caixa(primeiro, generico, primeiro);
		primeiro.setSeguinte(nova);
		primeiro.setAnterior(nova);
		numElem++;
	}*/
	
	/*private void inserirAntesDe(Caixa caixa, IGenerico novo) {
		Caixa nova = new Caixa(caixa.getAnterior(), novo, caixa);
		caixa.getAnterior().setSeguinte(nova);
		caixa.setAnterior(nova);
		numElem++;
	}*/
	
	/*private Caixa percorreLista (IGenerico generico) {
		Caixa c = primeiro;
		boolean achei = false;
		while(!achei) {
			if(c.getGenerico().getId() > generico.getId()) {
				achei = true;
			}else {
				c = c.getSeguinte();
			}
		}
		return c;
	}*/
	
	
	public void excluir(int id) throws Exception{
		ListaSimples.getInstance().excluir(primeiro, id, numElem);
		numElem--;
		/*Caixa c = primeiro;
		boolean excluido = false;
		while(!excluido) {
			if(numElem == 0) {
				throw new Exception("Lista vazia");
			}else if(numElem == 1) {
				if(c.getGenerico().getId() == id) {
					primeiro = null;
					numElem--;
					excluido = true;
				}else {
					throw new Exception("O objeto com o id " + id + " não existe na lista");
				}
			}else {
				if(c.getGenerico().getId() == id) {
					c.getAnterior().setSeguinte(c.getSeguinte());
					c.getSeguinte().setAnterior(c.getAnterior());
					numElem--;
					excluido = true;
				}else if(c.getSeguinte().equals(primeiro)) {
					throw new Exception("O objeto com o id " + id + " não existe na lista");
				}else {
					c = c.getSeguinte();
				}
			}

		}*/
		
	}
	
	public IGenerico buscar(int id) throws Exception {
		return ListaSimples.getInstance().buscar(primeiro, id, numElem);
		/*IGenerico generico = null;
		Caixa c = primeiro;
		boolean retorna = false;
		while(!retorna) {
			if(numElem == 0) {
				throw new Exception("Lista vazia");
			}else if(numElem == 1) {
				if(c.getGenerico().getId() == id) {
					retorna = true;
				}else {
					throw new Exception("O objeto com o id " + id + " não existe na lista");
				}
			}else {
				if(c.getGenerico().getId() == id) {
					generico = c.getGenerico();
					retorna = true;
				
				}else if(c.getSeguinte().equals(primeiro)){
					throw new Exception("O objeto com o id " + id + " não existe na lista");
				
				}else {
					c = c.getSeguinte();
				}
			}
		}
		return generico;*/
	}
	
	//Criei apenas para caso seja necessário
	private boolean existe(int id) {
		return ListaSimples.getInstance().existe(primeiro, id, numElem);
		/*boolean existe = true;
		Caixa c = primeiro;
		while(existe) {
			if(numElem == 0) {
				 existe = false;
			}else if(numElem == 1) {
				if(c.getGenerico().getId() == id) {
					return true;
				}else {
					existe = false;
				}
			}else {
				if(c.getGenerico().getId() == id) {
					return true;
				}else {
					if(c.getSeguinte().equals(primeiro)) {
						existe = false;
					}else {
						c = c.getSeguinte();
					}
				}
			}
			
		}
		return existe;*/
	}
	
	//Criado apenas para verificar se a ordenação foi feita corretamente;
	public IGenerico[] listaTodos() {
		return ListaSimples.getInstance().retornaListaTodos(primeiro, numElem);
	}
	
	public void imprimeTodos() {
		ListaSimples.getInstance().listaTodos(primeiro, numElem);
	}

}
