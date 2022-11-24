package br.com.project.appmercado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.project.appmercado.model.Produto;
import br.com.project.appmercado.repo.ProdutoDAO;


@Component
public class ProdutoServiceImpl implements IProdutoService {
	
	@Autowired
	private ProdutoDAO ProdDAO;
	
	@Override
	public Produto criarNovoProduto(Produto prod) {
		
		return ProdDAO.save(prod);
	}

	@Override
	public Produto alterarProduto(Produto prod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> buscarPalavraChave(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
