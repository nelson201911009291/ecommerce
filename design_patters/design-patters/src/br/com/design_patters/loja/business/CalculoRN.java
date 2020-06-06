package br.com.design_patters.loja.business;

import javax.inject.Inject;

import br.com.design_patters.loja.model.Frete;
import br.com.design_patters.loja.strategy.CalculaPagamentoStrategy;
import br.com.design_patters.loja.strategy.CalculoFrete;


public class CalculoRN implements CalculaPagamentoStrategy{
	
	@Inject
	CalculaPagamentoStrategy CalculaPagamentoStrategy = new CalculaPagamentoStrategy() {
		
		@Override
		public int calcularValorPagamento(int condicaoPagamento, int valorTotal) {
			// TODO Auto-generated method stub
			return 0;
		}
	};
	
	//Calcula o tempo em dias do frete
		public Frete calcularFrete(String cepDestino) {
			return CalculoFrete.calculaFrete(cepDestino);
		}
	
	//Calcula o tempo em dias do frete
	public String calcularTempoFrete(String estado) {
		return CalculoFrete.CalcularTempoFrete(estado);
	}

	//Calcula valor total com descontos e jusros
	public int calcularValorPagamento(int condicaoPagamento, int valorTotal) {
		condicaoPagamento  = calcularDescontoDez(condicaoPagamento, valorTotal);
		condicaoPagamento = calcularDescontoCinco(condicaoPagamento, valorTotal);
		condicaoPagamento = calcularSemJuros(condicaoPagamento, valorTotal);
		condicaoPagamento = calcularJurosDez(condicaoPagamento, valorTotal); 
		return condicaoPagamento;
	}
	
	
	
	private int calcularDescontoDez(int condicaoPagamento, int valorTotal) {
		if(condicaoPagamento == 1) {
			CalculaPagamentoStrategy.calcularValorPagamento(condicaoPagamento, valorTotal);
			condicaoPagamento = (int) (valorTotal - valorTotal*0.10);
		}
		
		return condicaoPagamento;
	}
	
	private int calcularDescontoCinco(int condicaoPagamento, int valorTotal) {
		if(condicaoPagamento == 2) {
			CalculaPagamentoStrategy.calcularValorPagamento(condicaoPagamento, valorTotal);
			condicaoPagamento = (int) (valorTotal - valorTotal*0.05);
		}
		
		return condicaoPagamento;
	}
	
	private int calcularSemJuros(int condicaoPagamento, int valorTotal) {
		if(condicaoPagamento == 3) {
			CalculaPagamentoStrategy.calcularValorPagamento(condicaoPagamento, valorTotal);
			condicaoPagamento = valorTotal / + 0;
		}
		return condicaoPagamento;
	}
	
	private int calcularJurosDez(int condicaoPagamento, int valorTotal) {
		if(condicaoPagamento == 4) {
		condicaoPagamento = CalculaPagamentoStrategy.calcularValorPagamento(condicaoPagamento, valorTotal);
		condicaoPagamento = (int) (valorTotal + valorTotal*0.05);
		}
		return condicaoPagamento;
	}

}
