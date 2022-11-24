package br.com.project.appmercado.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.project.appmercado.model.Produto;
import br.com.project.appmercado.service.IProdutoService;
import br.com.project.appmercado.service.ProdutoServiceImpl;


@SpringBootTest
@ActiveProfiles("test")
public class ProdutoTests {
	
	@Autowired
	private IProdutoService service;
	//private static ProdutoServiceImpl service;
	private static Integer idFound = 1;
	private static Integer idNotFound = 100;
	private static Produto newProduct;
	private static Produto createdProduct;
	
	@BeforeAll
	public static void setup() {
		System.out.println("Configurando parametros de testes");
		newProduct = new Produto();
		newProduct.setNome("Suco");
		
		createdProduct = new Produto();
		createdProduct.setNome("Biscoito");
		createdProduct.setId(1);
		
		//Simulador de chamadas
		/*service = Mockito.mock(ProdutoServiceImpl.class);
		Mockito.when(service.criarNovoProduto(newProduct)).thenReturn(createdProduct);
		Mockito.when(service.buscarPorId(idFound)).thenReturn(createdProduct);
		Mockito.when(service.buscarPorId(idNotFound)).thenReturn(null);
		Mockito.when(service.buscarPalavraChave("b")).thenReturn(new ArrayList<Produto>());
		Mockito.when(service.listarTodos()).thenReturn(new ArrayList<Produto>());*/
	}
	
	@Test
	public void shouldStoreProduct() {
		assertNotNull(service.criarNovoProduto(newProduct));
		
		System.out.println("É pra funcionar!!!");
	}
}
