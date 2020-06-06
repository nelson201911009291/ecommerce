package br.com.design_patters.loja.strategy;

public interface CalculaPagamentoStrategy {

	int calcularValorPagamento(int condicaoPagamento, int valorTotal);
	
}
	
	
