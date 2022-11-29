package br.com.project.appmercado.service;

import java.util.List;

import br.com.project.appmercado.model.Lista;

public interface IListaService {
	public Lista criarNovaLista(Lista nova);
	public void removerLista(Integer id);
	public Lista fecharLista(Integer id);
	public Lista buscarPorId(Integer id);
	public List<Lista> buscarTodos();
}	
