package Entidades;

public class Emprestimo {

	private Livro livro;
	private Cliente cliente;
	
	
	public Emprestimo(Livro livro, Cliente cliente) {
		super();
		this.livro = livro;
		this.cliente = cliente;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
