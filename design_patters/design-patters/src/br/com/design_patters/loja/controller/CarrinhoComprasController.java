package br.com.design_patters.loja.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.design_patters.loja.model.Produto;
import br.com.design_patters.loja.patters.ProdutoFacade;
import br.com.design_patters.loja.utils.CalculoFrete;
import br.com.design_patters.loja.utils.Frete;

	@ManagedBean
	@SessionScoped
	public class CarrinhoComprasController implements Serializable{
	
	private static final long serialVersionUID = 3704720597267178326L;
	
	private ProdutoFacade produtoFacade;
//	private DAOGenerico dao = new DAOGenerico();
	private List<Produto> listaProdutos = new ArrayList<>();
	private Produto produto = new Produto();
	private List<Produto> produtos = new ArrayList<>();
	private Double total = 0.;
	private Integer quantidade = 0;
	Frete frete = new Frete();
	private String cepDestino = "";
	
	public CarrinhoComprasController() {
		preenherListaProduto();
	}

	/**
	 * Metodo para adcionar os produtos a lista, essa lista corresponde aos
	 * itens que o cliente comprou
	 */
	public void adicionarProduto(Produto prod) {
		this.produtos.add(prod);
		this.total += prod.getPreco();
		quantidade++;
	}

	/**
	 * Este metodo tem como objetivo adicionar ao atributo lista produto, os
	 * produtos cadastrados no banco de dados
	 */
	@SuppressWarnings("unchecked")
	public void preenherListaProduto() {
		listaProdutos = produtoFacade.preenherListaProduto();
	}

	/**
	 * Este metodo tem o objetiva redirecionar o usu�rio a outra pagina, quando
	 * clicar no bot�o de finalizar compra
	 */
	public String finalizarCompra() {
		return "itens_comprados.xhtml";
	}

	/**
	 * Informar o valor do cep do usu�rio
	 */
	public Frete calcularFrete(String cepDestino) {
		return frete = CalculoFrete.calculaFrete(cepDestino);
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getCepDestino() {
		return cepDestino;
	}

	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}

	public Frete getFrete() {
		return frete;
	}

	public void setFrete(Frete frete) {
		this.frete = frete;
	}
	
	}
