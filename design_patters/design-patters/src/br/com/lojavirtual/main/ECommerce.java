package br.com.lojavirtual.main;

import javax.swing.JOptionPane;

import br.com.design_patters.loja.controller.CarrinhoController;
import br.com.design_patters.loja.model.Frete;
import br.com.design_patters.loja.model.Produto;

public class ECommerce {

	public static void main(String[] args) {
		CarrinhoController carrinho = new CarrinhoController();
		Produto produto1 = gerarDadosProdutos(600.0);
		Produto produto2 = gerarDadosProdutos(400.00);
		
		carrinho.adicionarProduto(produto1);
		carrinho.adicionarProduto(produto2);
		
		Double valor = carrinho.getTotal();
		Integer quantidadeProdutos = carrinho.getQuantidade();
		int valorTotal, condicaoPagamento;
		String condicao; 
        valorTotal = (int) Double.parseDouble(valor.toString());

        condicao = JOptionPane.showInputDialog(null,"Quantidade de Produtos Selecionados:"+quantidadeProdutos+"\n"
        				+"Valor Produtos Selecionados R$:"+valor+"\n"+"\n"
						+"Digite a condição de pagamento"+"\n"+"\n"
        				+ "1 -A vista em dinheiro ou cheque,recebe 10% de desconto " +"\n"
                		+"2 -A vista no cartão de crédito, recebe 5% de desconto" +"\n"
                		+"3 -em duas vezes,preço normal da etiqueta sem juros" +"\n"
                		+"4 -em tres vezes, preço normal da etiqueta mas juros de 10%");
        
        condicaoPagamento = Integer.parseInt(condicao);
        
        condicaoPagamento = carrinho.calcularValorPagamento(condicaoPagamento, valorTotal);
        
		// Calculo de Frete e parazo de entrega
		Frete frete = new Frete();
		String prazoEntrega = "";
		
		String cep;
		cep = JOptionPane.showInputDialog(null, " Informe o CEP: ");

		String uf;
		uf = JOptionPane.showInputDialog(null, " Informe o seu Estado: ");
		
		frete = carrinho.calcularFrete(cep);
		prazoEntrega = carrinho.calcularTempoFrete(uf);
		
		JOptionPane.showMessageDialog(null,"o valor total da compra é R$:" + condicaoPagamento +"\n"+ "O valor do frete é: R$ "+frete.getValorFrete() +"\n" +prazoEntrega);

	}
	
	private static Produto gerarDadosProdutos(Double preco) {
		Produto produto = new Produto();
		produto.setPreco(preco);
		
		return produto;
	}
	
}
