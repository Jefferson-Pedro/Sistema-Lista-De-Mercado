package br.com.project.appmercado.service;

import br.com.project.appmercado.model.ItemLista;

public interface IItemListaService {
	
	public ItemLista inserirItem(ItemLista novo);
	public ItemLista alterarItem(ItemLista item);
	public void removerItem(Integer numSeq);
}
