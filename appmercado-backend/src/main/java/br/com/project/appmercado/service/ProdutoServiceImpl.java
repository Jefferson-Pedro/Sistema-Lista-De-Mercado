package br.com.project.appmercado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.project.appmercado.DAO.ProdutoDAO;
import br.com.project.appmercado.model.Produto;


@Component
public class ProdutoServiceImpl implements IProdutoService {
	
	@Autowired  
	private ProdutoDAO ProdDAO;
	
	@Override
	public Produto criarNovoProduto(Produto prod) {
		if (prod.getNome() == null || prod.getNome().length() == 0)
			return null;
		return ProdDAO.save(prod);
	}

	@Override
	public List<Produto> listarTodos() {
		// TODO Auto-generated method stub
		return (List<Produto>)ProdDAO.findAll();
	}

	@Override
	public List<Produto> buscarPalavraChave(String key) {
		// TODO Auto-generated method stub
		return ProdDAO.findAllByNomeContaining(key);
	}

	@Override
	public Produto buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return ProdDAO.findById(id).orElse(null);
	}

}
