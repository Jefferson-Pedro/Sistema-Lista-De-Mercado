package br.com.project.appmercado.DAO;

import org.springframework.data.repository.CrudRepository;

import br.com.project.appmercado.model.ItemLista;

public interface ItemListaDAO extends CrudRepository<ItemLista, Integer> {
	
	//public List<Produto> findAllByNomeContaining(String palavraChave);
}

/*		---Appendix C: Repository query keywords

https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords

*/