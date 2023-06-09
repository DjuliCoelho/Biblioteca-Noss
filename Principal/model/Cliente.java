package Principal.model;


public class Cliente {
	private String nome;
	private int espera;
	private int retirado;
	private boolean temlivro;
	private boolean esperando;
	
	public Cliente(String nome, int espera, int retirado) {
		this.nome = nome;
		this.espera = espera;
		this.retirado = retirado;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public boolean isTemlivro() {
		return temlivro;
	}

	public void setTemlivro(boolean temlivro) {
		this.temlivro = temlivro;
	}

	public void setRetirado(int retirado) {
		this.retirado = retirado;
	}

	public boolean isEsperando() {
		return esperando;
	}

	public void setEsperando(boolean esperando) {
		this.esperando = esperando;
	}

	public int getEspera() {
		return espera;
	}

	public int getRetirado() {
		return retirado;
	}

	public void setEspera(int id) {
		this.espera = id;
	}
	
	public boolean getTemLivro() {
		return this.temlivro;
	}
	
	public void retirarLivro(Livro livro) {
		if(!livro.checkDispobibilidade()) {
			livro.colocarNaFila(this.nome);
			this.espera = livro.getId();
		}
		else {
			this.retirado = livro.getId();
			livro.retirar();
			this.temlivro = true;
		}
	}
	
	public void devolverLivro(Livro livro) {
		this.retirado = -1;
		livro.devolver();
		this.temlivro = false;
	}
	
	public void printCliente(Catalogo catalogo) {
		System.out.println("Nome: " + this.nome);
		if(retirado>=0) {
			Livro emprestado = catalogo.getLivro(this.retirado);
			System.out.println("Livro em posse: " + emprestado.getNome()); 
		}
		if(espera>=0) {
			Livro espera = catalogo.getLivro(this.espera);
			System.out.println("Livro em espera: " + espera.getNome());
		}
		System.out.println();
	}
	
}
