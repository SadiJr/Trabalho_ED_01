package trabalho;

public class Lista {
	private Caixa primeiro;
	private int numElem;
	
	
	public Lista() {
		numElem = 0;
	}
	
	public void insereOrdenado(IGenerico generico) throws Exception {
		if(existe(generico.getId())) {
			throw new Exception("Já existem um objeto com o id " + generico.getId() + " na lista");
		}
		if(numElem == 0) {
			primeiro = new Caixa(null, generico, null);
			primeiro.setAnterior(primeiro);
			primeiro.setSeguinte(primeiro);
			numElem++;
		}else if(numElem == 1){
			if(primeiro.getGenerico().getId() > generico.getId()) {
				insereAntesPrimeiro(generico);
			}else {
				inserirDepoisPrimeiro(generico);
			}
		}else {
			if(primeiro.getGenerico().getId() > generico.getId()) {
				insereAntesPrimeiro(generico);
			}else {
				inserirAntesDe(percorreLista(generico), generico);
			}
		}
		
	}
	
	private void insereAntesPrimeiro(IGenerico generico) {
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
	}
	
	private void inserirAntesDe(Caixa caixa, IGenerico novo) {
		Caixa nova = new Caixa(caixa.getAnterior(), novo, caixa);
		caixa.getAnterior().setSeguinte(nova);
		caixa.setAnterior(nova);
		numElem++;
	}
	
	private Caixa percorreLista (IGenerico generico) {
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
	
	
	public void excluir(int id) throws Exception{
		Caixa c = primeiro;
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

		}
		
	}
	
	public IGenerico buscar(int id) throws Exception {
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
	
	//Criei apenas para caso seja necessário
	private boolean existe(int id) {
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
	
	//Criado apenas para verificar se a ordenação foi feita corretamente;
	public IGenerico[] listaTodos() {
		IGenerico[] genericos = new IGenerico[numElem];
		Caixa c = primeiro;
		for(int i=0; i < numElem; i++) {
			genericos[i] = c.getGenerico();
			c = c.getSeguinte();
		}
		return genericos;
	}

}
