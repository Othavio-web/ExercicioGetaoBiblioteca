package main;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Entidades.Autor;
import Entidades.Biblioteca;
import Entidades.Cliente;
import Entidades.Emprestimo;
import Entidades.Livro;

public class Gestao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Biblioteca biblioteca = new Biblioteca();
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		
		if(biblioteca.getLivros().isEmpty()) {
			System.out.println("Precisa add Livros");
			String addLivros = "sim";
			while(addLivros.startsWith("s")||addLivros.startsWith("y")) {
				Scanner s = new Scanner(System.in);
				System.out.println("Já possui uma lista de livros?");
				String resposta = s.nextLine();
				
				if(resposta.contains("s")||resposta.contains("y")) {
					System.out.println("Informe o caminho");
					resposta = s.nextLine();
					s = new Scanner (resposta);
					//loop para ler arquivo e add na lista
					File arquivo = new File (resposta);
					
					while(arquivo.canRead()) {
						String dados = s.next();
						String[] info= dados.split(";");
						;
						int id= Integer.parseInt(info[0]);
						String titulo = info[1];
						Autor autor =  new Autor();
						boolean disponivel = true;
						LocalDateTime dataCadastro=LocalDateTime.parse(info[5]);
						LocalDateTime dataAtualizacao=LocalDateTime.now();
						
						autor.setNome(info[3]);
						autor.setId(Integer.parseInt(info[2]));
						autor.setDataNascimento(LocalDateTime.parse(info[4]));
						
						Livro add = new Livro(id, titulo, autor, disponivel, dataCadastro, dataAtualizacao);
						
						biblioteca.getLivros().add(add);
						
						
					}
				}else {
					//codigo para informar um livro por vez 
				}
				
				do {
					System.out.println("Informe seu cpf");
					int cpf = s.nextInt();
					System.out.println("Informe seu nome");
					String nome = s.nextLine();
					System.out.println("Informe sua data de nascimento");
					String dtNasc = s.nextLine();
					System.out.println("Informe seu e-mail");
					String email = s.next();
					Cliente cliente = new Cliente(cpf, nome, LocalDateTime.parse(dtNasc), email); 
					System.out.println("Qual livro deseja alugar ou devolver?");
					resposta = s.nextLine();
					Livro busca = new Livro();
					busca.setTitulo(resposta);
					if(!biblioteca.getDisponiveis().contains(busca)) {
						int index = biblioteca.getLivros().indexOf(busca);
						biblioteca.getLivros().get(index).setDisponivel(true);
						System.out.println("Livro devolvido, disponivel para futuros imprestimos");
						emprestimos.remove(new Emprestimo(biblioteca.getLivros().get(index), cliente));
					}else{
						int index = biblioteca.getLivros().indexOf(busca);
						biblioteca.getLivros().get(index).setDisponivel(false);
						System.out.println("Livro emprestado, indisponivel para futuros imprestimos");
						emprestimos.add(new Emprestimo(biblioteca.getLivros().get(index), cliente));
					}
					System.out.println("deseja Faser outra operação?");
					resposta = s.nextLine();
				}while(resposta.equalsIgnoreCase("sim"));
				
			}
		}
		
	}

}
