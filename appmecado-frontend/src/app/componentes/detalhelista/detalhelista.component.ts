import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ItemLista } from 'src/app/model/ItemLista';
import { Lista } from 'src/app/model/Lista';
import { Produto } from 'src/app/model/Produto';
import { ItemlistaService } from 'src/app/servicos/itemlista.service';
import { ListasService } from 'src/app/servicos/listas.service';
import { ProdutosService } from 'src/app/servicos/produtos.service';

@Component({
  selector: 'app-detalhelista',
  templateUrl: './detalhelista.component.html',
  styleUrls: ['./detalhelista.component.css']
})
export class DetalhelistaComponent {

  public listaProdutos: Produto[] = [];
  public novoProduto: Produto;
  public novoItem: ItemLista;
  public formNovoProduto: Boolean = false;
  public idLista: number = 0;
  public listaCompras: Lista = new Lista();

  constructor(private produtoService: ProdutosService, 
              private activateRoute: ActivatedRoute, 
              private itemListaSrv: ItemlistaService,
              private listaService: ListasService){

    this.novoProduto = new Produto();
    this.novoItem = new ItemLista();
    this.idLista = this.activateRoute.snapshot.params['id'];
    console.log("Id da lista recuperado = " +this.idLista);
  }

  ngOnInit(): void {
    this.recuperarTodosOsProdutos();
    this.recuperarDetalhesDaLista(this.idLista);
  }

  public recuperarDetalhesDaLista(idLista: number){
    this.listaService.recuperarPorId(this.idLista).subscribe({
      next: (res: Lista) => {
        this.listaCompras = res;
        console.log(res);
      },
      error: (err) => {
        alert("Erro ao recuperar as Listas de Compras")
      }
    });
  }

  public recuperarTodosOsProdutos(){
    this.produtoService.retornaTodosProdutos().subscribe({
      next: (res: Produto[]) => {
        this.listaProdutos = res;
      },
      error: (err) => {
        alert("Erro ao recuperar as Listas de Produtos")
      }
    });
  }

  public exibirModal(){
    document.getElementById("btnModal")?.click();
  }

  public habilitarNovoProduto(){
    this.formNovoProduto = true;
  }

  public cadastrarNovoProduto(){
    this.produtoService.addNovoProduto(this.novoProduto).subscribe({
      next: () => {  
        alert("Produto cadastrado com sucesso! 😉")
        this.novoProduto = new Produto();
        this.recuperarTodosOsProdutos();
    },
      error: (erro) => {
        alert("Erro! Não foi possivel cadastrar novo produto. 😞");
      }
    });
    this.formNovoProduto = false;
  }

  public adicionarItemNaLista(){
    this.novoItem.lista.id = this.idLista;
    this.itemListaSrv.adicionarNovoItem(this.novoItem).subscribe({
      next: (res: ItemLista) => {  
        alert("Item cadastrado com sucesso! 😉")
        this.novoItem = new ItemLista();
        this.recuperarDetalhesDaLista(this.idLista);
    },
      error: (erro) => {
        alert("Erro! Não foi possivel cadastrar novo produto. 😞");
      }
    });
  }
}
