package br.com.project.appmercado.service;

import java.util.List;

import br.com.project.appmercado.model.Produto;

public interface IProdutoService {
	  
	public Produto criarNovoProduto(Produto prod);
	public Produto alterarProduto(Produto prod);
	public Produto buscarPorId(Integer id);
	
	public List<Produto> listarTodos();
	public List<Produto> buscarPalavraChave(String key);	
}
