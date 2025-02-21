package Entidades;

import java.util.List;

public class Biblioteca {
	private List<Livro> livros;
	private List<Autor> autores;
	private List<Emprestimo> disponiveis;
	private List<Cliente> clientes;
	
	private void atualizarDisponiveis(Cliente cliente) {
		for (int i=0;i<livros.size();i++) {
			if(livros.get(i).isDisponivel()) {
				disponiveis.add(new Emprestimo(livros.get(i), cliente));			
			}else if (!livros.get(i).isDisponivel()) {
				disponiveis.remove(new Emprestimo(livros.get(i), cliente));
			}
		}		
	}
	
	public List<Autor> getAutores() {
		return autores;
	}
	
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public List<Livro> getLivros() {
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	public List<Autor> getAutorress() {
		return autores;
	}
	public void setAutorress(List<Autor> autorress) {
		this.autores = autorress;
	}
	public List<Emprestimo> getDisponiveis() {
		return disponiveis;
	}
	public void setDisponiveis(List<Emprestimo> disponiveis) {
		this.disponiveis = disponiveis;
	}	
}
