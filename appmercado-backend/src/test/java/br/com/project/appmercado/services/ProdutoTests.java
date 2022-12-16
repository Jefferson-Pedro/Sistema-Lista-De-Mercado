package br.com.project.appmercado.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.project.appmercado.DAO.ProdutoDAO;
import br.com.project.appmercado.model.Produto;
import br.com.project.appmercado.service.ProdutoServiceImpl;


@SpringBootTest
@ActiveProfiles("test")
public class ProdutoTests {
	
	@InjectMocks
	private ProdutoServiceImpl service;
	
	@Mock
	private ProdutoDAO dao;
	
	private Integer existeId = 1;
	private Integer naoExisteId = 100;
	private String chave = "biscoito";
	private Produto novoProduto;
	private Produto criaProduto;
	private ArrayList<Produto> listaDeProdutos;
	
	@BeforeEach
	public void setup() throws Exception{
		novoProduto = new Produto();
		novoProduto.setNome("Biscoito");
		
		criaProduto = new Produto();
		criaProduto.setId(1);
		criaProduto.setNome("Biscoito");
		
		listaDeProdutos = new ArrayList<Produto>();
		Produto p1, p2;
		p1 = new Produto();
		p1.setId(2);
		p1.setNome("Biscoito rechado");
		
		p2 = new Produto();
		p2.setId(3);
		p2.setNome("Biscoito salgado");
		listaDeProdutos.add(p1);
		listaDeProdutos.add(p2);
		
		
		Mockito.when(dao.save(novoProduto)).thenReturn(criaProduto);
		Mockito.when(dao.findById(existeId)).thenReturn(Optional.of(criaProduto));
		Mockito.when(dao.findById(naoExisteId)).thenReturn(Optional.ofNullable(null));
		Mockito.when(dao.findAllByNomeContaining("Bolacha")).thenReturn(new ArrayList<Produto>());
		Mockito.when(dao.findAllByNomeContaining(chave)).thenReturn(listaDeProdutos);
		
		
	}
	
	@Test
	public void deveriaCadastrarProduto() {
		assertEquals(service.criarNovoProduto(novoProduto), criaProduto);
	}
	@Test
	public void deveriaRetornarPeloId() {
		assertNotNull(service.buscarPorId(existeId));
	}
	@Test
	public void deveriaNaoEncontrarId() {
		assertNull(service.buscarPorId(naoExisteId));
	}
	@Test
	public void deveriaRetornarListaComPalavraChave() {
		assertTrue(service.buscarPalavraChave(chave).size() > 0);
	}
	@Test
	public void deveriaRetornarListaVazia() {
		assertTrue(service.buscarPalavraChave("Biscoito").size() == 0);
	}
}
