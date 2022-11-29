package br.com.project.appmercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.project.appmercado.DAO.ItemListaDAO;
import br.com.project.appmercado.model.ItemLista;

@Component
public class ItemListaImpl implements IItemListaService{

	@Autowired
	private ItemListaDAO dao;
	
	@Override
	public ItemLista inserirItem(ItemLista novo) {
		return dao.save(novo);	
	}

	@Override
	public ItemLista alterarItem(ItemLista item) {
		return dao.save(item);
	}

	@Override
	public void removerItem(Integer numSeq) {
		 dao.deleteById(numSeq);;
	}

}
