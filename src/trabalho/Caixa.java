package trabalho;

public class Caixa {
	private Caixa anterior;
	private IGenerico generico;
	private Caixa seguinte;
	
	public Caixa(Caixa anterior, IGenerico generico, Caixa seguinte) {
		this.setAnterior(anterior);
		this.setGenerico(generico);
		this.setSeguinte(seguinte);
	}

	public Caixa getAnterior() {
		return anterior;
	}

	public void setAnterior(Caixa anterior) {
		this.anterior = anterior;
	}

	public IGenerico getGenerico() {
		return generico;
	}

	public void setGenerico(IGenerico generico) {
		this.generico = generico;
	}

	public Caixa getSeguinte() {
		return seguinte;
	}

	public void setSeguinte(Caixa seguinte) {
		this.seguinte = seguinte;
	}

}
