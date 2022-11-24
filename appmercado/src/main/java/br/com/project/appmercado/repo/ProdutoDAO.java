package br.com.project.appmercado.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.project.appmercado.model.Produto;

public interface ProdutoDAO extends CrudRepository<Produto, Integer> {

}
