package br.com.design_patters.loja.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;

import br.com.design_patters.loja.business.CalculoRN;
import br.com.design_patters.loja.dao.DAOGenerico;
import br.com.design_patters.loja.model.Frete;
import br.com.design_patters.loja.model.Produto;

public class ECommerceFacade{
	
	@Inject
	private DAOGenerico dao;
	
	@EJB
	private CalculoRN calculoRN = new CalculoRN();
	
	
	public Frete calculaFrete(String cepDestino) {
		return calculoRN.calcularFrete(cepDestino);
	}
	
	public String calcularTempoFrete(String estado) {
		return calculoRN.calcularTempoFrete(estado) ;
	}

	public int calcularValorPagamento(int condicaoPagamento, int valorTotal) {
		return calculoRN.calcularValorPagamento(condicaoPagamento, valorTotal);
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> preenherListaProduto() {
		return dao.listar(Produto.class);
	}
	
}
