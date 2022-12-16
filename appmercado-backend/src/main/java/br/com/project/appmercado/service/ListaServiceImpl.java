package br.com.project.appmercado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.project.appmercado.DAO.ListaDAO;
import br.com.project.appmercado.model.ItemLista;
import br.com.project.appmercado.model.Lista;


@Component
public class ListaServiceImpl implements IListaService {
	
	@Autowired
	private ListaDAO dao;

	@Override
	public Lista criarNovaLista(Lista nova) {
		
		return dao.save(nova);
	}

	@Override
	public void removerLista(Integer id) {
		
		dao.deleteById(id);
		
	}

	@Override
	public Lista fecharLista(Integer id) {
		Lista L = dao.findById(id).get();
		double total = 0.0;
		for(ItemLista item : L.getItens()) {
			total += L.getValorTotal();
		}
		L.setValorTotal(total);
		L.setStatus(1); //lista concluída
		return dao.save(L);
	}

	@Override
	public Lista buscarPorId(Integer id) {
		
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<Lista> buscarTodos() {
	
		return (List<Lista>) dao.findAll();
	}
	
}
