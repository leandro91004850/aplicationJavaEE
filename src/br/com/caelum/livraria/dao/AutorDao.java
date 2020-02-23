package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;

@Stateless // tranformando a class em uma EJB
public class AutorDao {

	@Inject
	private Banco banco;
	
	@PostConstruct // para ser chamado pelo proprio EJB containner
	void aposCriacao() {
		System.out.println("autorDao foi criado");
	}

	public void salva(Autor autor) {
		System.out.println("Salvando autor" + autor.getNome());
		// controlando o tempo de cada inserção de dados no base de dados
		try {
		Thread.sleep(2000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		banco.save(autor);
		System.out.println("Salvou autor" + autor.getNome());
	}
	
	public List<Autor> todosAutores() {
		return banco.listaAutores();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.banco.buscaPelaId(autorId);
		return autor;
	}
	
}
