package trabalho;

public class ListaSimples {
	private static final ListaSimples instance = new ListaSimples();
	
	public ListaSimples() {
		
	}

	public static ListaSimples getInstance() {
		return instance;
	}
	
	public Caixa inserirPrimeiro(Caixa primeiro, IGenerico generico) {
		primeiro = new Caixa(null, generico, null);
		primeiro.setAnterior(primeiro);
		primeiro.setSeguinte(primeiro);
		return primeiro;
	}
	
	public Caixa inserirAntesPrimeiro(Caixa primeiro, IGenerico generico) {
		Caixa nova = new Caixa(primeiro.getAnterior(), generico, primeiro);
		primeiro.getAnterior().setSeguinte(nova);
		primeiro.setAnterior(nova);
		primeiro = nova;
		return primeiro;
	}
	
	public Caixa inserirDepoisPrimeiro(Caixa primeiro, IGenerico generico) {
		Caixa nova = new Caixa(primeiro, generico, primeiro);
		primeiro.setSeguinte(nova);
		primeiro.setAnterior(nova);
		return primeiro;
	}
	
	public void inserirAntesDe(Caixa caixa, IGenerico novo) {
		Caixa nova = new Caixa(caixa.getAnterior(), novo, caixa);
		caixa.getAnterior().setSeguinte(nova);
		caixa.setAnterior(nova);
	}
	
	public Caixa percorreLista(Caixa primeiro, IGenerico generico) {
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
	}
	
	public void excluir(Caixa primeiro, int id, int numElem) throws Exception {
		Caixa c = primeiro;
		boolean excluido = false;
		while(!excluido) {
			if(numElem == 0) {
				throw new Exception("Lista vazia");
			}else if(numElem == 1) {
				if(c.getGenerico().getId() == id) {
					primeiro = null;
					//numElem--;
					excluido = true;
				}else {
					throw new Exception("O objeto com o id " + id + " não existe na lista");
				}
			}else {
				if(c.getGenerico().getId() == id) {
					c.getAnterior().setSeguinte(c.getSeguinte());
					c.getSeguinte().setAnterior(c.getAnterior());
					//numElem--;
					excluido = true;
				}else if(c.getSeguinte().equals(primeiro)) {
					throw new Exception("O objeto com o id " + id + " não existe na lista");
				}else {
					c = c.getSeguinte();
				}
			}
		}
	}
	
	public IGenerico buscar(Caixa primeiro, int id, int numElem) throws Exception {
		IGenerico generico = null;
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
		return generico;
	}
	
	public boolean existe(Caixa primeiro, int id, int numElem) {
		boolean existe = true;
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
		return existe;
	}
	
	public IGenerico[] retornaListaTodos(Caixa primeiro, int numElem) {
		IGenerico[] genericos = new IGenerico[numElem];
		Caixa c = primeiro;
		for(int i=0; i < numElem; i++) {
			genericos[i] = c.getGenerico();
			c = c.getSeguinte();
		}
		return genericos;
	}
	
	//Método criado para facilitar a visualização dos elementos
	//Não é recomendado usá-lo nos testes.
	public void listaTodos(Caixa primeiro, int numElem) {
		Caixa c = primeiro;
		for(int i=0; i < numElem; i++) {
			System.out.println(c.getGenerico().getId());
			c = c.getSeguinte();
		}
		
	}
}
