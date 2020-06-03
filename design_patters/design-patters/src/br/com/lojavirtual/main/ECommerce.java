package br.com.lojavirtual.main;

import java.util.Scanner;

import javax.inject.Inject;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.design_patters.loja.controller.CarrinhoComprasController;
import br.com.design_patters.loja.dao.DAOGenerico;
import br.com.design_patters.loja.model.Frete;
import br.com.design_patters.loja.model.Produto;
import br.com.design_patters.loja.strategy.CalculoFrete;

public class ECommerce {

	public static void main(String[] args) {
		CarrinhoComprasController carrinho = new CarrinhoComprasController();
		int valorTotal, condiçãodepagamento;
		String valor, condicao; 

        Scanner numeros = new Scanner(System.in);

        System.out.println("");

        valor = JOptionPane.showInputDialog(null, " digite o Preço da Etiqueta R$: ");
        valorTotal = Integer.parseInt(valor);

        System.out.println("digite a condição de pagamento");

        condicao = JOptionPane.showInputDialog(null,"digite a condição de pagamento"+"\n"+ "1 -A vista em dinheiro ou cheque,recebe 10% de desconto " +"\n"
                		+"2 -A vista no cartão de crédito, recebe 5% de desconto" +"\n"
                		+"3 -em duas vezes,preço normal da etiqueta sem juros" +"\n"
                		+"4 -em tres vezes, preço normal da etiqueta mas juros de 10%");
        
        condiçãodepagamento = Integer.parseInt(condicao);
        
//        condiçãodepagamento = carrinho.calcularValorPagamento(condiçãodepagamento, valorTotal);

        switch (condiçãodepagamento) {

        case 1:

            condiçãodepagamento = (int) (valorTotal - valorTotal*0.10); 

            break;

        case 2:

            condiçãodepagamento = (int) (valorTotal - valorTotal*0.05);

            break;

        case 3:

            condiçãodepagamento = valorTotal / +0;

            break;

        case 4:
            condiçãodepagamento = (int) (valorTotal  + valorTotal*0.10);

            break;

        default:
            System.out.println("opção invalida");

        }// fim do metodo switch

        System.out.println("o valor da etiqueta é R$:" + condiçãodepagamento);

    
		
		
		
		Frete frete = new Frete();
		String prazoEntrega = "";
		
		
		
		String cep;
		cep = JOptionPane.showInputDialog(null, " Informe o CEP: ");
//		int cep = String.parseInt(numero); // Converte String em Int

		String uf;
		uf = JOptionPane.showInputDialog(null, " Informe o seu Estado: ");
		
		frete = carrinho.calcularFrete(cep);
		prazoEntrega = carrinho.calcularTempoFrete(uf);
		
		JOptionPane.showMessageDialog(null,"o valor total da compra é R$:" + condiçãodepagamento +"\n"+ "O valor do frete é: R$ "+frete.getValorFrete() +"\n" +prazoEntrega);
		


	}
	
	
}
