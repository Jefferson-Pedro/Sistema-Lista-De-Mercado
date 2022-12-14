package br.com.project.appmercado.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.project.appmercado.model.Produto;

public interface ProdutoDAO extends CrudRepository<Produto, Integer> {
	
	public List<Produto> findAllByNomeContaining(String palavraChave);
}
